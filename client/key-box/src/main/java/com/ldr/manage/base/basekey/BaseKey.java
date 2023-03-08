package com.ldr.manage.base.basekey;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @summary 【钥匙】实体
 * @author 高振中
 * @date 2022-09-21 10:16:41
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_key")
public class BaseKey {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private String name; /* 名称 */
	private String number; /* 编号 */
	private Long boxId; /* 钥匙柜主键 */
	private String boxNumber; /* 钥匙柜编号 */
	private Byte status; /* 状态 */
	private String remark; /* 备注 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createTime; /* 创建时间 */
	private Long createBy; /* 创建人ID */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime updateTime; /* 修改时间 */
	private Long updateBy; /* 修改人ID */
	private Byte dr; /* 删除标记 */
	private String solt; /* 槽位信息 */
	private String rfid; /* 钥匙RFID */
	private String keyGroup; /* 钥匙分组 */
	@Exclude
	private String boxName; /* 钥匙柜名称 */
}