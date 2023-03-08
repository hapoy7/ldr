package com.ldr.manage.sys.dictitem;

import java.util.List;
import java.util.Map;

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
 * @类说明 【字典项】控制器
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@RestController
@RequestMapping("dictItem")
@Api(tags = "【枚举字典】API")
public class DictItemController {

	@Autowired
	private DictItemService dictItemService; // 注入【字典项】业务逻辑层

	@PostMapping("save")
	@AutoLog("【字典项】新增")
	public Result<Long> save(@RequestBody @Validated DictItem dictItem) {
		if (dictItemService.count(DictItemCond.builder().value(dictItem.getValue()).dictId(dictItem.getDictId()).build()) > 0)
			return Result.error(1, "【字典项】编码不能重复！");
		if (dictItemService.count(DictItemCond.builder().textEq(dictItem.getText()).dictId(dictItem.getDictId()).build()) > 0)
			return Result.error(2, "【字典项】文本不能重复！");
		return Result.success(dictItemService.save(dictItem));
	}

	@PostMapping("delete")
	@AutoLog("【字典项】删除")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(dictItemService.delete(ids));
	}

	@AutoLog("【字典项】修改")
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated DictItem dictItem) {
		if (dictItemService.count(DictItemCond.builder().value(dictItem.getValue()).dictId(dictItem.getDictId()).idNe(dictItem.getId()).build()) > 0)
			return Result.error(1, "【字典项】编码不能重复！");
		if (dictItemService.count(DictItemCond.builder().textEq(dictItem.getText()).dictId(dictItem.getDictId()).idNe(dictItem.getId()).build()) > 0)
			return Result.error(2, "【字典项】文本不能重复！");
		return Result.success(dictItemService.update(dictItem));
	}

	@AutoLog("【字典项】列表")
	@PostMapping("list")
	public Result<List<DictItem>> list(@RequestBody DictItemCond cond) {
		return Result.success(dictItemService.list(cond));
	}

	@PostMapping("all")
	public Result<Map<String, List<DictVO>>> all() {
		return Result.success(dictItemService.dicts());
	}

}