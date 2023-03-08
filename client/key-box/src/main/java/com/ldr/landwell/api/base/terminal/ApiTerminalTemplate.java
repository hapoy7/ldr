package com.ldr.landwell.api.base.terminal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ldr.landwell.api.base.box.BoxInfo;
import com.ldr.landwell.api.common.result.Result;

import java.util.List;

@Slf4j
@Service
public class ApiTerminalTemplate {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${sys.urlPre}")
	private String urlPre;

	public Result update(Terminal param) {
		List<Terminal> terminalList = List.of(param);
		HttpEntity<List<Terminal>> request = new HttpEntity<>(terminalList, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "terminal/terminal_update", request, Result.class);
		log.info(res.toString());
		return res;
	}

	public Result query(TerminalParam terminalInfo) {
		HttpEntity<TerminalParam> request = new HttpEntity<>(terminalInfo, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "terminal/terminal_query", request, Result.class);
		log.info(res.toString());
		return res;
	}

	public Result add() {
		BoxInfo boxInfo = BoxInfo.builder()
				.boxName("1")
				.boxNumber(1)
				.keyCount(200)
				.boxInfor("1111111111111")
				.baseModifierId("1")
				.baseModifyTime("2022-04-21 16:17:55")
				.build();

		Terminal ter = Terminal.builder()
				.terminalNumber(2020) // 终端机编号(必填)//不要与现在重复
				.terminalName("测试柜-11") // 终端机名称
				.departmentId("495231662779535360") // 部门id(必填)
				.boxCount(1) // 钥匙柜数量
				.superPassword("111111") // 管理员密码
				.urgentlyPassword("111111") // 紧急取钥匙密码
				.boxInfo(List.of(boxInfo)) // 钥匙柜信息
				.build();

		List<Terminal> terminalList = List.of(ter);
		HttpEntity<List<Terminal>> request = new HttpEntity<>(terminalList, new HttpHeaders());
		Result res = restTemplate.postForObject(urlPre + "terminal/terminal_add", request, Result.class);
		log.info(res.toString());
		return res;
	}

	 public Result delete() {
		 List<TerminalParam> list=  List.of(TerminalParam.builder()
						 .terID("499954096673918976")
						 .departmentId("495231662779535360")
				 		 .build());

		 HttpEntity<List<TerminalParam>> request = new HttpEntity<>(list, new HttpHeaders());
		 Result res = restTemplate.postForObject(urlPre + "terminal/terminal_delete", request, Result.class);
		 log.info(res.getRecordCount().toString());
		 return res;
	 }

}
