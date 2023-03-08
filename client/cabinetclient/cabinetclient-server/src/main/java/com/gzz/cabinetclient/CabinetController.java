package com.gzz.cabinetclient;


import com.gzz.vo.RequestParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("keyClient")
public class CabinetController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 工控机 发送取钥匙请求
     */
    @PostMapping("send")
    public void product(@RequestBody RequestParam param) {
        //String data = "userNo = xxx,keyNoList = [xxxx,xxxx,xxx,],keyBoxNo = xxxx";
        //kafkaTemplate.send("requestMessage", param.toString());
        String url = "http://localhost:9999/keyBox/borrowKey";
        restTemplate.postForEntity(url, param, void.class);
    }

    /**
     * 钥匙柜回传已开门的信息
     */
    @KafkaListener(topics = "responseMessage", groupId = "cabinet")
    public void receive(ConsumerRecord<?, ?> record) {
        log.info("topic={},offset={},value={}", record.topic(), record.offset(), record.value() + "钥匙柜收到智能管控的开门信息");
        //当收到确认开门的消息后,回传钥匙柜已经开门的信息
        kafkaTemplate.send("confirmMessage", "工控机已开门");
    }
}
