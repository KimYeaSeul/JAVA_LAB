package com.sparta.week02.repository;

import com.sparta.week02.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByUserId(int id);
}
