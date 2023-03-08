package com.ldr.manage.base.terbox;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;
import com.ldr.manage.base.terbox.vo.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @类说明 【终端钥匙柜关联】控制器
 * @author 杨来富
 * @date 2022-11-04 10:10:22
 **/
//@Slf4j
@RestController
@RequestMapping("terBox")
public class TerBoxController {

	@Autowired
	private TerBoxService terBoxService; // 注入【终端钥匙柜关联】业务逻辑层

	@AutoLog("【终端-钥匙柜关联】列表")
	@PostMapping("list")
	public Result<Auth> list(@RequestBody TerBoxCond cond) {
		return Result.success(terBoxService.auth(cond));
	}

	@AutoLog("【终端-钥匙柜关联】批量保存")
	@PostMapping("save")
	public Result<Void> insertBatch(@RequestBody List<Long> boxIds, Long terId) {
		terBoxService.insertBatch(boxIds, terId);
		return Result.success();
	}

}