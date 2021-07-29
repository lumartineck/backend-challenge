package com.parrot.backendchallenge.dao;

import org.springframework.data.repository.CrudRepository;

import com.parrot.backendchallenge.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
