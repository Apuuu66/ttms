package com.ttms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {
    private Long id;

    private Integer seatId;

    private Integer schedId;

    private BigDecimal ticketPrice;

    private Short ticketStatus;

    private Date ticketLockedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getSchedId() {
        return schedId;
    }

    public void setSchedId(Integer schedId) {
        this.schedId = schedId;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Short getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Short ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Date getTicketLockedTime() {
        return ticketLockedTime;
    }

    public void setTicketLockedTime(Date ticketLockedTime) {
        this.ticketLockedTime = ticketLockedTime;
    }
}