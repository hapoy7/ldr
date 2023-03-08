package com.ldr.manage.base.baseboxuser;

import com.ldr.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * @类说明 【钥匙柜用户关联】查询条件
 * @author 杨来富
 * @date 2022-11-01 09:50:05
 **/
@Setter
@Getter
@Builder
//@Accessors(chain = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class BaseBoxUserCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		add("AND d.name LIKE ?", deptName, 3);
		and("name LIKE", name, 3);
		in("box_id", boxIds);
		and("box_id =", boxId);
	}
	/* 默认条件↓ */
	private String deptName;
	private String name;
	private Long boxId; /* 柜子主键 */
	private Object[] boxIds; /* 主键列表 */
	/* 自定义条件↓ */
}