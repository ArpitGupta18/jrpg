package com.arpit.jrpg.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monster_id;
    private String name;
    private Integer level;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer agility;
    private Integer expReward;
    private Integer goldReward;
}