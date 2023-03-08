package com.ldr.common.aop;

import java.time.LocalDateTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.ldr.common.filter.JwtTools;
import com.ldr.manage.sys.log.Log;
import com.ldr.manage.sys.log.LogDao;
import com.ldr.manage.sys.user.User;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @summary 【日志记录】切面
 * @author 高振中
 * @date 2021-03-12
 */
@Aspect
@Component
public class AutoLogAop {
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private Cache<Long, User> userCache;// 用于存放用户登录信息的guava缓存
	@Autowired
	private LogDao logDao; // 注入【系统日志】数据访问层

	@Around("execution(public * com.ldr.manage..*.*Controller.*(..)) && @annotation(autoLog)")
	public Object beforeLog(ProceedingJoinPoint point, AutoLog autoLog) throws Throwable {
		Object result = point.proceed();
		User user = User.builder().userId(-1L).name("见参数").build();// 登录时没有用户名与ID
		if (StringUtils.hasLength(request.getHeader("token")))
			user = userCache.getIfPresent(JwtTools.getUserId(request.getHeader("token")));
		Log vo = Log.builder().ip(request.getRemoteAddr()).userId(user.getUserId()).userName(user.getName()).title(autoLog.value()).url(request.getServletPath())
				.method(point.getSignature().toShortString()).requestType(request.getMethod()).result(mapper.writeValueAsString(result)).operateTime(LocalDateTime.now())
				.params("[body]:" + mapper.writeValueAsString(point.getArgs()) + ",[param]:" + mapper.writeValueAsString(request.getParameterMap())).build();
		logDao.save(vo);
		return result;
	}

}
