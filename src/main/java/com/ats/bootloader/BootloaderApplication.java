package com.ats.bootloader;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.ats.bootloader.dao")
public class BootloaderApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootloaderApplication.class, args);
    }

}

