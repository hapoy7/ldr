package com.ldr.manage.sys.roledept;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【角色部门关联】查询条件
 * @author 高振中
 * @date 2021-03-25 23:35:04
 **/

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDeptCond extends BaseCondition {

	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		in("role_id", roleIds);
		and("role_id =", roleId);
	}

	// 默认条件↓
	private Long roleId;// 主键列表
	private Object[] roleIds;// 主键列表
}