package com.ruoyi.system.domain;

public class DistrictEntity {
    //id
    private Integer districtId;
    //父id
    private Integer districtPid;
    //省/市/区名字
    private String districtName;
    //省/市/区简称
    private String districtShortname;
    //省/市/区 经纬度  X
    private String districtLngX;
    //省/市/区 经纬度 Y
    private String districtLngY;
    //行政区等级
    private Integer districtLevel;
    //行政区排序
    private Integer districtSort;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictPid() {
        return districtPid;
    }

    public void setDistrictPid(Integer districtPid) {
        this.districtPid = districtPid;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictShortname() {
        return districtShortname;
    }

    public void setDistrictShortname(String districtShortname) {
        this.districtShortname = districtShortname;
    }

    public String getDistrictLngX() {
        return districtLngX;
    }

    public void setDistrictLngX(String districtLngX) {
        this.districtLngX = districtLngX;
    }

    public String getDistrictLngY() {
        return districtLngY;
    }

    public void setDistrictLngY(String districtLngY) {
        this.districtLngY = districtLngY;
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public Integer getDistrictSort() {
        return districtSort;
    }

    public void setDistrictSort(Integer districtSort) {
        this.districtSort = districtSort;
    }

    public Integer getDistrictStatus() {
        return districtStatus;
    }

    public void setDistrictStatus(Integer districtStatus) {
        this.districtStatus = districtStatus;
    }

    //行政区是否有效(0:无效,1:有效)
    private Integer districtStatus;

}
