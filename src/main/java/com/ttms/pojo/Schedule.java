package com.ttms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Schedule {
    private Integer id;

    private Integer studioId;

    private Integer playId;

    private Date schedTime;

    private BigDecimal schedTicketPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public Date getSchedTime() {
        return schedTime;
    }

    public void setSchedTime(Date schedTime) {
        this.schedTime = schedTime;
    }

    public BigDecimal getSchedTicketPrice() {
        return schedTicketPrice;
    }

    public void setSchedTicketPrice(BigDecimal schedTicketPrice) {
        this.schedTicketPrice = schedTicketPrice;
    }
}