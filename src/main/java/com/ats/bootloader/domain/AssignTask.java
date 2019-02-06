package com.ats.bootloader.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AssignTask {
    @JsonProperty("task_basic")
    private List<TaskBasic> taskBasic;

    @JsonProperty("task_steps")
    private List<TaskToolSteps> taskToolSteps;

    public List<TaskBasic> getTaskBasic() {
        return taskBasic;
    }

    public void setTaskBasic(List<TaskBasic> taskBasic) {
        this.taskBasic = taskBasic;
    }

    public List<TaskToolSteps> getTaskToolSteps() {
        return taskToolSteps;
    }

    public void setTaskToolSteps(List<TaskToolSteps> taskToolSteps) {
        this.taskToolSteps = taskToolSteps;
    }
}
