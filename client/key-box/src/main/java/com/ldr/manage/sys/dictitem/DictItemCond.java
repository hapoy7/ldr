package com.ldr.manage.sys.dictitem;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【字典项】查询条件
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictItemCond extends BaseCondition {
	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("id <>", idNe);
		and("dict_id =", dictId);
		and("text LIKE", text, 3);
		and("value =", value);
		and("text =", textEq);
		and("dr =", dr);
		in("dict_id", dictIds);
	}

	// 默认条件↓
	@Builder.Default
	private Byte dr = 0; // 删除标记
	private Long dictId; // 字典主键
	private String text; // 字典项文本
	private String value; // 字典项值
	// 自定义条件↓
	private Long idNe; // 字典主键不(等于)
	private String textEq; // 字典项文本(等于)
	private Object[] dictIds;// 主键数组

}