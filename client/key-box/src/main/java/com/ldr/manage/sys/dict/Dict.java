package com.ldr.manage.sys.dict;

import java.time.LocalDateTime;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * 【枚举字典】实体
 * @author 高振中
 * @date 2020-12-19 21:18:17
 **/
@Setter
@Getter
@Table("sys_dict")
@ApiModel(description = "【字典】实体")
public class Dict {
	// 字段↓
	@Id(IdType.SNOW)
	@ApiModelProperty("主键")
	private Long id; // 主键
	
	@ApiModelProperty(value = "字典名称", required = true)
	@NotBlank(message = "[字典名称]不能为空!")
	private String name; // 字典名称
	
	@ApiModelProperty(value = "字典编码", required = true)
	@NotBlank(message = "[字典编码]不能为空!")
	private String code; // 字典编码
	
	@ApiModelProperty("备注")
	private String remark; // 备注
	
	@ApiModelProperty(hidden = true)
	private LocalDateTime createTime; /* 创建时间 */
	
	@ApiModelProperty(hidden = true)
	private LocalDateTime updateTime; /* 修改时间 */
	
	@ApiModelProperty(hidden = true)
	private Long createBy; /* 创建时间 */
	
	@ApiModelProperty(hidden = true)
	private Long updateBy; /* 创建时间 */
	
	@ApiModelProperty(hidden = true)
	private Byte dr; /* 删除标记 */
	// 扩展(显示)属性↓
}