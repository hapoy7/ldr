package com.ldr.manage.sys.roledept;

import java.time.LocalDateTime;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【角色部门关联】实体
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Setter
@Getter
@Table("sys_role_dept")
public class RoleDept {
	// 字段↓
	@Id(IdType.SNOW)
	private Long roleDeptId; // id
	private Long roleId; // 角色id
	private Long deptId; // 部门id
	private LocalDateTime createTime; // 创建时间
	private Long createBy; // 创建人
	// 扩展(显示)属性↓

}