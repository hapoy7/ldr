package com.ldr.manage.sys.dept;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.config.Result;

/**
 * 【组织机构】控制器
 * @author 高振中
 * @date 2021-04-13 00:30:04
 **/
//@Slf4j
@RestController
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private DeptService deptService; // 注入【组织机构】业务逻辑层

	/**
	 * 【组织机构】树
	 */
	@PostMapping("tree")
	public Result<List<Dept>> tree() {
		return Result.success(deptService.tree());
	}

	/**
	 * 【组织机构】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated Dept dept) {
		if (deptService.count(DeptCond.builder().nameEq(dept.getName()).build()) > 0)
			return Result.error(1, "【组织机构名称】不能重复！");
		return Result.success(deptService.save(dept));
	}

	/**
	 * 【组织机构】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Dept dept) {
		if (deptService.count(DeptCond.builder().parentId(dept.getId()).build()) > 0)
			return Result.error(1, "【有下级】不能删除！");
		deptService.delete(dept);
		return Result.success();
	}

	/**
	 * 【组织机构】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated Dept dept) {
		if (deptService.count(DeptCond.builder().nameEq(dept.getName()).idNe(dept.getId()).build()) > 0)
			return Result.error(1, "【组织机构名称】不能重复！");
		return Result.success(deptService.update(dept));
	}

	/**
	 * 【组织机构】列表
	 */
	@PostMapping("list")
	public Result<List<Dept>> list(@RequestBody DeptCond cond) {
		return Result.success(deptService.list(cond));
	}
}