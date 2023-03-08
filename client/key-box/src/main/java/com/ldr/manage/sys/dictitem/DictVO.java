package com.ldr.manage.sys.dictitem;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【字典项】实体
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@Setter
@Getter
public class DictVO {
	private String code; // 字典编码
	private String text; // 字典项文本
	private Integer value; // 字典项值
}