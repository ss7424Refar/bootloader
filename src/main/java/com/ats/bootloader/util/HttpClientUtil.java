package com.ats.bootloader.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientUtil {

    @Autowired
    private RestTemplate restTemplate;

    public String request(String url, HttpMethod method, MediaType contentType, MultiValueMap<String, String> params){

        HttpHeaders headers = new HttpHeaders();
        // MediaType.APPLICATION_FORM_URLENCODED
        headers.setContentType(contentType);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求 // HttpMethod.POST
        ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }

}
