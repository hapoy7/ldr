package com.ldr.manage.base.terminal;

import com.ldr.common.base.Page;
import com.ldr.landwell.api.base.terminal.ApiTerminalTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类说明 【终端】业务逻辑层
 * @author 杨来富
 * @date 2022-11-01 13:24:11
 **/
//@Slf4j
@Service
public class TerminalService {

	@Autowired
	private TerminalDao terminalDao; // 注入【终端】数据访问层
	@Autowired
	private ApiTerminalTemplate terminalTemplate;

	/**
	 * @方法说明 【终端】更新同步
	 * 必填参数： terID 终端id --表中字段
	 *			departmentId 部门id
	 *			superPassword 管理员密码
	 *			urgentlyPassword
	 */
	public int update(Terminal terminal) {
		if (terminalDao.update(terminal) > 0) {
			if (terminalTemplate.update(com.ldr.landwell.api.base.terminal.Terminal.builder()
					.terID(terminal.getId().toString())
					.superPassword(terminal.getSuperPassword())
					.urgentlyPassword(terminal.getUrgentlyPassword())
					.departmentId(terminal.getDepId().toString())
					.build()).getMessage().equals("成功")){
				return 1;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * @方法说明 【终端】分页列表
	 * 必填参数：
	 *	departmentId
	 *  pageSize
	 *  pageIndex
	 *  cond.getDepId().toString()
	 */
	//public Page<Terminal> page(TerminalCond cond) {
	//	Result result = null;
	//	if (cond.getDepId()!=null) {
	//		result = terminalTemplate.query(TerminalParam.builder().departmentId(cond.getDepId().toString()).pageSize(10).pageIndex(1).build());
	//		if (result.getMessage().equals("成功")) {
	//			List<Terminal> terminalList = result.getData().toJavaList(Terminal.class);
	//			return new Page(terminalList,10,1,result.getData().size());
	//		}
	//		return terminalDao.page(cond);
	//	}
	//	return null;
	//}

	/**
	 * @方法说明 【终端】分页列表
	 */
	public Page<Terminal> page(TerminalCond cond) {
		return terminalDao.page(cond);
	}


}