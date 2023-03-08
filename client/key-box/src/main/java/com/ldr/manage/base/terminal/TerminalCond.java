package com.ldr.manage.base.terminal;

import com.ldr.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
/**
 * @类说明 【终端】查询条件
 * @author 杨来富
 * @date 2022-11-01 13:24:11
 **/
@Setter
@Getter
@Builder
//@Accessors(chain = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class TerminalCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("name LIKE", name, 3);
		and("number LIKE", number, 3);
		and("dep_id =", depId);
		and("box_count =", boxCount);
		and("base_modifytime =", baseModifytime);
		and("base_modifierid =", baseModifierid);
		and("ip LIKE", ip, 3);
		and("status =", status);
		and("superPassword LIKE", superPassword, 3);
		and("urgentlyPassword LIKE", urgentlyPassword, 3);
		in("id", ids);
	}
	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String name; /* 终端名称 */
	private String number; /* 终端编号 */
	private Long depId; /* 部门id */
	private Integer boxCount; /* 钥匙柜数量 */
	private LocalDateTime baseModifytime; /* 修改时间 */
	private Long baseModifierid; /* 修改人员Id */
	private String ip; /* 终端IP */
	private Integer status; /* 状态 0离线 1在线 */
	private String superPassword; /* 管理员密码 */
	private String urgentlyPassword; /* 紧急取钥匙密码 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}