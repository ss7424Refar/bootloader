package com.ats.bootloader.controller.TestPC;

import com.ats.bootloader.config.BootLoaderConfig;
import com.ats.bootloader.domain.TaskBasic;
import com.ats.bootloader.domain.TaskToolSteps;
import com.ats.bootloader.service.TaskBasicService;
import com.ats.bootloader.service.TaskToolStepsService;
import com.ats.bootloader.service.TestPCSessionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("TestPC")
public class TaskController {

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

    /**
     * todo: 待实际测试，ats接口没有验证。
     * @param taskId
     * @param steps
     * @param status
     * @return
     */
    @RequestMapping("updateTask")
    public String updateTask(Long taskId, int steps, String status) {
        // update boot-loader.ats_task_steps
        taskToolStepsService.updateByTaskIdAndSteps(taskId, steps, status);

        // 查询是否还有其他的steps
        TaskToolSteps taskToolSteps = taskToolStepsService.findNextStepsByTaskId(taskId, steps + 1);

        // 更新task_basic
        if (null == taskToolSteps) {
            taskBasicService.updateByPrimaryKey(taskId);

            //Delete session get machineId
            TaskBasic taskBasic = taskBasicService.selectByPrimaryKey(taskId);
            testPCSessionService.deleteByPrimaryKey(taskBasic.getMachineId());

        }

        // request 31's url
        String url = bootLoaderConfig.getUpdateTaskUrl();
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("taskId", taskId);
        paramMap.put("steps", steps);
        paramMap.put("status", status);

        return restTemplate.getForObject(url, String.class, paramMap);
    }


}
