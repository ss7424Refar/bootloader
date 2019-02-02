package com.ats.bootloader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration // @Configuration标注在类上，相当于把该类作为spring的xml配置文件中的<beans>
public class RestClientConfig {

    @Autowired
    BootLoaderConfig bootLoaderConfig;

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        // 设置超时
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(bootLoaderConfig.getHttpConnectTimeOut());
        simpleClientHttpRequestFactory.setReadTimeout(bootLoaderConfig.getHttpReadTimeOut());
        return simpleClientHttpRequestFactory;
    }

    @Bean // 操作相当于实例化Bean ，并交给spring管理
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory){
        return new RestTemplate(clientHttpRequestFactory);
    }

}
