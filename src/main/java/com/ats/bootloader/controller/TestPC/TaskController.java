package com.ats.bootloader.controller.TestPC;

import com.ats.bootloader.domain.TaskBasic;
import com.ats.bootloader.service.TaskBasicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("TestPC")
public class TaskController {

    @Resource
    TaskBasicService taskBasicService;

    /**
     * http://localhost:8081/boot-loader/TestPC/runTask?lanIp=192.168.1.108
     * todo: xml还是需要改成ongoing，以ip来查询，返回
     * @param lanIp
     * @return
     */
    @RequestMapping("runTask")
    public TaskBasic runTask(String lanIp) {

        return taskBasicService.runTask(lanIp);
    }

}
