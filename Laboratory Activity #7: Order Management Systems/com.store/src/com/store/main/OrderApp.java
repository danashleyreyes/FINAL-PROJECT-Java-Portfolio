package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();

        OnlineOrder o1 = new OnlineOrder(111, 1500);
        OnlineOrder o2 = new OnlineOrder(112, 3600);
        OnlineOrder o3 = new OnlineOrder(113, 1075);

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        o1.processOrder();
        o1.pay();

        o2.processOrder();
        o2.pay();

        o3.processOrder();
        o3.cancelOrder();


        System.out.println("\n=======Order List=======");
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());

            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
                System.out.println("The canceled order has been removed.");
            }
        }
        
        System.out.println("\n=======Remaining Orders=======");
        for (Order order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }
}
