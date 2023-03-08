package com.ldr.manage.base.terbox;

import com.ldr.common.base.BaseCondition;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @类说明 【终端钥匙柜关联】查询条件
 * @author 杨来富
 * @date 2022-11-04 10:10:22
 **/
@Setter
@Getter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TerBoxCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("boxName LIKE ? =", boxName ,3);
		and("boxNumber LIKE ? =", boxNumber,3);
		and("ter_id =", terId);
		in("ter_id", terIds);
	}
	/* 默认条件↓ */
	private String boxName;
	private String boxNumber;
	private Long terId; /* 终端主键 */
	private Object[] terIds; /* 主键列表 */
	/* 自定义条件↓ */

}