package com.ldr.manage.base.terminal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @类说明 【终端】实体
 * @author 杨来富
 * @date 2022-11-01 13:24:11
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_terminal")
public class Terminal {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private String name; /* 终端名称 */
	private String number; /* 终端编号 */
	private Long depId; /* 部门id */
	private Integer boxCount; /* 钥匙柜数量 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime baseModifytime; /* 修改时间 */
	private Long baseModifierid; /* 修改人员Id */
	private String ip; /* 终端IP */
	private Integer status; /* 状态 0离线 1在线 */
	private String superPassword; /* 管理员密码 */
	private String urgentlyPassword; /* 紧急取钥匙密码 */
	/* 扩展(显示)属性↓@Exclude */
}