package com.parrot.backendchallenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parrot.backendchallenge.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
