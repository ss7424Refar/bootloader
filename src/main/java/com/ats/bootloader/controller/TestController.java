package com.ats.bootloader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/helloWorld8")
    public String helloWorld2() {
        return "hello world2";
    }

    @GetMapping("getFileName")
    public List getFileName(String q) {
        List<Map<String, String>> list = new ArrayList<>();
        // get file list where the path has
        File file = new File("/home/refar/test");
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

}
