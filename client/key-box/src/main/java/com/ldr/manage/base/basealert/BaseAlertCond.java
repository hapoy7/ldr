package com.ldr.manage.base.basealert;

import java.time.LocalDateTime;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【告警信息】查询条件
 * @author 高振中
 * @date 2022-09-20 17:45:04
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseAlertCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("box_number LIKE", boxNumber, 1);
		and("box_name LIKE", boxName, 1);
		and("key_number LIKE", keyNumber, 1);
		and("key_name LIKE", keyName, 1);
		and("type =", type);
		and("alert_time =", alertTime);
		in("id", ids);
	}

	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String boxNumber; /* 钥匙柜编号 */
	private String boxName; /* 钥匙柜名称 */
	private String keyNumber; /* 钥匙编号 */
	private String keyName; /* 钥匙名称 */
	private Byte type; /* 告警类型 */
	private LocalDateTime alertTime; /* 告警时间 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}