package com.ldr.manage.base.basealert;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【告警信息】实体
 * @author 高振中
 * @date 2022-09-20 17:45:04
 **/
@Setter
@Getter
@Table("base_alert")
public class BaseAlert {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private String boxNumber; /* 钥匙柜编号 */
	private String boxName; /* 钥匙柜名称 */
	private String keyNumber; /* 钥匙编号 */
	private String keyName; /* 钥匙名称 */
	private Byte type; /* 告警类型 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime alertTime; /* 告警时间 */
	/* 扩展(显示)属性↓@Exclude */
}