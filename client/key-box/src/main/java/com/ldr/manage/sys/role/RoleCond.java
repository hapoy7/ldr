package com.ldr.manage.sys.role;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【角色】查询条件
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleCond extends BaseCondition {

	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("role_id =", roleId);
		and("name LIKE", name, 3);
		and("remark LIKE", remark, 3);
		and("dr =", dr);
		and("name =", nameEq);
		and("role_id <>", roleIdNe);
	}

	// 默认条件↓
	@Builder.Default
	private Byte dr=0;
	private Long roleId; // 主键
	private String name; // 角色名称
	private String remark; // 角色名称
	// 自定义条件↓
	private String nameEq; // 角色名称
	private Long roleIdNe; // 主键

}