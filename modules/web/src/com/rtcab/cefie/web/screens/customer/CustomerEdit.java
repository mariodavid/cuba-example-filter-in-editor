package com.rtcab.cefie.web.screens.customer;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cefie.entity.Customer;
import com.rtcab.cefie.entity.Order;

import javax.inject.Inject;

@UiController("cefie_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    protected CollectionLoader<Order> ordersDl;

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) {
        ordersDl.setParameter("customer", getEditedEntity());
        getScreenData().loadAll();
    }
    
    
}