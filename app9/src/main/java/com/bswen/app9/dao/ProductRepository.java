package com.bswen.app9.dao;

import com.bswen.app9.customsecurity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
