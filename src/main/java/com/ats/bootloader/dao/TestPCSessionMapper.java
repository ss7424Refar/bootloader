package com.ats.bootloader.dao;

import com.ats.bootloader.domain.TestPCSession;
import com.ats.bootloader.domain.TestPCSessionKey;

public interface TestPCSessionMapper {
    int deleteByPrimaryKey(TestPCSessionKey key);

    int insert(TestPCSession record);

    int insertSelective(TestPCSession record);

    TestPCSession selectByPrimaryKey(TestPCSessionKey key);

    int updateByPrimaryKeySelective(TestPCSession record);

    int updateByPrimaryKey(TestPCSession record);
}