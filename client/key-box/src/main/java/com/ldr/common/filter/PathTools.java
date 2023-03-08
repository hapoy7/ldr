package com.ldr.common.filter;

import java.util.List;

/**
 * @summary【路径过滤】工具
 * @author 高振中
 * @date 2021-02-01 20:20:20
 **/

public class PathTools {
	private static final List<String> frontPaths = List.of(".js", ".css", ".svg", ".jpg", ".png", ".bmp", ".xml", ".html", ".map", ".json", ".woff");
	private static final List<String> swaggerPath = List.of("/swagger-ui/", "/v3/api-docs", "/swagger-resources", "/csrf", "/index.html", "/element.css", "/vue.min.js", "/axios.min.js",
			"/element.min.js", "/code/", "/fonts/element-icons.woff", "/fonts/ionicons.ttf"); // 代码生成器路径
	private static final List<String> skipPaths = List.of("/swagger-ui/", "/v3/api-docs", "/swagger-resources", "/csrf", "/index.html", "/element.css", "/vue.min.js", "/axios.min.js",
			"/element.min.js", "/code/", "/fonts/element-icons.woff", "/fonts/ionicons.ttf","/sys/login","/css/","/js/","/fonts/","/img/", "/sys/token", "/key/boxInfo");// 跳过token验证的接口(请求路径)
 

	/**
	 * 是否为前端请求
	 **/
	public static Byte isFront(String src) {
		for (String path : frontPaths) {
			if (src.endsWith(path)) {
				return Byte.valueOf("1");// 前端文件
			}
		}
		return Byte.valueOf("2");/// 后端接口
	}

	/**
	 * 是否为(swagger与代码生成器路径)
	 **/
	public static boolean isSwagger(String src) {
		for (String path : swaggerPath) {
			if (src.startsWith(path)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @方法说明 是否需跳过权限的请求
	 **/
	public static boolean isSkip(String src) {
		if (src.equals("/"))
			return true;
		for (String path : skipPaths) {
			if (src.startsWith(path)) {
				return true;
			}
		}
		return false;
	}
}