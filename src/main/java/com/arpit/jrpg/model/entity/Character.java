package com.arpit.jrpg.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long character_id;

    private String name;
    private Integer level = 1;
    private Integer experience = 0;
    private Integer hp;
    private Integer mp;
    private Integer strength;
    private Integer defense;
    private Integer agility;
    private Integer intelligence;
    private Integer gold = 0;

    @ManyToOne
    @JoinColumn(name="class_id")
    private CharacterClass characterClass;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    private List<Inventory> inventory;

    @ManyToMany
    @JoinTable(
            name = "character_skill",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
}
