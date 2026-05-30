package com.arpit.jrpg.model.dto.characters;

import com.arpit.jrpg.model.entity.CharacterClass;

public class CharacterDTO {
    private Long characterId;
    private String name;
    private Integer level;
    private Integer experience;
    private Integer hp;
    private Integer mp;
    private Integer strength;
    private Integer defense;
    private Integer agility;
    private Integer intelligence;
    private Integer gold;

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}
