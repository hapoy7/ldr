package com.ldr.manage.base.basekey;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @summary 【钥匙】查询条件
 * @author 高振中
 * @date 2022-09-21 10:16:41
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseKeyCond extends BaseCondition {

	/**
	 * 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("name LIKE", name, 3);
		and("number LIKE", number, 3);
		and("box_id =", boxId);
		and("box_number LIKE", boxNumber, 3);
		and("status =", status);
		and("remark LIKE", remark, 3);
		and("solt LIKE", solt, 3);
		and("rfid LIKE", rfid, 3);
		and("key_group LIKE", keyGroup, 3);		
		in("id", ids);
	}

	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String name; /* 名称 */
	private String number; /* 编号 */
	private Long boxId; /* 钥匙柜主键 */
	private String boxNumber; /* 钥匙柜编号 */
	private Byte status; /* 状态 */
	private String remark; /* 备注 */
	private String solt; /* 槽位信息 */
	private String rfid; /* 钥匙RFID */
	private String keyGroup; /* 钥匙分组 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}