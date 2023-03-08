package com.ldr.manage.base.basebox;

import com.ldr.common.base.BaseCondition;

import lombok.Builder;
import lombok.Getter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【钥匙柜】查询条件
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
@Builder
public class BaseBoxCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("name LIKE", name, 3);
		and("number LIKE", number, 3);
		and("box_group =", boxGroup);
		and("firm_type =", firmType);
		and("protocol_type =", protocolType);
		and("dr =",0);
		and("location LIKE", location, 3);
		and("ip LIKE", ip, 3);
		and("admin_pass LIKE", adminPass, 3);
		and("status =", status);
		and("remark LIKE", remark, 3);
		in("id", ids);
	}
	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String name; /* 名称 */
	private String number; /* 编号 */
	private Byte boxGroup; /* 组信息 */
	private Byte firmType; /* 厂家类型 */
	private Byte protocolType; /* 协议类型 */
	private String location; /* 位置信息 */
	private String ip; /* IP地址 */
	private String adminPass; /* 管理员密码 */
	private Byte status; /* status */
	private String remark; /* 备注 */
	private Byte dr; /* 删除标记 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}