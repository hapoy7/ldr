package com.ldr.manage.base.baseuser;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【用户】实体
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table("base_user")
public class BaseUser {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private String number; /* 编号 */
	private String name; /* 姓名 */
	private String cardNo; /* 卡号 */
	private String password; /* 密码 */
	private String groupName; /* 分组 */
	private Byte fingerprintCount; /* 指纹数量 */
	private String faceInfo; /* 人脸信息 */
	private Byte type; /* 人员类型1永久2临时 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime startTime; /* 开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime endTime; /* 结束时间 */
	private String remark; /* 备注 */
	private LocalDateTime createTime; /* 创建时间 */
	private Long createBy; /* 创建人ID */
	private LocalDateTime updateTime; /* 修改时间 */
	private Long updateBy; /* 修改人ID */
	private Byte dr; /* 删除标记 */
	/* 扩展(显示)属性↓@Exclude */
}