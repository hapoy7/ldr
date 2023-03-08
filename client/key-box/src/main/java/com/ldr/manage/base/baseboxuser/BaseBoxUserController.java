package com.ldr.manage.base.baseboxuser;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @类说明 【钥匙柜用户关联】控制器
 * @author 杨来富
 * @date 2022-11-01 09:50:05
 **/
//@Slf4j
@RestController
@RequestMapping("baseBoxUser")

public class BaseBoxUserController {

	@Autowired
	private BaseBoxUserService baseBoxUserService; // 注入【钥匙柜用户关联】业务逻辑层

	/**
	 * @方法说明 【钥匙柜用户关联】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseBoxUser baseBoxUser) {
		//if (baseBoxUserService.count(BaseBoxUserCond.builder().nameEq(baseBoxUser.getName()).build()) > 0)
			//return Result.error(1, "【钥匙柜用户关联名称】不能重复！");
		return Result.success(baseBoxUserService.save(baseBoxUser));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseBoxUserService.delete(ids));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseBoxUser baseBoxUser) {
		//if (baseBoxUserService.count(BaseBoxUserCond.builder().nameEq(baseBoxUser.getName()).idNe(baseBoxUser.getId()).build()) > 0)
			//return Result.error(1, "【钥匙柜用户关联名称】不能重复！");
		return Result.success(baseBoxUserService.update(baseBoxUser));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseBoxUser>> page(@RequestBody BaseBoxUserCond cond) {
		return Result.success(baseBoxUserService.page(cond));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】列表
	 */
	@PostMapping("list")
	public Result<List<BaseBoxUser>> list(@RequestBody BaseBoxUserCond cond) {
		return Result.success(baseBoxUserService.list(cond));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】按主键查
	 */
	@PostMapping("findById")
	public Result<BaseBoxUser> findById(@RequestParam("id") Long id) {
		return Result.success(baseBoxUserService.findById(id));
	}

	/**
	 * @方法说明 【钥匙柜用户关联】个数
	 */
	@PostMapping("count")
	public Result<Integer> count(@RequestBody BaseBoxUserCond cond) {
		return Result.success(baseBoxUserService.count(cond));
	}
}