package com.ldr.manage.base.basebox;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【钥匙柜】控制器
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@RestController
@RequestMapping("baseBox")
public class BaseBoxController {

	@Autowired
	private BaseBoxService baseBoxService; // 注入【钥匙柜】业务逻辑层

	/**
	 * @方法说明 【钥匙柜】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseBox baseBox) {
		//if (baseBoxService.count(BaseBoxCond.builder().nameEq(baseBox.getName()).build()) > 0)
			//return Result.error(1, "【钥匙柜名称】不能重复！");
		return Result.success(baseBoxService.save(baseBox));
	}

	/**
	 * @方法说明 【钥匙柜】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseBoxService.delete(ids));
	}

	/**
	 * @方法说明 【钥匙柜】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseBox baseBox) {
		//if (baseBoxService.count(BaseBoxCond.builder().nameEq(baseBox.getName()).idNe(baseBox.getId()).build()) > 0)
			//return Result.error(1, "【钥匙柜名称】不能重复！");
		return Result.success(baseBoxService.update(baseBox));
	}

	/**
	 * @方法说明 【钥匙柜】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseBox>> page(@RequestBody BaseBoxCond cond) {
		return Result.success(baseBoxService.page(cond));
	}
	/**
	 * @方法说明 【钥匙柜】列表
	 */
	@PostMapping("list")
	public Result<List<BaseBox>> list(@RequestBody BaseBoxCond cond) {
		return Result.success(baseBoxService.list(cond));
	}
}