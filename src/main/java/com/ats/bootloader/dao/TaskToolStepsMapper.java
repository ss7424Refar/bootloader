package com.ats.bootloader.dao;

import com.ats.bootloader.domain.TaskToolSteps;

public interface TaskToolStepsMapper {
    int insert(TaskToolSteps record);

    int insertSelective(TaskToolSteps record);
}