package com.omnicuris.ecommerce.ecommerce.repository;

import com.omnicuris.ecommerce.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
