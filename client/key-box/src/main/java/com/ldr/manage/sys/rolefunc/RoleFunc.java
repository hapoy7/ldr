package com.ldr.manage.sys.rolefunc;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【角色功能关联】实体
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Table("sys_role_func")
public class RoleFunc {
	// 字段↓
	@Id(IdType.SNOW)
	private Long roleFuncId; // 主键
	private Long roleId; // 角色主键
	private Long funcId; // 权限主键
	// 扩展(显示)属性↓
}