package com.ldr.common.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @summary【JSON】转换工具
 * @author 高振中
 * @date 2021-04-20 23:34:58
 **/
@Slf4j
@Component
public class JSONTools {
	@Autowired
	private ObjectMapper mapper;// 注入jackSon工具
	private static final String MESSAGE="转成JSONString时出现异常";

	/**
	 * Java对象转JSON-String(大量长期使用)
	 */
	public String toJSONString(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(MESSAGE, e);
			throw new RuntimeException(MESSAGE);
		}
	}

	/**
	 *  Java对象转JSON-String(临时使用)
	 */
	public static String toString(Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(MESSAGE, e);
			throw new RuntimeException(MESSAGE);
		}
	}
}
