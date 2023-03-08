package com.ldr.manage.sys.request;

import com.ldr.common.base.annotation.Exclude;
import com.ldr.common.base.annotation.Id;
import com.ldr.common.base.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【请求时长统计】实体
 * @author 高振中
 * @date 2021-02-20 14:02:55
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_request")
public class Request {
	// 字段↓
	@Id
	private String path; // 接口路径
	private String appName; // 应用名
	@Builder.Default
	private Long sumCount = 0L; // 请求次数
	@Builder.Default
	private Long sumMilliSecond = 0L; // 请求总时长
	@Builder.Default
	private Float avgMilliSecond = 0F; // 请求平均时长
	@Builder.Default
	private Integer maxMilliSecond = 0; // 请求最大时长
	@Builder.Default
	private Integer minMilliSecond = Integer.MAX_VALUE; // 请求最小时长
	private Byte type; // 1后台2前端
	// 扩展(显示)属性↓
	@Exclude
	private Integer currentMilliSecond;// 当前请求时长
}