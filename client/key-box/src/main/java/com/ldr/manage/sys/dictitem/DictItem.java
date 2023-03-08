package com.ldr.manage.sys.dictitem;

import java.time.LocalDateTime;

import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【字典项】实体
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@Setter
@Getter
@Table("sys_dict_item")
public class DictItem {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; // 主键
	private Long dictId; // 字典主键
	private String text; // 字典项文本
	private String value; // 字典项值
	private String remark; // 备注
	private Float orderNum; // 排序编号
	private LocalDateTime createTime; /* 创建时间 */
	private LocalDateTime updateTime; /* 修改时间 */
	private Long createBy; /* 创建时间 */
	private Long updateBy; /* 创建时间 */
	private Byte dr; /* 删除标记 */
	// 扩展(显示)属性↓
	@Exclude
	private String code; // 字典编码
}