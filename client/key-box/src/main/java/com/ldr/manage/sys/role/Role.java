package com.ldr.manage.sys.role;

import java.time.LocalDateTime;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【角色】实体
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Table("sys_role")
public class Role {
	// 字段↓
	@Id(IdType.SNOW)
	private Long roleId; // 主键
	private String name; // 角色名称
	private String remark; // 备注
	private Integer orderNum; // 排序
	private LocalDateTime createTime; // 创建时间
	private Long createBy; // 创建时间
	private LocalDateTime updateTime; // 创建时间
	private Long updateBy; // 创建时间
	private Byte dr; // 创建时间
	// 扩展(显示)属性↓
}