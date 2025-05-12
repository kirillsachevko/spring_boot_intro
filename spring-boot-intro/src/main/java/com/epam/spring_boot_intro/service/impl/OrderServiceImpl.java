package com.epam.spring_boot_intro.service.impl;

import com.epam.spring_boot_intro.exception.CustomerException;
import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;
import com.epam.spring_boot_intro.repository.OrderRepository;
import com.epam.spring_boot_intro.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long createOrder(Order order) {
        return orderRepository.save(order).getId();
    }

    @Override
    public Long updateOrder(Long orderId, Customer customer) {
        return orderRepository.findById(orderId)
                .map(existOrder -> {
                    existOrder.setCustomer(customer);
                    return orderId;
                }).orElseThrow(() -> new CustomerException(String.format("Order with id:%s doesn't exist", orderId)));
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomerException(String.format("Order with id:%s doesn't exist", id)));
    }

    @Override
    public boolean deleteOrderById(Long id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (RuntimeException ex) {
            throw new CustomerException(String.format("Order with id:%s doesn't exist", id));
        }
    }
}
