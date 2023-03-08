package com.ldr.manage.sys.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @类说明 【请求时长统计】控制器
 * @author 高振中
 * @date 2021-02-20 14:02:55
 **/
@RestController
@RequestMapping("request")
@Api(tags = "【请求时长】API")
public class RequestController {

	@Autowired
	private RequestService requestService; // 注入【请求时长统计】业务逻辑层

	/**
	 * @方法说明 【请求时长统计】删除
	 */
	@AutoLog("【请求时长统计】删除")
	@PostMapping("delete")
	@ApiOperation(value = "删除【请求时长统计】", notes = "参数格式:['path1','path1','path1','path1'...]")
	public Result<Integer> delete(@RequestBody Long[] ids) {
		int count = requestService.delete(ids);
		return Result.success(count, "删除成功");
	}

	/**
	 * @方法说明 【请求时长统计】列表
	 */
	@AutoLog("【请求时长统计】列表")
	@PostMapping("list")
	@ApiOperation(value = "按条件查询不分页【请求时长统计】列表", notes = "按条件查询不分页【请求时长统计】列表")
	public Result<List<Request>> list(@RequestBody RequestCond cond) {
		return Result.success(requestService.list(cond));
	}

}