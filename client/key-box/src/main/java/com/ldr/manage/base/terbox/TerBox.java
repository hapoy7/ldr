package com.ldr.manage.base.terbox;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.*;

/**
 * @类说明 【终端钥匙柜关联】实体
 * @author 杨来富
 * @date 2022-11-04 13:24:23
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_ter_box")
public class TerBox {
	// 字段↓
	@Id(IdType.SNOW)
	private Long boxTerId; /* 主键 */
	private Long boxId; /* 钥匙柜主键 */
	private Long terId; /* 终端主键 */
	/* 扩展(显示)属性↓@Exclude */

	public TerBox(Long boxId, Long terId) {
		super();
		this.boxId = boxId;
		this.terId = terId;
	}
}