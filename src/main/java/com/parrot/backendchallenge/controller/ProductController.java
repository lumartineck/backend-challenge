package com.parrot.backendchallenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parrot.backendchallenge.dao.ProductRepository;
import com.parrot.backendchallenge.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> findAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable(value = "id") long id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			return ResponseEntity.ok().body(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Product saveProduct(@Validated @RequestBody Product product) {
		return productRepository.save(product);
	}
}
