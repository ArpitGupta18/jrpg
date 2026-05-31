package com.arpit.jrpg.repository;

import com.arpit.jrpg.model.entity.Character;
import com.arpit.jrpg.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByCharacter(Character character);
}
