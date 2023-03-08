package com.ldr.common.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ldr.manage.sys.request.Request;
import com.ldr.manage.sys.request.RequestService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @summary【请求时长统计】过滤器
 * @author 高振中
 * @date 2020-12-28 18:18:18
 **/
@Component
public class HttpRequestTimeFilter extends OncePerRequestFilter {

	@Value("${spring.application.name}")
	private String applicationName;// 当前应用名称

	@Autowired
	private RequestService requestService;// 计算逻辑与入库

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String path = request.getServletPath();
		if (PathTools.isSwagger(path)) {
			filterChain.doFilter(request, response);
			return;
		}
		Request curRequest = new Request();
		curRequest.setAppName(applicationName);
		curRequest.setPath(path);
		curRequest.setType(PathTools.isFront(path));
		long startTime = System.currentTimeMillis();
		filterChain.doFilter(request, response);
		curRequest.setCurrentMilliSecond((int) (System.currentTimeMillis() - startTime));
		requestService.add(curRequest);

	}

}
