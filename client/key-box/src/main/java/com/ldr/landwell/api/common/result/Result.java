package com.ldr.landwell.api.common.result;

import com.alibaba.fastjson2.JSONArray;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Result {

	private Integer resultCode;
	private String message;
	private Integer recordCount;
	private JSONArray data;
	private String description;

}
