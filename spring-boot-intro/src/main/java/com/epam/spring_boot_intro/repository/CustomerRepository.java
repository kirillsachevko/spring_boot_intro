package com.epam.spring_boot_intro.repository;

import com.epam.spring_boot_intro.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
