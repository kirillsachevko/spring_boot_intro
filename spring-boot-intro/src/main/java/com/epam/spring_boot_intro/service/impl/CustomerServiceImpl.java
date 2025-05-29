package com.epam.spring_boot_intro.service.impl;

import com.epam.spring_boot_intro.exception.CustomerException;
import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;
import com.epam.spring_boot_intro.repository.CustomerRepository;
import com.epam.spring_boot_intro.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Long createCustomer(Customer customer) {
        return customerRepository.save(customer).getId();
    }

    @Override
    public Long updateCustomer(Long id, Order order) {
        customerRepository.findById(id)
                .map(customer -> {
                    List<Order> currentCustomerOrders = customer.getCustomerOrderList();
                    currentCustomerOrders.add(order);
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new CustomerException(String.format("Customer with id:%s doesn't exist", id)));
        return id;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException(String.format("Customer with id:%s doesn't exist", id)));
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (RuntimeException ex) {
            throw new CustomerException(String.format("Customer with id:%s doesn't exist", id));
        }
    }
}
