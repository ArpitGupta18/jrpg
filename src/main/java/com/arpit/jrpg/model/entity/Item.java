package com.arpit.jrpg.model.entity;

import com.arpit.jrpg.model.enums.ItemType;
import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String name;
    private String description;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private Integer attackBonus;
    private Integer defenseBonus;
    private Integer healAmount;
}
