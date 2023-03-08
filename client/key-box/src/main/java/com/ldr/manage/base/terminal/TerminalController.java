package com.ldr.manage.base.terminal;

import com.ldr.common.base.Page;
import com.ldr.common.config.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类说明 【终端】控制器
 * @author 杨来富
 * @date 2022-11-01 13:24:11
 **/
//@Slf4j
@RestController
@RequestMapping("terminal")
public class TerminalController {

	@Autowired
	private TerminalService terminalService; // 注入【终端】业务逻辑层

	/**
	 * @方法说明 【终端】修改
	 */
	@PostMapping("update")
	public Result<Object> update(@RequestBody @Validated Terminal terminal) {
		int update = terminalService.update(terminal);
		switch (update) {
			case 0 -> {return Result.error("更新失败");}
			case 1 -> {return Result.success(update,"更新同步成功");}
		}
		return Result.error("系统错误");
	}

	/**
	 * @方法说明 【终端】分页列表（查询）
	 */
	@PostMapping("page")
	public Result<Page<Terminal>> page(@RequestBody TerminalCond cond) {

		if (terminalService.page(cond)!=null) {
			return Result.success(terminalService.page(cond));
		}
		return Result.error("请输入查询参数");
	}
}