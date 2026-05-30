package com.arpit.jrpg.repository;

import com.arpit.jrpg.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
