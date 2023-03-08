package com.ldr.landwell.api.base.terminal;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import com.ldr.landwell.api.base.box.BoxInfo;

@Setter
@Getter
@ToString
public class TerminalInfo {
	public String terID; // 终端机ID
	public int terminalNumber; // 终端机编号
	public String terminalName; // 终端机名称
	public String departmentId; // 部门id
	public int boxCount; // 钥匙柜数量
	public String superPassword; // 管理员密码
	public String urgentlyPassword; // 紧急取钥匙密码
	public String baseModifyTime; // 修改时间
	public String baseModifierId; // 修改人员ID
	public List<BoxInfo> boxInfo = new ArrayList<>(); // 钥匙柜信息
	public int pageIndex; // 当前页数
	public int pageSize; // 每页条数
}