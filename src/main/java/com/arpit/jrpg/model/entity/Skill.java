package com.arpit.jrpg.model.entity;

import com.arpit.jrpg.model.enums.SkillType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skill_id;
    private String name;
    private String description;
    private Integer manaCost;
    private Integer power;

    @Enumerated(EnumType.STRING)
    private SkillType skillType;

    @ManyToMany(mappedBy = "skills")
    @JsonIgnore
    private List<Character> characters;
}