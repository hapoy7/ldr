package com.ldr.manage.base.keybox;

import com.ldr.common.base.BaseCondition;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @类说明 【钥匙柜钥匙关联】查询条件
 * @author 杨来富
 * @date 2022-11-04 15:48:07
 **/
@Setter
@Getter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class KeyBoxCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("keyName =", keyName);
		and("keyNumber =", keyNumber);
		and("box_id =", boxId);
		in("key_box_id", key_box_ids);
	}
	/* 默认条件↓ */
	private String keyName; /* 主键 */
	private String keyNumber; /* 钥匙主键 */
	private Long boxId; /* 钥匙柜主键 */
	private Object[] key_box_ids; /* 主键列表 */
	/* 自定义条件↓ */
}