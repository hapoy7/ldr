package com.ldr.manage.sys.func;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【功能菜单】实体
 * @author 高振中
 * @date 2020-11-10 23:19:07
 **/
@Setter
@Getter
@Table("sys_func")
public class Func {
	// 字段↓
	@Id(IdType.SNOW)
	private Long funcId; // 主键
	private Long parentId; // 所属上级
	private String name; // 名称
	private Byte type; // 类型(1:目录,2:菜单,3:按钮)
	private String permissionValue; // 权限值
	private String path; // 路径
	private String icon; // 图标
	private Byte status; // 状态(0:禁止,1:正常)
	private Float orders; // 排序
	private String component; // 组件路径
	private Byte leaf; // 叶子1|0
	private LocalDateTime createTime; /* 创建时间 */
	private LocalDateTime updateTime; /* 修改时间 */
	private Byte dr; /* 删除标记 */
	private Long createBy; /* 创建时间 */
	private Long updateBy; /* 创建时间 */
	// 扩展(显示)属性↓
	@Exclude
	private List<Func> children = new ArrayList<>();
}