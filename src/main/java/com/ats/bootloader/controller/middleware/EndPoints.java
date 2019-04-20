package com.ats.bootloader.controller.middleware;

import com.ats.bootloader.util.Configure;
import com.ats.bootloader.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("EndPoints")
public class EndPoints {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpClientUtil httpClientUtil;

    // http://localhost/ats/services/UpdateTask/updater?taskId=81&steps=2&status=1
    @RequestMapping("updateTask")
    public String updateTask(int taskId, int steps, int status){

        String url = Configure.UPDATE_URL + "?taskId=" + taskId +"&steps=" + steps +"&status=" + status;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();

    }

    /**
     * http://localhost/ats/services/SendMail/sendStepsResult?taskId=81&steps=2
     * @param taskId
     * @param steps
     * @return
     */

    @RequestMapping("sendMail")
    public String sendMail(int taskId, int steps){

        String url = Configure.SENDMAIL_URL + "?taskId=" + taskId +"&steps=" + steps;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();

    }

    /**
     * http://localhost/ats/services/SendMail/sendBaseLine?taskId=81&steps=2
     * @param taskId
     * @param steps
     * @return
     */
    @RequestMapping("sendMailBaseline")
    public String sendMailBaseline(int taskId, int steps){

        String url = Configure.SENDMAIL_BASELINE_URL + "?taskId=" + taskId +"&steps=" + steps;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();

    }
}
