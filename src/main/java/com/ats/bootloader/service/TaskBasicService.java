package com.ats.bootloader.service;

import com.ats.bootloader.dao.TaskBasicMapper;
import com.ats.bootloader.domain.TaskBasic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskBasicService {
    @Resource
    TaskBasicMapper taskBasicDao;

    public TaskBasic selectByPrimaryKey(Long taskId) {
        return taskBasicDao.selectByPrimaryKey(taskId);
    }
    public int insert(TaskBasic record) {
        return taskBasicDao.insert(record);
    };

    public TaskBasic runTask(String lanIp) {
        return taskBasicDao.runTask(lanIp);
    }

    public int updateByPrimaryKey(Long taskId) {
        return taskBasicDao.updateByPrimaryKey(taskId);
    }
}
