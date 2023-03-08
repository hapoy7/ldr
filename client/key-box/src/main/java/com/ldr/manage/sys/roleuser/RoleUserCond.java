package com.ldr.manage.sys.roleuser;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【角色用户关联】查询条件
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleUserCond extends BaseCondition {
	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		add("AND d.name LIKE ?", deptName, 3);
		and("name LIKE", name, 3);
		in("role_id", roleIds);
		and("role_id =", roleId);
	}

	// 默认条件↓
	private String deptName;
	private String name;
	private Long roleId;
	private Object[] roleIds;// 主键列表
}