package com.ldr.manage.sys.func;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【功能菜单】查询条件
 * @author 高振中
 * @date 2020-11-10 23:19:07
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncCond extends BaseCondition {
	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("dr =", dr);
		and("func_id =", funcId);
		and("parent_id =", parentId);
		and("name LIKE", name, 3);
		and("type =", type);
		and("path LIKE", path, 3);
		and("icon LIKE", icon, 3);
		and("status =", status);
		and("component LIKE", component, 3);
		in("funcId", ids);
	}

	// 默认条件↓
	private Byte dr; /* 删除标记 */
	private Long funcId; // 主键
	private Long parentId; // 所属上级
	private String name; // 名称
	private Byte type; // 类型(1:目录,2:菜单,3:按钮)
	private String permissionValue; // 权限值
	private String path; // 路径
	private String icon; // 图标
	private Byte status; // 状态(0:禁止,1:正常)
	private String component; // 文件路径
	private Object[] ids;// 主键数组
	// 自定义条件↓
}