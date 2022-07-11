package com.reginageorge.ecommerceservice.repositories;

import com.reginageorge.ecommerceservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Rating, Long> {
}
