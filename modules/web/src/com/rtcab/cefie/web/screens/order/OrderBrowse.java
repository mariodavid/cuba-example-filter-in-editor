package com.rtcab.cefie.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cefie.entity.Order;

@UiController("cefie_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}