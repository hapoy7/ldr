package com.ldr.manage.base.basebox;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import com.ldr.manage.base.basekey.BaseKey;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @类说明 【钥匙柜】实体
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
@Setter
@Getter
@Table("base_box")
public class BaseBox {
	// 字段↓
	@Id(IdType.SNOW)
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createTime; /* 创建时间 */
	private Long createBy; /* 创建人ID */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime updateTime; /* 修改时间 */
	private Long updateBy; /* 修改人ID */
	private Byte dr; /* 删除标记 */
	/* 扩展(显示)属性↓@Exclude */
	@Exclude
	private List<BaseKey> keys; /* 管理员密码 */
}