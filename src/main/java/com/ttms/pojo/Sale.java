package com.ttms.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Sale {
    private Long id;

    private Integer empId;

    private Date saleTime;

    private BigDecimal salePayment;

    private BigDecimal saleChange;

    private Short saleType;

    private Short saleStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public BigDecimal getSalePayment() {
        return salePayment;
    }

    public void setSalePayment(BigDecimal salePayment) {
        this.salePayment = salePayment;
    }

    public BigDecimal getSaleChange() {
        return saleChange;
    }

    public void setSaleChange(BigDecimal saleChange) {
        this.saleChange = saleChange;
    }

    public Short getSaleType() {
        return saleType;
    }

    public void setSaleType(Short saleType) {
        this.saleType = saleType;
    }

    public Short getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Short saleStatus) {
        this.saleStatus = saleStatus;
    }
}