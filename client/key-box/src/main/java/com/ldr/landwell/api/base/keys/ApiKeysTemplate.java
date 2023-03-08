package com.ldr.landwell.api.base.keys;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ldr.landwell.api.common.result.Result;

import java.util.List;

@Slf4j
@Service
public class ApiKeysTemplate {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${sys.urlPre}")
	private String urlPre = "";
	//钥匙信息查询 keyinfo/keyinfo_query
	public Result query(KeyParam keyParam) {
		HttpEntity<KeyParam> request = new HttpEntity<>(keyParam, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "keyinfo/keyinfo_query", request, Result.class);
		log.info(res.toString());
		return null;
	}

	public Result add() {
        List<KeyParam> list=  List.of(KeyParam.builder()
						.keyID("500317358733135872")
                        .departmentId("495231662779535360")
						//.userNumber(221015)
                        .build());
        HttpEntity<List<KeyParam>> request = new HttpEntity<>(list, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "userinfo/userinfo_add", request, Result.class);
        log.info(res.toString());
        return null;
    }

	public Result update() {
		List<KeyParam> list=  List.of(KeyParam.builder()
				.keyID("500317358733135872")
				.departmentId("495231662779535360")
				.build());
		HttpEntity<List<KeyParam>> request = new HttpEntity<>(list, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "keyinfo/keyinfo_update", request, Result.class);
		log.info(res.toString());
		return null;
	}

	public Result delete() {
		List<KeyParam> list=  List.of(KeyParam.builder()
				.keyID("500317358733135872")
				.departmentId("495231662779535360")
				.build());
		HttpEntity<List<KeyParam>> request = new HttpEntity<>(list, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "keyinfo/keyinfo_delete", request, Result.class);
		log.info(res.toString());
		return null;
	}
}
