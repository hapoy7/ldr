package com.ldr.manage.base.basepermission;

import com.ldr.common.aop.AutoLog;
import com.ldr.common.config.Result;
import com.ldr.manage.base.baseboxuser.BaseBoxUserCond;
import com.ldr.manage.base.baseboxuser.BaseBoxUserService;
import com.ldr.manage.base.basepermission.vo.Auth;
import com.ldr.manage.base.basepermission.vo.KeyAuth;
import com.ldr.manage.base.keybox.KeyBoxCond;
import com.ldr.manage.base.keybox.KeyBoxService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @类说明 【授权表】控制器
 * @author 杨来富
 * @date 2022-11-01 09:30:18
 **/
//@Slf4j
@Api(tags = "授权")
@RestController
@RequestMapping("basePermission")
public class BasePermissionController {
	@Autowired
	private BaseBoxUserService baseBoxUserService;

	@Autowired
	private KeyBoxService keyBoxService;

	@AutoLog("【柜子用户关联】列表")
	@PostMapping("list")
	public Result<Auth> list(@RequestBody BaseBoxUserCond cond) {
		return Result.success(baseBoxUserService.auth(cond));
	}

	@AutoLog("【柜子用户关联】批量保存")
	@PostMapping("save")
	public Result<Void> insertBatch(@RequestBody List<Long> userIds, Long boxId) {
		baseBoxUserService.insertBatch(userIds, boxId);
		return Result.success();
	}

	@AutoLog("【柜子钥匙关联】列表")
	@PostMapping("keyList")
	public Result<KeyAuth> keyList(@RequestBody KeyBoxCond cond) {
		return Result.success(keyBoxService.auth(cond));
	}

	@AutoLog("【柜子钥匙关联】批量保存")
	@PostMapping("keySave")
	public Result<Void> keyInsertBatch(@RequestBody List<Long> keyIds, Long boxId) {
		keyBoxService.insertBatch(keyIds, boxId);
		return Result.success();
	}




}