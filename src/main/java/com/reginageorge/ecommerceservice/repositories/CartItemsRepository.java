package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
}
