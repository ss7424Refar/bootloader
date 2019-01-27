package com.ats.bootloader.controller.TestPC;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testPCController {

    @RequestMapping(value = "testPC/start")
    public String testPC() {
        return "test_pc";
    }
}
