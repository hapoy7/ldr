package com.gzz.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类说明 【智能管控】 API
 * @author keke
 * @date 2022/11/8 16:55
 **/
@Slf4j
@RestController
@RequestMapping("intelligent")
public class intelligentController {

    /**
     * 接收 为按时还钥匙的方法
     * @param keyInfo 未归还钥匙的信息
     */
    @PostMapping("keyRecord")
    public void getKeyRecord(@RequestBody String keyInfo) {
        log.info("【智能管控】: " + keyInfo);
    }
}
