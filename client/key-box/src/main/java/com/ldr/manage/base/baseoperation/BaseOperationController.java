package com.ldr.manage.base.baseoperation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【操作日志】控制器
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@RestController
@RequestMapping("baseOperation")

public class BaseOperationController {

	@Autowired
	private BaseOperationService baseOperationService; // 注入【操作日志】业务逻辑层

	/**
	 * @方法说明 【操作日志】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseOperation baseOperation) {
		//if (baseOperationService.count(BaseOperationCond.builder().nameEq(baseOperation.getName()).build()) > 0)
			//return Result.error(1, "【操作日志名称】不能重复！");
		return Result.success(baseOperationService.save(baseOperation));
	}

	/**
	 * @方法说明 【操作日志】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseOperationService.delete(ids));
	}

	/**
	 * @方法说明 【操作日志】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseOperation baseOperation) {
		//if (baseOperationService.count(BaseOperationCond.builder().nameEq(baseOperation.getName()).idNe(baseOperation.getId()).build()) > 0)
			//return Result.error(1, "【操作日志名称】不能重复！");
		return Result.success(baseOperationService.update(baseOperation));
	}

	/**
	 * @方法说明 【操作日志】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseOperation>> page(@RequestBody BaseOperationCond cond) {
		return Result.success(baseOperationService.page(cond));
	}

	/**
	 * @方法说明 【操作日志】列表
	 */
	@PostMapping("list")
	public Result<List<BaseOperation>> list(@RequestBody BaseOperationCond cond) {
		return Result.success(baseOperationService.list(cond));
	}

	/**
	 * @方法说明 【操作日志】按主键查
	 */
	@PostMapping("findById")
	public Result<BaseOperation> findById(@RequestParam("id") Long id) {
		return Result.success(baseOperationService.findById(id));
	}

	/**
	 * @方法说明 【操作日志】个数
	 */
	@PostMapping("count")
	public Result<Integer> count(@RequestBody BaseOperationCond cond) {
		return Result.success(baseOperationService.count(cond));
	}
}