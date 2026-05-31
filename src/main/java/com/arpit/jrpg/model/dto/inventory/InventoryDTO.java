package com.arpit.jrpg.model.dto.inventory;

import com.arpit.jrpg.model.entity.Character;
import com.arpit.jrpg.model.entity.Item;

public class InventoryDTO {
    private Long inventory_id;
    private Character character;
    private Item item;
    private Integer quantity;

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
