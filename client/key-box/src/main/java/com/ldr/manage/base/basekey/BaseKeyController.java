package com.ldr.manage.base.basekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;

/**
 * @类说明 【钥匙】控制器
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@RestController
@RequestMapping("baseKey")
public class BaseKeyController {

	@Autowired
	private BaseKeyService baseKeyService; // 注入【钥匙】业务逻辑层

	/**
	 * @方法说明 【钥匙】新增
	 */
	@PostMapping("save")
	public Result<Long> save(@RequestBody @Validated BaseKey baseKey) {
		//if (baseKeyService.count(BaseKeyCond.builder().nameEq(baseKey.getName()).build()) > 0)
			//return Result.error(1, "【钥匙名称】不能重复！");
		return Result.success(baseKeyService.save(baseKey));
	}

	/**
	 * @方法说明 【钥匙】删除
	 */
	@PostMapping("delete")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		return Result.success(baseKeyService.delete(ids));
	}

	/**
	 * @方法说明 【钥匙】修改
	 */
	@PostMapping("update")
	public Result<Integer> update(@RequestBody @Validated BaseKey baseKey) {
		//if (baseKeyService.count(BaseKeyCond.builder().nameEq(baseKey.getName()).idNe(baseKey.getId()).build()) > 0)
			//return Result.error(1, "【钥匙名称】不能重复！");
		return Result.success(baseKeyService.update(baseKey));
	}

	/**
	 * @方法说明 【钥匙】分页列表
	 */
	@PostMapping("page")
	public Result<Page<BaseKey>> page(@RequestBody BaseKeyCond cond) {
		return Result.success(baseKeyService.page(cond));
	}
 
}