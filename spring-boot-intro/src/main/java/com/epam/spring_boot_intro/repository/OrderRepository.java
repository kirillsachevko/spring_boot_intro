package com.epam.spring_boot_intro.repository;

import com.epam.spring_boot_intro.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
