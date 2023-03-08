package com.ldr.manage.base.baseoperation;

import com.ldr.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @类说明 【操作日志】查询条件
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
@Builder
public class BaseOperationCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
		@Override
		protected void addCondition() {
			and("id =", id);
			and("user_number LIKE", userNumber, 3);
			and("user_name LIKE", userName, 3);
			//and("opt_time =", optTime);
			and("box_number LIKE", boxNumber, 3);
			and("box_name LIKE", boxName, 3);
			and("key_number LIKE", keyNumber, 3);
			and("key_name LIKE", keyName, 3);
			and("type =", type);
			and("user_id =", userId);
			and("box_id =", boxId);
			and("key_id =", keyId);
			and("status =", status);
			in("id", ids);
			and("opt_time <=", optTime );
		}
		/* 默认条件↓ */
		private Long id; /* 主键 */
		private String userNumber; /* 用户编号 */
		private String userName; /* 用户名 */
		private LocalDateTime optTime; /* 操作时间 */
		private String boxNumber; /* 钥匙柜编号 */
		private String boxName; /* 钥匙柜名称 */
		private String keyNumber; /* 钥匙编号 */
		private String keyName; /* 钥匙名称 */
		private Byte type; /* 操作类型 */
		private Long userId; /* 用户id */
		private Long boxId; /* 钥匙柜id */
		private Long keyId; /* 钥匙id */
		private Byte status; /* 归还状态 */
		private Object[] ids; /* 主键列表 */
		/* 自定义条件↓ */
}