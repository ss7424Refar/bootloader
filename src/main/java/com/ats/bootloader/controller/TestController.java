package com.ats.bootloader.controller;

import com.ats.bootloader.config.BootLoaderConfig;
import com.ats.bootloader.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    BootLoaderConfig bootLoaderConfig;

    @Resource
    RestTemplate restTemplate;

    @Autowired
    HttpClientUtil httpClientUtil;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/helloWorld8")
    public String helloWorld2() {
        return "hello world2";
    }

    @GetMapping("testHttp")
    public String testHttp() {
        String url = "http://localhost:8081/boot-loader/getFileName";
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("q", ".log");
        return httpClientUtil.request(url, HttpMethod.GET, MediaType.APPLICATION_JSON_UTF8, params);
    }

    @GetMapping("testHttp2")
    public String testHttp2() {
        String url = "https://www.baidu.com/";
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
//        params.add("q", ".log");
        String response = httpClientUtil.request(url, HttpMethod.GET, MediaType.APPLICATION_JSON_UTF8, params);
        System.out.println(response);
        return response;
    }

//    @GetMapping("/getUrl2")
//    public String getHttpUrl2() {
//
//        return bootLoaderConfig.getHttpUrl();
//    }

    @GetMapping("/getUrl3")
    public String testHttp3() {
        String url = "http://localhost:8081/boot-loader/getFileName";

        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/testLogger")
    public String logger() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");

        return "logger";
    }
}
