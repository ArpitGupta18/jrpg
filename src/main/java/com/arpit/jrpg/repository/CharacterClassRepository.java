package com.arpit.jrpg.repository;

import com.arpit.jrpg.model.entity.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {
}
