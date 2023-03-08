package com.ldr.manage.base.baseuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【用户】控制器
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@RestController
@RequestMapping("baseUser")
public class BaseUserController {

	@Autowired
	private BaseUserService baseUserService; // 注入【用户】业务逻辑层

	/**
	 * @方法说明 【用户】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseUser baseUser) {
		//if (baseUserService.count(BaseUserCond.builder().nameEq(baseUser.getName()).build()) > 0)
			//return Result.error(1, "【用户名称】不能重复！");
		return Result.success(baseUserService.save(baseUser));
	}

	/**
	 * @方法说明 【用户】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseUserService.delete(ids));
	}

	/**
	 * @方法说明 【用户】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseUser baseUser) {
		//if (baseUserService.count(BaseUserCond.builder().nameEq(baseUser.getName()).idNe(baseUser.getId()).build()) > 0)
			//return Result.error(1, "【用户名称】不能重复！");
		return Result.success(baseUserService.update(baseUser));
	}

	/**
	 * @方法说明 【用户】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseUser>> page(@RequestBody BaseUserCond cond) {
		return Result.success(baseUserService.page(cond));
	}
 
}