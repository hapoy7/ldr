package com.ldr.manage.base.baseoperation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @类说明 【操作日志】实体
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Table("base_operation")
public class BaseOperation {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private String userNumber; /* 用户编号 */
	private String userName; /* 用户名 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
	/* 扩展(显示)属性↓@Exclude */
}