package com.ats.bootloader.service;

import com.ats.bootloader.dao.TestPCSessionMapper;
import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.domain.TestPCSessionKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestPCSessionService {
    @Resource
    TestPCSessionMapper testPCSessionDao;

    public int insert(TestPCSession testPCSession) {
        return testPCSessionDao.insert(testPCSession);
    }

    public TestPCSession selectByKey(TestPCSessionKey key) {
        return testPCSessionDao.selectByPrimaryKey(key);
    }

    public int updateByKey(TestPCSession key) {
        return testPCSessionDao.updateByPrimaryKey(key);
    }

    public List<TestPCSession> findAll() {
        return testPCSessionDao.findAll();
    }

    public List<TestPCSession> findDmiInfoByMachineId(int key) {
        return testPCSessionDao.findDmiInfoByMachineId(key);
    }

    public List<TestPCSession> findPortStatus() {
        return testPCSessionDao.findPortStatus();
    }
}
