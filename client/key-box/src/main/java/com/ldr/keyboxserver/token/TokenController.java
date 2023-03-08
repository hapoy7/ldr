package com.ldr.keyboxserver.token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.cache.Cache;
import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;
import com.ldr.common.filter.JwtTools;
import com.ldr.manage.sys.user.User;
import com.ldr.manage.sys.user.UserCond;
import com.ldr.manage.sys.user.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 智能管控系统获取token的实体
 * @author keke
 * @date 2022/11/8 16:15
 **/
@RestController
@RequestMapping("sys")
@Api(tags = "【获取token】API")
public class TokenController {
	@Autowired
	private UserService userService; // 注入【用户】业务逻辑层
	@Autowired
	private Cache<Long, User> userCache; // 注入 缓存

	/**
	 * 智能管控系统获取token的方法
	 * 
	 * @param param 用户名 和 密码
	 * @return token
	 */
	@AutoLog("【智能管控系统获取token】")
	@PostMapping("token")
	@ApiOperation("【智能管控系统获取token】")
	public Result<TokenVO> getToken(@RequestBody TokenParam param) {
		// 根据用户的姓名查询用户
		List<User> users = userService.list(UserCond.builder().loginName(param.getName()).build());
		// 判断用户是否存在
		if (CollectionUtils.isEmpty(users))
			return Result.error(1, "用户不存在");

		// 判断密码是否正确
		User user = users.get(0);
		if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(param.getPassword().getBytes())))
			return Result.error(2, "密码不正确");

		String token = JwtTools.createToken(user.getUserId() + "");// 生成token
		userCache.put(user.getUserId(), user);// 放入缓存
		TokenVO vo = TokenVO.builder().user(user).token(token).build();
		return Result.success(vo);
	}

}
