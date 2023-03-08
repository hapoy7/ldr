package com.ldr.manage.sys.user;

import java.time.LocalDateTime;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【用户】查询条件
 * @author 高振中
 * @date 2020-11-17 01:42:03
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {

	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("user_id =", userId);
		and("dept_id =", deptId);
		and("name LIKE", name, 3);
		and("password LIKE", password, 3);
		and("login_name=", loginName);
		and("avatar LIKE", avatar, 3);
		and("phone LIKE", phone, 3);
		and("gender =", gender);
		and("status =", status);
		and("number LIKE", number, 3);
		and("card_no LIKE", cardNo, 3);
		and("group_name =", groupName);
		and("fingerprint_count =", fingerprintCount);
		and("face_info LIKE", faceInfo, 3);
		and("type =", type);
		and("start_time =", startTime);
		and("end_time =", endTime);
		and("dr =", dr);
		and("user_id <>", userIdNeq);
		in("user_id", ids);
		add("AND d.name LIKE ?", deptName,3);
	}

	// 默认条件↓
	private Byte dr; /* 删除标记 */
	private Long userId; // 主键
	private Long deptId; // 机构ID
	private String name; // 帐号
	private String password; // 密码
	private String loginName; // 登录名
	private String avatar; // 头像
	private String phone; // 电话
	private Byte gender; // 性别
	private Byte status; // 状态
	private String number; /* 编号 */
	private String cardNo; /* 卡号 */
	private Byte groupName; /* 分组 */
	private Byte fingerprintCount; /* 指纹数量 */
	private String faceInfo; /* 人脸信息 */
	private Byte type; /* 人员类型1永久2临时 */
	private LocalDateTime startTime; /* 开始时间 */
	private LocalDateTime endTime; /* 结束时间 */
	private Object[] ids;// 主键列表
	// 自定义条件↓
	private Long userIdNeq; // 主键不等于
	private String deptName; 
}