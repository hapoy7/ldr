package com.ldr.manage.sys.dept;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 *【组织机构】实体
 * @author 高振中
 * @date 2021-05-15 23:40:06
 **/
@Setter
@Getter
@Table("sys_dept")
public class Dept {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private Long parentId; /* 上级主键 */
	private String name; /* 机构名称 */
	private Byte type; /* 机构类型 1单位 2部门 */
	private String code; /* 机构编码 */
	private Byte status; /* 状态(1启用，0不启用) */
	private Float orderNum; /* 排序编号 */
	private Byte leaf; /* leaf */
	private String remark; /* 备注 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createTime; /* 创建时间 */
	private Long createBy; /* 创建人ID */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime updateTime; /* 修改时间 */
	private Long updateBy; /* 修改人ID */
	private Byte dr; /* 删除标记 */
	/* 扩展(显示)属性↓ */
	@Exclude
	private List<Dept> children = new ArrayList<>();/* 子记录 */
}