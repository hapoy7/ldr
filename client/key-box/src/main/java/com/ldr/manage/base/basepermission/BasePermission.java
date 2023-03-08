package com.ldr.manage.base.basepermission;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.*;

/**
 * @类说明 【授权表】实体
 * @author 杨来富
 * @date 2022-11-01 09:30:18
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_permission")
public class BasePermission {
	// 字段↓
	@Id(IdType.SNOW)
	private Long id; /* 主键 */
	private Long userId; /* 用户主键 */
	private Long boxId; /* 钥匙柜主键 */
	private Long keyId; /* 钥匙主键 */
	/* 扩展(显示)属性↓@Exclude */
}