package com.ats.bootloader.controller.TestPC;

import com.ats.bootloader.config.BootLoaderConfig;
import com.ats.bootloader.controller.ATS.atsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mail")
public class MailController {

    private Logger logger = LoggerFactory.getLogger(MailController.class);

    @Resource
    BootLoaderConfig bootLoaderConfig;

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("sendBaselineMail")
    public String sendBaselineMail(String taskId, String steps){
        ResponseEntity<String> response = restTemplate.exchange(bootLoaderConfig.getSendBaselineMailUrl(), HttpMethod.GET, returnEntity(taskId, steps), String.class);
        return response.getBody();
    }

    @RequestMapping("sendResultMail")
    public String sendResultMail(String taskId, String steps){
        ResponseEntity<String> response = restTemplate.exchange(bootLoaderConfig.getSendResultMailUrl(), HttpMethod.GET, returnEntity(taskId, steps), String.class);
        return response.getBody();

    }

    private HttpEntity<MultiValueMap<String, String>> returnEntity(String taskId, String steps) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("taskId", taskId);
        params.add("steps", steps);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        return  new HttpEntity<>(params, headers);
    }
}
