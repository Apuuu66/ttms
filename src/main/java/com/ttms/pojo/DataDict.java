package com.ttms.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DataDict {
    private Integer id;

    private Integer dictParentId;

    private Integer dictIndex;

    private String dictName;

    private String dictValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictParentId() {
        return dictParentId;
    }

    public void setDictParentId(Integer dictParentId) {
        this.dictParentId = dictParentId;
    }

    public Integer getDictIndex() {
        return dictIndex;
    }

    public void setDictIndex(Integer dictIndex) {
        this.dictIndex = dictIndex;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}