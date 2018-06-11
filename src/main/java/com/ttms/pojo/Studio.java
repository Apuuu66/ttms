package com.ttms.pojo;

public class Studio {
    private Integer id;

    private String studioName;

    private Integer studioRowCount;

    private Integer studioColCount;

    private String studioIntroduction;

    private Short studioFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    public Integer getStudioRowCount() {
        return studioRowCount;
    }

    public void setStudioRowCount(Integer studioRowCount) {
        this.studioRowCount = studioRowCount;
    }

    public Integer getStudioColCount() {
        return studioColCount;
    }

    public void setStudioColCount(Integer studioColCount) {
        this.studioColCount = studioColCount;
    }

    public String getStudioIntroduction() {
        return studioIntroduction;
    }

    public void setStudioIntroduction(String studioIntroduction) {
        this.studioIntroduction = studioIntroduction == null ? null : studioIntroduction.trim();
    }

    public Short getStudioFlag() {
        return studioFlag;
    }

    public void setStudioFlag(Short studioFlag) {
        this.studioFlag = studioFlag;
    }
}