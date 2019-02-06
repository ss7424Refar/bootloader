package com.ats.bootloader.dao;

import com.ats.bootloader.domain.TaskBasic;

public interface TaskBasicMapper {
    int deleteByPrimaryKey(Long taskId);

    int insert(TaskBasic record);

    int insertSelective(TaskBasic record);

    TaskBasic selectByPrimaryKey(Long taskId);

    int updateByPrimaryKeySelective(TaskBasic record);

    int updateByPrimaryKey(TaskBasic record);

    TaskBasic runTask(String lanIp);
}