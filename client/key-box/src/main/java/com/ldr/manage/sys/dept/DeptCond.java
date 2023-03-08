package com.ldr.manage.sys.dept;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 【组织机构】查询条件
 * @author 高振中
 * @date 2021-04-13 00:30:04
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptCond extends BaseCondition {

	/**
	 * 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("parent_id =", parentId);
		and("name LIKE", name, 3);
		and("type =", type);
		and("code LIKE", code, 3);
		and("status =", status);
		and("order_num =", orderNum);
		and("leaf =", leaf);
		and("remark LIKE", remark, 3);
		and("dr =", dr);
		in("id", ids);
		and("name =", nameEq);
		and("id<>", idNe);
	}

	/* 默认条件↓ */
	private Long id; /* ID */
	private Long parentId; /* 上级ID */
	private String name; /* 机构名称 */
	private Byte type; /* 机构类型 1单位 2部门 */
	private String code; /* 机构编码 */
	private Byte status; /* 状态(1启用，0不启用) */
	private Float orderNum; /* 排序编号 */
	private Byte leaf; /* leaf */
	private String remark; /* 备注 */
	private Byte dr; /* 删除标记 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
	private String nameEq; /* 机构名称-等于 */
	private Long idNe; /* ID-不等于 */
}