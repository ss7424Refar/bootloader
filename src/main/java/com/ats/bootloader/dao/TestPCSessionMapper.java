package com.ats.bootloader.dao;

import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.domain.TestPCSessionKey;

import java.util.List;

public interface TestPCSessionMapper {
    int deleteByPrimaryKey(Integer machineId);

    int insert(TestPCSession record);

    int insertSelective(TestPCSession record);

    TestPCSession selectByPrimaryKey(TestPCSessionKey key);

    int updateByPrimaryKeySelective(TestPCSession record);

    int updateByPrimaryKey(TestPCSession record);

    List<TestPCSession> findAll();

    List<TestPCSession> findDmiInfoByMachineId(int key);

    List<TestPCSession> findPortStatus();
}