package com.ldr.manage.sys.log;

import com.ldr.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明 【系统日志】查询条件
 * @author 高振中
 * @date 2021-03-12 12:57:38
 **/
@Setter
@Getter
public class LogCond extends BaseCondition {

	/**
	 * @方法说明 拼加条件
	 **/
	@Override
	protected void addCondition() {
		add("id =", id);
		add("title LIKE", title, 3);
		add("user_id LIKE", userId, 3);
		add("userName LIKE", userName, 3);
		add("ip LIKE", ip, 3);
		add("method LIKE", method, 3);
		add("url LIKE", url, 3);
		add("request_type LIKE", requestType, 3);
		add("params LIKE", params, 3);
		in("id", ids);
	}

	// 默认条件↓
	private Long id; // 主键
	private String title; // 日志标题
	private String userId; // 用户主键
	private String userName; // 用户名
	private String ip; // IP地址
	private String method; // java类.方法
	private String url; // 请求路径
	private String requestType; // 请求类型
	private String params; // 请求参数
	private Object[] ids;// 主键列表
	// 自定义条件↓
}