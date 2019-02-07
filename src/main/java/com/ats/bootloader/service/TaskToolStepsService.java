package com.ats.bootloader.service;

import com.ats.bootloader.dao.TaskToolStepsMapper;
import com.ats.bootloader.domain.TaskToolSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskToolStepsService {

    @Resource
    TaskToolStepsMapper taskToolStepsDao;

    public int insert(TaskToolSteps record) {
        return taskToolStepsDao.insert(record);
    }

    public int updateByTaskIdAndSteps(Long taskId, Integer steps, String status) {
        return taskToolStepsDao.updateByTaskIdAndSteps(taskId, steps, status);
    }

    public TaskToolSteps findNextStepsByTaskId(Long taskId, Integer steps) {
        return taskToolStepsDao.findNextStepsByTaskId(taskId, steps);
    }
}
