package com.ats.bootloader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String getTemp() {
        return "temp/helloworld";
    }

    @RequestMapping(value = "/matrix")
    public String getMatrix() {
        return "temp/matrix";
    }

}
