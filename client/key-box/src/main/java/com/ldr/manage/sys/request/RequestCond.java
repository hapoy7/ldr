package com.ldr.manage.sys.request;

import com.ldr.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【请求时长统计】查询条件
 * @author 高振中
 * @date 2021-02-20 14:02:55
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCond extends BaseCondition {
	/**
	 * @方法说明: 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("path LIKE", path, 3);
		and("app_name LIKE", appName, 3);
		and("sum_count =", sumCount);
		and("type =", type);

		and("path =", pathEq);
		and("app_name =", appNameEq);
	}

	// 默认条件↓
	private String path; // 接口路径
	private String appName; // 应用名
	private Long sumCount; // 请求次数
	private Byte type; // 1后台2前端
	// 自定义条件↓
	private String pathEq; // 接口路径
	private String appNameEq; // 应用名
}