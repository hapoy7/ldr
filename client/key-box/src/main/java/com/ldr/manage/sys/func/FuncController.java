package com.ldr.manage.sys.func;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;

import io.swagger.annotations.Api;

/**
 * @类说明 【功能菜单】控制器
 * @author 高振中
 * @date 2020-11-10 23:19:07
 **/
@RestController
@RequestMapping("func")
@Api(tags = "【功能菜单】API")
public class FuncController {

	@Autowired
	private FuncService funcService; // 注入【功能菜单】业务逻辑层

	/**
	 * @方法说明 【功能菜单】新增
	 */
	@AutoLog("【功能菜单】新增")
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated Func func) {
		return Result.success(funcService.save(func));
	}

	/**
	 * @方法说明 【功能菜单】删除
	 */
	@AutoLog("【功能菜单】删除")
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Func func) {
		if (funcService.count(FuncCond.builder().parentId(func.getFuncId()).build()) > 0)
			return Result.error(1, "【有下级】不能删除！");
		funcService.delete(func);
		return Result.success();
	}

	/**
	 * @方法说明 【功能菜单】修改
	 */
	@AutoLog("【功能菜单】修改")
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated Func func) {
		return Result.success(funcService.update(func));
	}

	/**
	 * @方法说明 【功能菜单】列表
	 */
	@PostMapping("list")
	@AutoLog("【功能菜单】列表")
	public Result<List<Func>> list(@RequestBody FuncCond cond) {
		return Result.success(funcService.list(cond));
	}

	/**
	 * @方法说明 【功能菜单】树
	 */
	@PostMapping("tree")
	@AutoLog("【功能菜单】树")
	public Result<List<Func>> tree() {
		return Result.success(funcService.tree(null));
	}

}