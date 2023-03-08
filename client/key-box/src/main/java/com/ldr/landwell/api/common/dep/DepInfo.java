package com.ldr.landwell.api.common.dep;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DepInfo {
	private Long parentId;
	private Long departmentId;
	private String departmentName;
	private LocalDateTime baseModifyTime;
	private Long baseModifierId;
}
