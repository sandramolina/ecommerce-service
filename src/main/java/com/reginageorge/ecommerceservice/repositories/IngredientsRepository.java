package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
