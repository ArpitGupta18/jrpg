package com.arpit.jrpg.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "character_class")
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long class_id;

    private String name;
    private Integer baseHp;
    private Integer baseMp;
    private Integer baseStrength;
    private Integer baseDefense;
    private Integer baseAgility;
    private Integer baseIntelligence;

    @OneToMany(mappedBy = "characterClass")
    private List<Character> characters;
}
