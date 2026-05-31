package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.inventory.AddItemToInventoryDTO;
import com.arpit.jrpg.model.dto.inventory.InventoryDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.model.entity.Character;
import com.arpit.jrpg.model.entity.Inventory;
import com.arpit.jrpg.model.entity.Item;
import com.arpit.jrpg.repository.CharacterRepository;
import com.arpit.jrpg.repository.InventoryRepository;
import com.arpit.jrpg.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class InventoryService implements IInventoryService {
    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;

    public InventoryService(CharacterRepository characterRepository, ItemRepository itemRepository, InventoryRepository inventoryRepository) {
        this.characterRepository = characterRepository;
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ApiResponseDTO<InventoryDTO> addItemToInventory(AddItemToInventoryDTO dto, Long character_id) {
        Character character = characterRepository.findById(character_id).orElseThrow(() -> new RuntimeException("Character Class doesn't exist"));
        Item item = itemRepository.findById(dto.getItemId()).orElseThrow(() -> new RuntimeException("Item not found!!"));

        Inventory inventory = new Inventory();
        inventory.setCharacter(character);
        inventory.setItem(item);
        inventory.setQuantity(dto.getQuantity());

        InventoryDTO inventoryDTO = convertInventoryToDTO(inventoryRepository.save(inventory));

        return new ApiResponseDTO<>(
                HttpStatus.CREATED,
                "Item added to inventory",
                inventoryDTO,
                LocalDateTime.now()
        );
    }

    @Override
    public ApiResponseDTO<List<InventoryDTO>> getInventory(Long character_id) {
        Character character = characterRepository.findById(character_id).orElseThrow(() -> new RuntimeException("Character not found"));
        List<Inventory> inventories = inventoryRepository.findByCharacter(character);

        List<InventoryDTO> response = inventories.stream().map(this::convertInventoryToDTO).toList();

        return new ApiResponseDTO<>(
                HttpStatus.OK,
                "Inventory of character fetched",
                response,
                LocalDateTime.now()
        );
    }

    private InventoryDTO convertInventoryToDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();

        dto.setInventory_id(inventory.getInventory_id());
//        dto.setCharacter(inventory.getCharacter());
        dto.setItem(inventory.getItem());
        dto.setQuantity(inventory.getQuantity());

        return dto;
    }
}
