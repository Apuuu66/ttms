package com.ttms.pojo;

import java.math.BigDecimal;

public class SaleItem {
    private Long id;

    private Long ticketId;

    private Long saleId;

    private BigDecimal saleItemPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getSaleItemPrice() {
        return saleItemPrice;
    }

    public void setSaleItemPrice(BigDecimal saleItemPrice) {
        this.saleItemPrice = saleItemPrice;
    }
}