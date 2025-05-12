package com.epam.spring_boot_intro.service;

import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;

public interface CustomerService {
    Long createCustomer(Customer customer);

    Long updateCustomer(Long id, Order order);

    Customer getCustomerById(Long id);

    boolean deleteCustomerById(Long id);
}
