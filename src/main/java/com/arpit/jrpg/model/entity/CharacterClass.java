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

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(Integer baseHp) {
        this.baseHp = baseHp;
    }

    public Integer getBaseMp() {
        return baseMp;
    }

    public void setBaseMp(Integer baseMp) {
        this.baseMp = baseMp;
    }

    public Integer getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(Integer baseStrength) {
        this.baseStrength = baseStrength;
    }

    public Integer getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(Integer baseDefense) {
        this.baseDefense = baseDefense;
    }

    public Integer getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(Integer baseAgility) {
        this.baseAgility = baseAgility;
    }

    public Integer getBaseIntelligence() {
        return baseIntelligence;
    }

    public void setBaseIntelligence(Integer baseIntelligence) {
        this.baseIntelligence = baseIntelligence;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
