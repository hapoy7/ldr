package com.ldr.landwell.api.base.box;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Box {
	public String boxID; // 钥匙柜ID
	public String boxName; // 钥匙柜名称
	public int boxNumber; // 钥匙柜编号
	public int keyCount; // 钥匙数量
	public String boxInfor; // 钥匙排列组合
	public String baseModifyTime; // 修改时间
	public String baseModifierId; // 修改人员ID
}