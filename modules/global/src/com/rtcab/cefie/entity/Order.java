package com.rtcab.cefie.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "CEFIE_ORDER")
@Entity(name = "cefie_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 2216482104666430494L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    protected Date orderDate;

    @Column(name = "ORDER_ID")
    protected String orderId;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @Column(name = "PAYMENT_METHOD")
    protected String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod == null ? null : PaymentMethod.fromId(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.getId();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}