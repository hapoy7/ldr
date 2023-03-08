package com.ldr.manage.base.keybox;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.*;

/**
 * @类说明 【钥匙柜钥匙关联】实体
 * @author 杨来富
 * @date 2022-11-04 15:48:07
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_key_box")
public class KeyBox {
	// 字段↓
	@Id(IdType.SNOW)
	private Long keyBoxId; /* 主键 */
	private Long keyId; /* 钥匙主键 */
	private Long boxId; /* 钥匙柜主键 */
	/* 扩展(显示)属性↓@Exclude */

	public KeyBox(Long keyId, Long boxId) {
		super();
		this.keyId = keyId;
		this.boxId = boxId;
	}


}