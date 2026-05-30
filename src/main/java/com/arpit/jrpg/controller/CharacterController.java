package com.arpit.jrpg.controller;

import com.arpit.jrpg.model.dto.characters.CharacterDTO;
import com.arpit.jrpg.model.dto.characters.CreateCharacterDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.service.CharacterService;
import com.arpit.jrpg.service.ICharacterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final ICharacterService characterService;

    protected CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ApiResponseDTO<CharacterDTO> createCharacter(@RequestBody CreateCharacterDTO dto) {
        return characterService.createCharacter(dto);
    }
}
