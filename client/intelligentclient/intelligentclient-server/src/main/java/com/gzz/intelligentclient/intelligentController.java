package com.gzz.intelligentclient;


import com.gzz.websocket.KafkaWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
//@RequestMapping("intelligent")
//@RestController
public class intelligentController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "requestMessage", groupId = "intelligentControl")
    public void getInfo(ConsumerRecord<?, ?> record) {
        log.info("topic={},offset={},value={},time={}", record.topic(), record.offset(), record.value(), record.timestamp());
        KafkaWebSocket.sendInfo(record.value().toString());
    }

    /**
     * 智能管控 接收到取钥匙请求，响应信息
     */
    @GetMapping("responseMessage")
    public void responseMessage(String status) {
        kafkaTemplate.send("responseMessage", status);
    }

    /**
     *  接收 钥匙柜系统 发送来的超时未归还钥匙的记录
     */
    @KafkaListener(topics = "recordMessage", groupId = "recordMessage")
    public void recordInfo(ConsumerRecord<?, ?> record) {
        log.info("topic={},offset={},value={},time={}", record.topic(), record.offset(), record.value(), record.timestamp());
    }

    /**
     * 接收钥匙柜回传的已开门信息
     */
    @KafkaListener(topics = "confirmMessage", groupId = "confirmMessage")
    public void confirmInfo(ConsumerRecord<?, ?> record) {
        log.info("topic={},offset={},value={},time={}", record.topic(), record.offset(), record.value(), record.timestamp());
    }

}
