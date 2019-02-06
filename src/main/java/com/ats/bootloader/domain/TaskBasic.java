package com.ats.bootloader.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class TaskBasic {
    @JsonProperty("task_id")
    private Long taskId;

    @JsonProperty("machine_id")
    private Integer machineId;

    @JsonProperty("machine_name")
    private String machineName;

    @JsonProperty("category")
    private String category;

    @JsonProperty("lan_ip")
    private String lanIp;

    @JsonProperty("shelf_switch")
    private String shelfSwitch;

    @JsonProperty("dmi_product_name")
    private String dmiProductName;

    @JsonProperty("dmi_part_number")
    private String dmiPartNumber;

    @JsonProperty("dmi_serial_number")
    private String dmiSerialNumber;

    @JsonProperty("dmi_oem_string")
    private String dmiOemString;

    @JsonProperty("dmi_system_config")
    private String dmiSystemConfig;

    @JsonProperty("bios_ec")
    private String biosEc;

    @JsonProperty("status")
    private String status;

    @JsonProperty("process")
    private Integer process;

    @JsonProperty("task_create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskCreateTime;

    @JsonProperty("task_start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskStartTime;

    @JsonProperty("task_end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date taskEndTime;

    @JsonProperty("tester")
    private String tester;

    private TaskToolSteps taskToolSteps;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getLanIp() {
        return lanIp;
    }

    public void setLanIp(String lanIp) {
        this.lanIp = lanIp == null ? null : lanIp.trim();
    }

    public String getShelfSwitch() {
        return shelfSwitch;
    }

    public void setShelfSwitch(String shelfSwitch) {
        this.shelfSwitch = shelfSwitch == null ? null : shelfSwitch.trim();
    }

    public String getDmiProductName() {
        return dmiProductName;
    }

    public void setDmiProductName(String dmiProductName) {
        this.dmiProductName = dmiProductName == null ? null : dmiProductName.trim();
    }

    public String getDmiPartNumber() {
        return dmiPartNumber;
    }

    public void setDmiPartNumber(String dmiPartNumber) {
        this.dmiPartNumber = dmiPartNumber == null ? null : dmiPartNumber.trim();
    }

    public String getDmiSerialNumber() {
        return dmiSerialNumber;
    }

    public void setDmiSerialNumber(String dmiSerialNumber) {
        this.dmiSerialNumber = dmiSerialNumber == null ? null : dmiSerialNumber.trim();
    }

    public String getDmiOemString() {
        return dmiOemString;
    }

    public void setDmiOemString(String dmiOemString) {
        this.dmiOemString = dmiOemString == null ? null : dmiOemString.trim();
    }

    public String getDmiSystemConfig() {
        return dmiSystemConfig;
    }

    public void setDmiSystemConfig(String dmiSystemConfig) {
        this.dmiSystemConfig = dmiSystemConfig == null ? null : dmiSystemConfig.trim();
    }

    public String getBiosEc() {
        return biosEc;
    }

    public void setBiosEc(String biosEc) {
        this.biosEc = biosEc == null ? null : biosEc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester == null ? null : tester.trim();
    }

    public TaskToolSteps getTaskToolSteps() {
        return taskToolSteps;
    }

    public void setTaskToolSteps(TaskToolSteps taskToolSteps) {
        this.taskToolSteps = taskToolSteps;
    }

    @Override
    public String toString() {
        return "TaskBasic{" +
                "taskId=" + taskId +
                ", machineId=" + machineId +
                ", machineName='" + machineName + '\'' +
                ", category='" + category + '\'' +
                ", lanIp='" + lanIp + '\'' +
                ", shelfSwitch='" + shelfSwitch + '\'' +
                ", dmiProductName='" + dmiProductName + '\'' +
                ", dmiPartNumber='" + dmiPartNumber + '\'' +
                ", dmiSerialNumber='" + dmiSerialNumber + '\'' +
                ", dmiOemString='" + dmiOemString + '\'' +
                ", dmiSystemConfig='" + dmiSystemConfig + '\'' +
                ", biosEc='" + biosEc + '\'' +
                ", status='" + status + '\'' +
                ", process=" + process +
                ", taskCreateTime=" + taskCreateTime +
                ", taskStartTime=" + taskStartTime +
                ", taskEndTime=" + taskEndTime +
                ", tester='" + tester + '\'' +
                ", taskToolSteps=" + taskToolSteps +
                '}';
    }
}