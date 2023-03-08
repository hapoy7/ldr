package com.ldr.manage.sys.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【用户】实体
 * @author 高振中
 * @date 2020-11-17 01:42:03
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_user")
public class User {
	// 字段↓
	@Id(IdType.SNOW)
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime startTime; /* 开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime endTime; /* 结束时间 */
	private LocalDateTime createTime; /* 创建时间 */
	private LocalDateTime updateTime; /* 修改时间 */
	private Byte dr; /* 删除标记 */
	private Long createBy; /* 创建时间 */
	private Long updateBy; /* 创建时间 */
	private String remark; // 备注
	// 扩展(显示)属性↓
	@Exclude
	private String avatarUrl; // 头像
	@Exclude
	private String deptName; // 机构名称
	@Exclude
	private Boolean checked; // 是否选中

}