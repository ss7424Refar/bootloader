package com.ats.bootloader.service;

import com.ats.bootloader.domain.TestPCSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时类
 */
@Service
public class ScheduledService {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledService.class);

    @Resource
    TestPCSessionService testPCSessionService;

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        logger.info("sending port status in 5s... ");

        List<TestPCSession> list = testPCSessionService.findPortStatus();
        String msg = "";
        if (null != list) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, List<TestPCSession>> map = new HashMap<>();
            try {
                map.put("result", list);
                msg = mapper.writeValueAsString(map);

                WebSocketServerService.sendInfo(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.info("sending port status in 5s... no data ...");
        }

    }

    @Scheduled(fixedRate = 5000)
    // 定义一个按一定频率执行的定时任务
    public void scheduled1() {
        logger.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }
    @Scheduled(fixedDelay = 5000)
    // 定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间
    public void scheduled2() { logger.info("=====>>>>>fixedDelay{}",System.currentTimeMillis()); }
}
