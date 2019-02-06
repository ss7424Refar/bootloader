package com.ats.bootloader.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TaskToolSteps {
    @JsonProperty("task_id")
    private Long taskId;

    @JsonProperty("tool_name")
    private String toolName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("steps")
    private Integer steps;

    @JsonProperty("element_json")
    private Object elementJson;

    @JsonProperty("result_path")
    private String resultPath;

    @JsonProperty("tool_create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date toolCreateTime;

    @JsonProperty("tool_start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date toolStartTime;

    @JsonProperty("tool_end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date toolEndTime;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Object getElementJson() {
        return elementJson;
    }

    public void setElementJson(Object elementJson) {
        this.elementJson = elementJson;
    }

    public String getResultPath() {
        return resultPath;
    }

    public void setResultPath(String resultPath) {
        this.resultPath = resultPath == null ? null : resultPath.trim();
    }

    public Date getToolCreateTime() {
        return toolCreateTime;
    }

    public void setToolCreateTime(Date toolCreateTime) {
        this.toolCreateTime = toolCreateTime;
    }

    public Date getToolStartTime() {
        return toolStartTime;
    }

    public void setToolStartTime(Date toolStartTime) {
        this.toolStartTime = toolStartTime;
    }

    public Date getToolEndTime() {
        return toolEndTime;
    }

    public void setToolEndTime(Date toolEndTime) {
        this.toolEndTime = toolEndTime;
    }

    @Override
    public String toString() {
        return "TaskToolSteps{" +
                "taskId=" + taskId +
                ", toolName='" + toolName + '\'' +
                ", status='" + status + '\'' +
                ", steps=" + steps +
                ", elementJson=" + elementJson +
                ", resultPath='" + resultPath + '\'' +
                ", toolCreateTime=" + toolCreateTime +
                ", toolStartTime=" + toolStartTime +
                ", toolEndTime=" + toolEndTime +
                '}';
    }
}