package com.epam.spring_boot_intro.controller;

import com.epam.spring_boot_intro.model.Customer;
import com.epam.spring_boot_intro.model.Order;
import com.epam.spring_boot_intro.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Long addNewCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam("customerId") Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/{id}/order")
    public Long setOrderToCustomer(@PathVariable("id") Long id, @RequestBody Order order) {
        return customerService.updateCustomer(id, order);
    }

    @DeleteMapping("/delete")
    public boolean deleteCustomer(@RequestParam("customerId") Long id) {
        return customerService.deleteCustomerById(id);
    }
}
