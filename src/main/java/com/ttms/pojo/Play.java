package com.ttms.pojo;

import java.math.BigDecimal;

public class Play {
    private Integer id;

    //    private Integer playTypeId;
//
//    private Integer playLangId;
    private DataDict type;
    private DataDict lang;
    private String playName;

    private String playIntroduction;

    private String playImage;

    private Integer playLength;

    private BigDecimal playTicketPrice;

    private Short playStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DataDict getType() {
        return type;
    }

    public void setType(DataDict type) {
        this.type = type;
    }

    public DataDict getLang() {
        return lang;
    }

    public void setLang(DataDict lang) {
        this.lang = lang;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName == null ? null : playName.trim();
    }

    public String getPlayIntroduction() {
        return playIntroduction;
    }

    public void setPlayIntroduction(String playIntroduction) {
        this.playIntroduction = playIntroduction == null ? null : playIntroduction.trim();
    }

    public String getPlayImage() {
        return playImage;
    }

    public void setPlayImage(String playImage) {
        this.playImage = playImage == null ? null : playImage.trim();
    }

    public Integer getPlayLength() {
        return playLength;
    }

    public void setPlayLength(Integer playLength) {
        this.playLength = playLength;
    }

    public BigDecimal getPlayTicketPrice() {
        return playTicketPrice;
    }

    public void setPlayTicketPrice(BigDecimal playTicketPrice) {
        this.playTicketPrice = playTicketPrice;
    }

    public Short getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(Short playStatus) {
        this.playStatus = playStatus;
    }
}