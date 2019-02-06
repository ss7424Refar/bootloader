package com.ats.bootloader.controller.ATS;

import com.ats.bootloader.config.BootLoaderConfig;
import com.ats.bootloader.domain.AssignTask;
import com.ats.bootloader.domain.TaskBasic;
import com.ats.bootloader.domain.TaskToolSteps;
import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.service.TaskBasicService;
import com.ats.bootloader.service.TaskToolStepsService;
import com.ats.bootloader.service.TestPCSessionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ATS")
public class atsController {

    private Logger logger = LoggerFactory.getLogger(atsController.class);

    @Autowired
    BootLoaderConfig bootLoaderConfig;

    @Autowired
    TestPCSessionService testPCSessionService;

    @Autowired
    TaskBasicService taskBasicService;

    @Autowired
    TaskToolStepsService taskToolStepsService;

    /**
     *  http://localhost:8081/boot-loader/ATS/getImageNames?q=php
     *  返回本地的ImageNames
     * @param q
     * @return List
     */
    @RequestMapping("getImageNames")
    public List getImageNames(String q) {
        // 存储Image名字
        List<Map<String, String>> list = new ArrayList<>();
        // get file list where the path has
        File file = new File(bootLoaderConfig.getImagePath());
        // get the folder list
        File[] files = file.listFiles();

        if (null != files) {
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
        }
        return list;
    }

    /**
     * 返回测试机id， name
     * localhost:8081/boot-loader/ATS/getMachineList?q=G
     * @param q
     * @return
     */
    @RequestMapping("getMachineList")
    public List getMachineList(String q) {
        List<Map<String, Object>> list = new ArrayList<>();

        List<TestPCSession> list1 = testPCSessionService.findAll();

        if (null != list1) {
            for (TestPCSession testPCSession : list1) {
                String appendMachineName = testPCSession.getMachineName() + "(" + testPCSession.getMachineId() + ")";

                if ("".equals(q.trim())) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", testPCSession.getMachineId());
                    map.put("text", appendMachineName);
                    list.add(map);
                } else {
                    if (appendMachineName.contains(q.trim())) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("id", testPCSession.getMachineId());
                        map.put("text", appendMachineName);
                        list.add(map);
                    }
                }

            }
        }

        return list;
    }

    /**
     * 返回机子的dmi信息
     * http://localhost:8081/boot-loader/ATS/getMachineInfo?machineId=1607123
     * todo: ats需要修改
     * [{"dmiOemString":"PRT10U-AAAA4,PCN3381CCZ01FA1F/S3A-----X--","shelfSwitch":"1_2","dmiSystemConfig":"2","dmiSerialNumber":"7G1217891","dmiPartNumber":"PS68NNP-NXA","dmiProductName":"dynabook Tab S69/NG","biosEc":"4","lanIp":"192.168.1.109"}]
     * @param machineId
     * @return List
     */
    @RequestMapping("getMachineInfo")
    public List getMachineInfo(int machineId) {
        return testPCSessionService.findDmiInfoByMachineId(machineId);
    }

    /**
     * http://localhost:8081/boot-loader/ATS/assignTask
     * 1. 在postman中
     * 2. todo: ats 需要修改ongoing 之后抽取json
     * @param assignTask
     * @return
     */
    @RequestMapping("assignTask")
    public String assignTask(@RequestBody AssignTask assignTask) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // 解析json对象from ats
            String json = mapper.writeValueAsString(assignTask);
            JsonNode rootNode = mapper.readTree(json);

            JsonNode taskBasic = rootNode.path("task_basic");

            // json转换成对象
            TaskBasic taskBasic1 = mapper.readValue(mapper.writeValueAsString(taskBasic.get(0)), TaskBasic.class);

            // 插入数据 TaskBasic
            logger.info("parse task basic ... " + taskBasic1.toString());
            taskBasicService.insert(taskBasic1);

            JsonNode taskSteps = rootNode.path("task_steps");
            for (int i = 0; i < taskSteps.size(); i++) {
                TaskToolSteps taskToolStep = mapper.readValue(mapper.writeValueAsString(taskSteps.get(i)), TaskToolSteps.class);
                logger.info("parse task step ... " + taskToolStep.toString());
                // 插入数据 TaskSteps
                taskToolStepsService.insert(taskToolStep);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "done";
    }
}
