package com.ldr.manage.base.baseboxuser;

import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;
import com.ldr.common.base.key.IdType;
import lombok.*;
//import lombok.Builder;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import com.gzz.common.base.annotation.Exclude;


/**
 * @类说明 【钥匙柜用户关联】实体
 * @author 杨来富
 * @date 2022-11-01 09:50:05
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("base_box_user")
public class BaseBoxUser {
	// 字段↓
	@Id(IdType.SNOW)
	private Long userBoxId; /* 主键 */
	private Long userId; /* 用户主键 */
	private Long boxId; /* 柜子主键 */
	/* 扩展(显示)属性↓@Exclude */
	public BaseBoxUser(Long userId, Long boxId) {
		super();
		this.userId = userId;
		this.boxId = boxId;
	}
}