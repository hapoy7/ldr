package com.ldr.manage.sys.roledept;

import java.util.List;

import com.ldr.manage.sys.dept.Dept;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RoleDeptVO {
	private List<Dept> depts;// 完整部门树
	private List<Long> ids; // 已选中的部门主键
}