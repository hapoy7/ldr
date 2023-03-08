package com.ldr.manage.sys.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.base.Page;
import com.ldr.common.config.Result;
import com.ldr.manage.sys.dictitem.DictItemCond;
import com.ldr.manage.sys.dictitem.DictItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 【枚举字典】控制器
 * @author 高振中
 * @date 2020-12-19 21:18:17
 **/

@RestController
@RequestMapping("dict")
@Api(tags = "【枚举字典】API")
public class DictController {

	@Autowired
	private DictService dictService; // 注入【字典】业务逻辑层
	@Autowired
	private DictItemService dictItemService; // 注入【字典项】业务逻辑层

	/**
	 * @方法说明 【枚举字典】新增
	 */
	@AutoLog("【枚举字典】新增")
	@PostMapping("save")
	@ApiOperation(value = "【枚举字典】新增", notes = "【枚举字典】新增")
	public Result<Long> save(@RequestBody @Validated Dict dict) {
		if (dictService.count(DictCond.builder().codeEq(dict.getCode()).build()) > 0)
			return Result.error(1, "【字典类型编码】不能重复！");
		if (dictService.count(DictCond.builder().nameEq(dict.getName()).build()) > 0)
			return Result.error(2, "【字典类型名称】不能重复！");
		return Result.success(dictService.save(dict));
	}

	/**
	 * @方法说明 【枚举字典】删除
	 */
	@AutoLog("【枚举字典】删除")
	@PostMapping("delete")
	@ApiOperation(value = "【枚举字典】删除", notes = "【枚举字典】删除")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		if (dictItemService.count(DictItemCond.builder().dictIds(ids).build()) > 0)
			return Result.error(1, "该类别存在【字典项】,不能删除！");
		return Result.success(dictService.delete(ids));
	}

	/**
	 * @方法说明 【枚举字典】修改
	 */
	@AutoLog("【枚举字典】修改")
	@PostMapping("update")
	@ApiOperation(value = "【枚举字典】修改", notes = "【枚举字典】修改")
	public Result<Integer> update(@RequestBody @Validated Dict dict) {
		if (dictService.count(DictCond.builder().codeEq(dict.getCode()).idNe(dict.getId()).build()) > 0)
			return Result.error(1, "【字典类型编码】不能重复！");
		if (dictService.count(DictCond.builder().nameEq(dict.getName()).idNe(dict.getId()).build()) > 0)
			return Result.error(2, "【字典类型名称】不能重复！");
		return Result.success(dictService.update(dict));
	}

	/**
	 * @方法说明 【枚举字典】分页列表
	 */
	@PostMapping("page")
	@AutoLog("【枚举字典】分页列表")
	@ApiOperation(value = "【枚举字典】分页列表", notes = "【枚举字典】分页列表")
	public Result<Page<Dict>> page(@RequestBody DictCond cond) {
		return Result.success(dictService.page(cond));
	}

}