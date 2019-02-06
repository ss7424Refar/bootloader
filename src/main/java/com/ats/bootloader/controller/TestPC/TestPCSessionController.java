package com.ats.bootloader.controller.TestPC;

import com.ats.bootloader.controller.ATS.atsController;
import com.ats.bootloader.domain.JsonResult;
import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.service.TestPCSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testPCSession")
public class TestPCSessionController {

    private Logger logger = LoggerFactory.getLogger(TestPCSessionController.class);

    @Autowired
    TestPCSessionService testPCSessionService;

    /**
     *  插入测试机数据到31接口
     * @param testPCSession
     * @return
     */
    @RequestMapping("insert")
    // http://localhost:8081/boot-loader/testPCSession/insert?id=1_9&machineName=Altair UR CS1&machineId=1607122&lanIp=192.168.1.109&shelfSwitch=1_1&dmiProductName=dynabook Tab S69/NG
    //&dmiPartNumber=PS68NNP-NXA&dmiSerialNumber=7G1217891&dmiOemString=PRT10U-AAAA4,PCN3381CCZ01FA1F/S3A-----X--&dmiSystemConfig=2&biosEc=4
    public JsonResult insertTestPCSession(TestPCSession testPCSession) {

        // 根据id查询存在的机子
        TestPCSession testPCSession1 = testPCSessionService.selectByKey(testPCSession);

        if (null != testPCSession1) {
            int result = testPCSessionService.updateByKey(testPCSession);
            if (result > 0) {
                return JsonResult.success(result);
            }
            return JsonResult.error(null);
        }

        int result = testPCSessionService.insert(testPCSession);
        if (result > 0) {
            return JsonResult.success(result);
        }
        return JsonResult.error(null);
    }
}
