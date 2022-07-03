package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
