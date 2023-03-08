package com.ldr.manage.sys.roledept;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;
import com.ldr.manage.sys.dept.DeptService;

import io.swagger.annotations.Api;

/**
 * @类说明 【角色部门关联】控制器
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@RestController
@RequestMapping("roleDept")
@Api(tags = "【角色相关】API")
public class RoleDeptController {
	@Autowired
	private RoleDeptService roleDeptService; // 注入【角色部门关联】业务逻辑层
	@Autowired
	private DeptService deptService; // 注入【组织机构】业务逻辑层

	@AutoLog("【角色部门关联】-新增")
	@PostMapping("save")
	public Result<Void> save(@RequestBody List<RoleDept> list, Long roleId) {
		roleDeptService.insertBatch(list, roleId);
		return Result.success();
	}

	@AutoLog("【角色部门关联】-查询【部门】树和选中的部门")
	@PostMapping("tree")
	public Result<RoleDeptVO> tree(Long roleId) {
		List<Long> ids = roleDeptService.list(roleId).stream().map(RoleDept::getDeptId).collect(Collectors.toList());
		return Result.success(RoleDeptVO.builder().ids(ids).depts(deptService.tree()).build());
	}
}