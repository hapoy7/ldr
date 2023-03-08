package com.ldr.manage.sys.roleuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;
import com.ldr.manage.sys.roleuser.vo.Auth;

import io.swagger.annotations.Api;

/**
 * @类说明 【角色用户关联】控制器
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Api(tags = "【角色相关】API")
@RestController
@RequestMapping("roleUser")
public class RoleUserController {

	@Autowired
	private RoleUserService roleUserService; // 注入【角色用户关联】业务逻辑层

	@AutoLog("【角色用户关联】列表")
	@PostMapping("list")
	public Result<Auth> list(@RequestBody RoleUserCond cond) {
		return Result.success(roleUserService.auth(cond));
	}

	@AutoLog("【角色用户关联】批量保存")
	@PostMapping("save")
	public Result<Void> insertBatch(@RequestBody List<Long> userIds, Long roleId) {
		roleUserService.insertBatch(userIds, roleId);
		return Result.success();
	}
}