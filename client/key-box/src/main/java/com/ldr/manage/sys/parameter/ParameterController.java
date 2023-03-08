package com.ldr.manage.sys.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【系统参数】控制器
 * @author 高振中
 * @date 2021-04-10 22:54:52
 **/
//@Slf4j
@RestController
@RequestMapping("parameter")

public class ParameterController {

	@Autowired
	private ParameterService parameterService; // 注入【系统参数】业务逻辑层

	/**
	 * @方法说明 【系统参数】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated Parameter parameter) {
		if (parameterService.count(ParameterCond.builder().paramNameEq(parameter.getParamName()).build()) > 0)
			return Result.error(1, "【系统参数名称】不能重复！");
		if (parameterService.count(ParameterCond.builder().paramKeyEq(parameter.getParamKey()).build()) > 0)
			return Result.error(1, "【系统参数键】不能重复！");
		return Result.success(parameterService.save(parameter));
	}

	/**
	 * @方法说明 【系统参数】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(parameterService.delete(ids));
	}

	/**
	 * @方法说明 【系统参数】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated Parameter parameter) {
		if (parameterService.count(ParameterCond.builder().paramNameEq(parameter.getParamName()).idNe(parameter.getId()).build()) > 0)
			return Result.error(1, "【系统参数名称】不能重复！");
		if (parameterService.count(ParameterCond.builder().paramKeyEq(parameter.getParamKey()).idNe(parameter.getId()).build()) > 0)
			return Result.error(1, "【系统参数键】不能重复！");
		return Result.success(parameterService.update(parameter));
	}

	/**
	 * @方法说明 【系统参数】分页列表
	 */
	@PostMapping("page")
	public Result<Page<Parameter>> page(@RequestBody ParameterCond cond) {
		return Result.success(parameterService.page(cond));
	}
 
}