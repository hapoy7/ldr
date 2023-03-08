package com.ldr.manage.base.baseuser;

import java.time.LocalDateTime;

import com.ldr.common.base.BaseCondition;

import lombok.Builder;
import lombok.Getter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【用户】查询条件
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
@Builder
public class BaseUserCond extends BaseCondition {

	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id =", id);
		and("number LIKE", number, 3);
		and("name LIKE", name, 3);
		and("card_no LIKE", cardNo, 3);
		and("password LIKE", password, 3);
		and("group_name LIKE", groupName, 3);
		and("fingerprint_count =", fingerprintCount);
		and("face_info LIKE", faceInfo, 3);
		and("type =", type);
		and("start_time =", startTime);
		and("end_time =", endTime);
		and("remark LIKE", remark, 3);
		in("id", ids);
	}

	/* 默认条件↓ */
	private Long id; /* 主键 */
	private String number; /* 编号 */
	private String name; /* 姓名 */
	private String cardNo; /* 卡号 */
	private String password; /* 密码 */
	private String groupName; /* 分组 */
	private Byte fingerprintCount; /* 指纹数量 */
	private String faceInfo; /* 人脸信息 */
	private Byte type; /* 人员类型1永久2临时 */
	private LocalDateTime startTime; /* 开始时间 */
	private LocalDateTime endTime; /* 结束时间 */
	private String remark; /* 备注 */
	private Object[] ids; /* 主键列表 */
	/* 自定义条件↓ */
}