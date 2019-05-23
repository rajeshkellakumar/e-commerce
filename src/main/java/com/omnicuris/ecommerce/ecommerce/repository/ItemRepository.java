package com.omnicuris.ecommerce.ecommerce.repository;

import com.omnicuris.ecommerce.ecommerce.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
