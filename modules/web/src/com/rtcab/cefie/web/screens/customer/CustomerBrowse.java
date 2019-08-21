package com.rtcab.cefie.web.screens.customer;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cefie.entity.Customer;
import com.rtcab.cefie.entity.Order;
import com.rtcab.cefie.entity.PaymentMethod;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@UiController("cefie_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {

    @Inject
    protected DataManager dataManager;
    @Inject
    protected TimeSource timeSource;

    @Subscribe("customersTable.generate")
    protected void onCustomersTableGenerate(Action.ActionPerformedEvent event) {


        Customer customer = dataManager.create(Customer.class);
        customer.setName("Customer " + randomNumber(999999));
        List<Order> orders = generateOrders(customer);
        customer.setOrders(orders);

        commit(customer, orders);

        getScreenData().loadAll();

    }

    private void commit(Customer customer, List<Order> orders) {
        CommitContext commitContext = new CommitContext();

        commitContext.addInstanceToCommit(customer);
        orders.forEach(commitContext::addInstanceToCommit);
        dataManager.commit(commitContext);
    }

    private List<Order> generateOrders(Customer customer) {

        int bound = 1000;
        int howManyOrders = randomNumber(bound);

        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < howManyOrders; i++) {
            orders.add(generateOrder(customer, i));
        }

        return orders;
    }

    private int randomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    private Order generateOrder(Customer customer, int orderId) {
        Order order = dataManager.create(Order.class);

        order.setCustomer(customer);
        order.setAmount(new BigDecimal(randomNumber(5000)));
        order.setOrderDate(randomOrderDate());
        order.setPaymentMethod(randomPaymentMethod());

        return order;
    }

    private PaymentMethod randomPaymentMethod() {
        return PaymentMethod.values()[new Random().nextInt(PaymentMethod.values().length)];
    }

    private Date randomOrderDate() {
        LocalDate orderDate = timeSource.now().toLocalDate().minusDays((long) randomNumber(1000));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(orderDate.atStartOfDay(defaultZoneId).toInstant());
    }


}