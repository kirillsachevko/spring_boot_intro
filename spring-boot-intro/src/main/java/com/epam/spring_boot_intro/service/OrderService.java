package com.epam.spring_boot_intro.service;

import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;

public interface OrderService {
    Long createOrder(Order order);

    Long updateOrder(Long orderId, Customer customer);

    Order getOrderById(Long id);

    boolean deleteOrderById(Long id);
}
