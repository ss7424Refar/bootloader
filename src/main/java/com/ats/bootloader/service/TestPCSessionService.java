package com.ats.bootloader.service;

import com.ats.bootloader.dao.TestPCSessionMapper;
import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.domain.TestPCSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPCSessionService {
    @Autowired
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
}
