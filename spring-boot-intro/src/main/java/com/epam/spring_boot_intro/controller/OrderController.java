package com.epam.spring_boot_intro.controller;

import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;
import com.epam.spring_boot_intro.service.CustomerService;
import com.epam.spring_boot_intro.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Long addNewOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/get")
    public Order getOrder(@RequestParam("orderId") Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/bindCustomer")
    public Long bindOrderToCustomer(@RequestParam("orderId") Long orderId, @RequestParam("customerId") Long customerId) {
        Customer orderingCustomer = customerService.getCustomerById(customerId);
        return orderService.updateOrder(orderId, orderingCustomer);
    }

    @DeleteMapping("/delete")
    public boolean deleteOrder(@RequestParam("orderId") Long id) {
        return orderService.deleteOrderById(id);
    }
}
