package com.api.ecommerce.dao;

import com.api.ecommerce.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<InventoryEntity, UUID> {
}
