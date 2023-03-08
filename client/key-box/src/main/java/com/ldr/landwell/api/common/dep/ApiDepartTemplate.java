package com.ldr.landwell.api.common.dep;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.ldr.landwell.api.common.result.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class ApiDepartTemplate {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${sys.urlPre}")
	private String urlPre = "";

	public Result query(InDepParam inDep) {
		HttpEntity<InDepParam> request = new HttpEntity<>(inDep, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "department/department_query", request, Result.class);
		JSONArray jsonArray = res.getData();
		List<DepInfo> list = jsonArray.toJavaList(DepInfo.class);
		log.info(JSON.toJSONString(list));
		return null;
	}
}
