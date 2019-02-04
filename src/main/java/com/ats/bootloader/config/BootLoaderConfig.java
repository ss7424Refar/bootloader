package com.ats.bootloader.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration // 指明当前类是一个配置类, 来替代之前的Spring配置文件
@ConfigurationProperties(prefix = "app", ignoreInvalidFields = false)
@PropertySource(value = {"classpath:config/bootLoader.properties"}, encoding = "utf-8")
@Component // 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能； 所以加上@Component注解
public class BootLoaderConfig {

    private int httpConnectTimeOut;
    private int httpReadTimeOut;

    private String imagePath;

    private int threadPool;

    public int getHttpConnectTimeOut() {
        return httpConnectTimeOut;
    }

    public void setHttpConnectTimeOut(int httpConnectTimeOut) {
        this.httpConnectTimeOut = httpConnectTimeOut;
    }

    public int getHttpReadTimeOut() {
        return httpReadTimeOut;
    }

    public void setHttpReadTimeOut(int httpReadTimeOut) {
        this.httpReadTimeOut = httpReadTimeOut;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(int threadPool) {
        this.threadPool = threadPool;
    }
}
