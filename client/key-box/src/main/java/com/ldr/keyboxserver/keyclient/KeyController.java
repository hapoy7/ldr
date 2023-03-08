package com.ldr.keyboxserver.keyclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldr.common.config.Result;
import com.ldr.manage.base.basebox.BaseBox;
import com.ldr.manage.base.basebox.BaseBoxCond;
import com.ldr.manage.base.basebox.BaseBoxService;

import io.swagger.annotations.Api;

/**
 * @类说明 查询钥匙柜状态信息的 实体
 * @author keke
 * @date 2022/11/8 16:15
 **/
@Api(tags = "【钥匙柜系统】对外接口")
@RestController
@RequestMapping("key")
public class KeyController {

	@Autowired
	private BaseBoxService baseBoxService; // 注入 【钥匙柜】业务逻辑层

	/**
	 * 对智能管控提供的 查询钥匙柜信息
	 * 
	 * @return 钥匙柜和它所拥有的的钥匙的信息
	 */
	@PostMapping("boxInfo")
	public Result<List<BaseBox>> boxInfo() {
		BaseBoxCond cond = BaseBoxCond.builder().dr((byte) 0).build();
		List<BaseBox> boxInfo = baseBoxService.list(cond);
		return Result.success(boxInfo);
	}
}
