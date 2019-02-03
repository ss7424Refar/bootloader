package com.ats.bootloader.domain;

public class TestPCSession extends TestPCSessionKey {
    private String machineName;

    private String lanIp;

    private String shelfSwitch;

    private String dmiProductName;

    private String dmiPartNumber;

    private String dmiSerialNumber;

    private String dmiOemString;

    private String dmiSystemConfig;

    private String biosEc;

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
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
}