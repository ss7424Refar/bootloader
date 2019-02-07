package com.ats.bootloader.dao;

import com.ats.bootloader.domain.TaskToolSteps;

public interface TaskToolStepsMapper {
    int insert(TaskToolSteps record);

    int insertSelective(TaskToolSteps record);

    int updateByTaskIdAndSteps(Long taskId, Integer steps, String status);

    TaskToolSteps findNextStepsByTaskId(Long taskId, Integer steps);
}