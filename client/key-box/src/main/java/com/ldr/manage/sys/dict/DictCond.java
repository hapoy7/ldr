package com.ldr.manage.sys.dict;

import com.ldr.common.base.BaseCondition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 【枚举字典】查询条件
 * 
 * @author 高振中
 * @date 2020-12-19 21:18:17
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "【字典】查询条件")
public class DictCond extends BaseCondition {
	/**
	 * 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("dr =", dr);
		and("id =", id);
		and("name LIKE", name, 3);
		and("code LIKE", code, 3);
		and("name =", nameEq);
		and("code =", codeEq);
		and("id <>", idNe);
	}

	// 默认条件↓
	@ApiModelProperty("主键")
	private Long id; // 主键
	@ApiModelProperty("字典名称")
	private String name; // 字典名称
	@ApiModelProperty("字典编码")
	private String code; // 字典编码
	@ApiModelProperty(hidden = true)
	@Builder.Default
	private Byte dr = 0; // 删除标记
	// 自定义条件↓
	@ApiModelProperty(hidden = true)
	private Long idNe; // 主键
	@ApiModelProperty(hidden = true)
	private String nameEq; // 字典名称
	@ApiModelProperty(hidden = true)
	private String codeEq; // 字典编码
}