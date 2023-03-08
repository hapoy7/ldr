package com.ldr.landwell.api.common.dep;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InDepParam {
	public String parentId; // 父级ID
	public String departmentId; // 部门id
	public String departmentName; // 部门名称
	public Integer pageIndex; // 当前页数(必填)
	public Integer pageSize; // 每页条数(必填)
}