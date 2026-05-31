package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.inventory.AddItemToInventoryDTO;
import com.arpit.jrpg.model.dto.inventory.InventoryDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;

public interface IInventoryService {
    ApiResponseDTO<InventoryDTO> addItemToInventory(AddItemToInventoryDTO dto, Long character_id);
}
