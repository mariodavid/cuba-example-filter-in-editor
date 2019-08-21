package com.rtcab.cefie.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cefie.entity.Order;

@UiController("cefie_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}