package com.ldr.manage.base.basealert;

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
 * @类说明 【告警信息】控制器
 * @author 高振中
 * @date 2022-09-20 17:45:04
 **/
//@Slf4j
@RestController
@RequestMapping("baseAlert")
public class BaseAlertController {

	@Autowired
	private BaseAlertService baseAlertService; // 注入【告警信息】业务逻辑层

	/**
	 * @方法说明 【告警信息】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseAlert baseAlert) {
		//if (baseAlertService.count(BaseAlertCond.builder().nameEq(baseAlert.getName()).build()) > 0)
			//return Result.error(1, "【告警信息名称】不能重复！");
		return Result.success(baseAlertService.save(baseAlert));
	}

	/**
	 * @方法说明 【告警信息】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseAlertService.delete(ids));
	}

	/**
	 * @方法说明 【告警信息】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseAlert baseAlert) {
		//if (baseAlertService.count(BaseAlertCond.builder().nameEq(baseAlert.getName()).idNe(baseAlert.getId()).build()) > 0)
			//return Result.error(1, "【告警信息名称】不能重复！");
		return Result.success(baseAlertService.update(baseAlert));
	}

	/**
	 * @方法说明 【告警信息】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseAlert>> page(@RequestBody BaseAlertCond cond) {
		return Result.success(baseAlertService.page(cond));
	}

	/**
	 * @方法说明 【告警信息】列表
	 */
	@PostMapping("list")
	public Result<List<BaseAlert>> list(@RequestBody BaseAlertCond cond) {
		return Result.success(baseAlertService.list(cond));
	}

	/**
	 * @方法说明 【告警信息】按主键查
	 */
	@PostMapping("findById")
	public Result<BaseAlert> findById(@RequestParam("id") Long id) {
		return Result.success(baseAlertService.findById(id));
	}

	/**
	 * @方法说明 【告警信息】个数
	 */
	@PostMapping("count")
	public Result<Integer> count(@RequestBody BaseAlertCond cond) {
		return Result.success(baseAlertService.count(cond));
	}
}