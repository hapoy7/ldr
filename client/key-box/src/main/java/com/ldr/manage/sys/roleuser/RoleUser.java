package com.ldr.manage.sys.roleuser;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【角色用户关联】实体
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Table("sys_role_user")
@NoArgsConstructor
public class RoleUser {
	// 字段↓
	@Id(IdType.SNOW)
	private Long userRoleId; // 主键
	private Long userId; // 用户主键
	private Long roleId; // 角色主键
	// 扩展(显示)属性↓
	public RoleUser(Long userId, Long roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
}