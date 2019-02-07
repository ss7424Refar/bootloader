package com.ats.bootloader.controller;

import com.ats.bootloader.config.BootLoaderConfig;
import com.ats.bootloader.domain.AssignTask;
import com.ats.bootloader.domain.TaskBasic;
import com.ats.bootloader.domain.TaskToolSteps;
import com.ats.bootloader.service.TaskBasicService;
import com.ats.bootloader.service.TaskToolStepsService;
import com.ats.bootloader.service.TestPCSessionService;
import com.ats.bootloader.util.HttpClientUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    TaskBasicService taskBasicService;

    @Resource
    TaskToolStepsService taskToolStepsService;

    @Resource
    TestPCSessionService testPCSessionService;

    @Resource
    RestTemplate restTemplate;

    @Resource
    BootLoaderConfig bootLoaderConfig;

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
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("q", ".log");
        return httpClientUtil.request(url, HttpMethod.GET, MediaType.APPLICATION_JSON_UTF8, params);
    }

    @GetMapping("testHttp2")
    public String testHttp2() {
        String url = "https://www.baidu.com/";
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
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

    @RequestMapping("requestJson")
    public String assignTaskTest(@RequestBody AssignTask assignTask) {

        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            // 解析json对象
            json = mapper.writeValueAsString(assignTask);
            JsonNode rootNode = mapper.readTree(json);

            JsonNode taskBasic = rootNode.path("task_basic");

            System.out.println(taskBasic);
            System.out.println("machineName = " + taskBasic.get(0).path("machine_name").asText());

            TaskBasic taskBasic1 = mapper.readValue(mapper.writeValueAsString(taskBasic.get(0)), TaskBasic.class);

            System.out.println("taskBasic = " + taskBasic1.getBiosEc());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("updateSteps")
    public int updateTask(Long taskId, int steps, String status) {
        // update boot-loader.ats_task_steps
        return taskToolStepsService.updateByTaskIdAndSteps(taskId, steps, status);

    }

    @RequestMapping("findSteps")
    public TaskToolSteps findSteps(Long taskId, int steps) {
        // update boot-loader.ats_task_steps
        return taskToolStepsService.findNextStepsByTaskId(taskId, steps);

    }

    @RequestMapping("updateBasicTask")
    public int updateBasic(Long taskId) {
        return taskBasicService.updateByPrimaryKey(taskId);
    }

    @RequestMapping("deleteSession")
    public int deleteSession(Long taskId) {
        TaskBasic taskBasic = taskBasicService.selectByPrimaryKey(taskId);
//        System.out.println(taskBasic.getMachineId());
        return testPCSessionService.deleteByPrimaryKey(taskBasic.getMachineId());
    }
}
