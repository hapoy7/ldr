package com.ldr.manage.sys.role;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @类说明 【角色】控制器
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@RestController
@RequestMapping("role")
@Api(tags = "【角色相关】API")
public class RoleController {
	@Autowired
	private RoleService roleService; // 注入【角色】业务逻辑层

	/**
	 * @方法说明 【角色】新增
	 */
	@PostMapping("save")
	@AutoLog("【角色】新增")
	public Result<Long> save(@RequestBody @Validated Role role) {
		if (roleService.count(RoleCond.builder().nameEq(role.getName()).build()) > 0)
			return Result.error(1, "【角色名称】不能重复！");
		return Result.success(roleService.save(role));
	}

	/**
	 * @方法说明 【角色】删除
	 */

	@PostMapping("delete")
	@AutoLog("【角色】删除")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(roleService.delete(ids));
	}

	/**
	 * @方法说明 【角色】修改
	 */
	@PostMapping("update")
	@AutoLog("【角色】修改")
	public Result<Integer> update(@RequestBody @Validated Role role) {
		if (roleService.count(RoleCond.builder().nameEq(role.getName()).roleIdNe(role.getRoleId()).build()) > 0)
			return Result.error(1, "【角色名称】不能重复！");
		return Result.success(roleService.update(role));
	}

	/**
	 * @方法说明 【角色】分页列表
	 */
	@AutoLog("【角色】分页列表")
	@PostMapping("page")
	public Result<Page<Role>> page(@RequestBody RoleCond cond) {
		return Result.success(roleService.page(cond));
	}

	@PostMapping("export")
	public void export(@RequestBody RoleCond cond, HttpServletResponse response) throws IOException {
		roleService.export(cond, response);
	}

	@PostMapping("import")
	public Result<String> importExcel(@RequestPart("file") MultipartFile file) throws IOException {
		roleService.importExcel(file);
		return Result.success();
	}
}