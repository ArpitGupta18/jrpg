package com.arpit.jrpg.controller;

import com.arpit.jrpg.model.dto.inventory.AddItemToInventoryDTO;
import com.arpit.jrpg.model.dto.inventory.InventoryDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.service.IInventoryService;
import com.arpit.jrpg.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class InventoryController {
    private final IInventoryService inventoryService;

    protected InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/{id}/inventory")
    public ApiResponseDTO<InventoryDTO> addItemToInventory(@RequestBody AddItemToInventoryDTO dto, @PathVariable Long id) {
        return inventoryService.addItemToInventory(dto, id);
    }

    @GetMapping("/{id}/inventory")
    public ApiResponseDTO<List<InventoryDTO>> getInventory(@PathVariable Long id) {
        return inventoryService.getInventory(id);
    }
}
