package com.ldr.manage.base.basepermission;

import com.ldr.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/**
 * @类说明 【授权表】查询条件
 * @author 杨来富
 * @date 2022-11-01 09:30:18
 **/
@Setter
@Getter
@Builder
//@Accessors(chain = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class BasePermissionCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("user_id =", userId);
		and("box_id =", boxId);
		and("key_id =", keyId);
		in("id", ids);
	}
	/* 默认条件↓ */
	private Long id; /* 主键 */
	private Long userId; /* 用户主键 */
	private Long boxId; /* 钥匙柜主键 */
	private Long keyId; /* 钥匙主键 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}