package com.ldr.landwell.api.base.terminal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TerminalParam {
	public String terID; // 终端机ID
	//public Integer terminalNumber; // 终端机编号(8位之内纯数字)
	//public String terminalName; // 终端机名称
	public String departmentId; // 部门id
	public Integer pageIndex; // 当前页数(必填)
	public Integer pageSize; // 每页条数(必填)
}