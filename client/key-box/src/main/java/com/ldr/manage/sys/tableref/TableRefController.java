package com.ldr.manage.sys.tableref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【表引用关系】控制器
 * @author 高振中
 * @date 2021-04-30 23:37:26
 **/
//@Slf4j
@RestController
@RequestMapping("tableRef")
public class TableRefController {

	@Autowired
	private TableRefService tableRefService; // 注入【表引用关系】业务逻辑层

	/**
	 * @方法说明 【表引用关系】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated TableRef tableRef) {
		if (tableRefService.count(TableRefCond.builder().mainTableEq(tableRef.getMainTable()).subTableEq(tableRef.getSubTable())//
				.refIdEq(tableRef.getRefId()).build()) > 0)
			return Result.error(1, "【主表表名,子表表名,外键名称】组合不能重复！");
		return Result.success(tableRefService.save(tableRef));
	}

	/**
	 * @方法说明 【表引用关系】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(tableRefService.delete(ids));
	}

	/**
	 * @方法说明 【表引用关系】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated TableRef tableRef) {
		if (tableRefService.count(TableRefCond.builder().mainTableEq(tableRef.getMainTable()).subTableEq(tableRef.getSubTable())//
				.refIdEq(tableRef.getRefId()).idNe(tableRef.getId()).build()) > 0)
			return Result.error(1, "【主表表名,子表表名,外键名称】组合不能重复！");
		return Result.success(tableRefService.update(tableRef));
	}

	/**
	 * @方法说明 【表引用关系】分页列表
	 */
	@PostMapping("page")
	public Result<Page<TableRef>> page(@RequestBody TableRefCond cond) {
		return Result.success(tableRefService.page(cond));
	}

}