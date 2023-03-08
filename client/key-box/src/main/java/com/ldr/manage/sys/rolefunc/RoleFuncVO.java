package com.ldr.manage.sys.rolefunc;

import java.util.List;

import com.ldr.manage.sys.func.Func;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RoleFuncVO {
	private List<Func> funcs;// 功能菜单树
	private List<Long> ids; // 角色主键
}