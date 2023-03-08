package com.ldr.manage.sys.parameter;

import lombok.Builder;
import lombok.Getter;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【系统参数】查询条件
 * @author 高振中
 * @date 2021-04-10 22:54:52
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParameterCond extends BaseCondition {

	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id=", id);
		and("group_name LIKE", groupName, 3);
		and("param_name LIKE", paramName, 3);
		and("param_key LIKE", paramKey, 3);
		and("dr =", dr);
		and("param_name=", paramNameEq);
		and("param_key=", paramKeyEq);
		and("id<>", idNe);
	}

	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String groupName; /* 组名称 */
	private String paramName; /* 参数名称 */
	private String paramKey; /* 参数键 */
	private String value; /* 参数值 */
	@Builder.Default
	private Byte dr = 0; /* 删除标记 */
	/* 自定义条件↓ */
	private String paramNameEq; /* 参数名称等于 */
	private String paramKeyEq; /* 参数键等于 */
	private Long idNe; /* 主键 */
}