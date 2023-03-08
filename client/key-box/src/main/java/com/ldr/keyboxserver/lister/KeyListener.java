package com.ldr.keyboxserver.lister;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ldr.manage.base.baseoperation.BaseOperation;
import com.ldr.manage.base.baseoperation.BaseOperationCond;
import com.ldr.manage.base.baseoperation.BaseOperationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 钥匙柜系统和智能管控系统 信息交互的类
 * @author keke
 * @date 2022/11/8 16:15
 **/
@Slf4j
@Component
public class KeyListener {

	@Autowired
	private BaseOperationService baseOperationService; // 注入【操作日志】业务逻辑层
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; // 注入 kafka模板类

	/**
	 * 监听 钥匙柜系统 的消息
	 * 
	 * @param record 监听得到的信息
	 */
	@KafkaListener(topics = "requestMessage", groupId = "writeDB")
	public void forwardZhi(ConsumerRecord<?, ?> record) {
		// 打印日志
		log.info("topic={},offset={},value={}", record.topic(), record.offset(), record.value());
		// 写入数据库取钥匙记录
	}

	/**
	 * 监听 智能管控 的响应消息
	 * 
	 * @param record 监听得到的信息
	 */
	@KafkaListener(topics = "responseMessage", groupId = "response")
	public void receive(ConsumerRecord<?, ?> record) {
		log.info("topic={},offset={},value={}", record.topic(), record.offset(), record.value() + " 智能管控响应:确认开门");
	}

	/**
	 * 定时扫描取钥匙记录表,未按时归还的发送告警给智能管控系统
	 */
	@Scheduled(fixedDelay = 1000 * 60 * 10)
	public void recordTask() {
		// 获取当前时间的前12个小时
		LocalDateTime minus = LocalDateTime.now().minusHours(12L);
		BaseOperationCond cond = BaseOperationCond.builder().status((byte) 0).optTime(minus).build();
		// 查询超过12小时未归还钥匙的记录
		List<BaseOperation> operationList = baseOperationService.list(cond);
		operationList.forEach(operation -> {
			log.info("[{}]在[{}]时间取走[{}]号钥匙柜的[{}]个钥匙!已超过12小时未归还!", operation.getUserName(), operation.getOptTime(), operation.getBoxName(), operation.getKeyName());

			// 向智能管控发出告警信息
			kafkaTemplate.send("recordMessage",
					operation.getUserName() + "在" + operation.getOptTime().toString() + "时间取走" + operation.getBoxName() + "号钥匙柜的" + operation.getKeyName() + "个钥匙!已超过12小时未归还!");
		});
	}
}
