package com.rtcab.cefie.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PaymentMethod implements EnumClass<String> {

    DIRECT_DEBIT("DIRECT_DEBIT"),
    CREDIT_CARD("CREDIT_CARD"),
    PAYPAL("PAYPAL");

    private String id;

    PaymentMethod(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PaymentMethod fromId(String id) {
        for (PaymentMethod at : PaymentMethod.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}