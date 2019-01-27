package com.ats.bootloader.controller;

import com.ats.bootloader.properties.ConfigProperties;
import com.ats.bootloader.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    ConfigProperties configProperties;

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

    @GetMapping("/getFileName")
    public List getFileName(String q) {
        List<Map<String, String>> list = new ArrayList<>();
        // get file list where the path has
        File file = new File("/home/refar");
        // get the folder list
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile()) {
                String fileName = f.getName();

                Map<String, String> map = new HashMap<>();

                if (q != null && q.length() != 0) {
                    if (fileName.contains(q)) {
                        map.put("id", f.getName());
                        map.put("text", f.getName());
                        list.add(map);
                    }

                } else {
                    map.put("id", f.getName());
                    map.put("text", f.getName());
                    list.add(map);
                }

            }
        }
        return list;
    }

    @GetMapping("/getUrl")
    public String getHttpUrl() {

        return configProperties.getHttpUrl();
    }

    @GetMapping("testHttp")
    public String testHttp() {
        String url = "http://localhost:8081/boot-loader/getFileName";
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
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
}
