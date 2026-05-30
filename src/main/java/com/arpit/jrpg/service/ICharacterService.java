package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.characters.CharacterDTO;
import com.arpit.jrpg.model.dto.characters.CreateCharacterDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;

import java.util.List;

public interface ICharacterService {
    ApiResponseDTO<CharacterDTO> createCharacter(CreateCharacterDTO dto);
    ApiResponseDTO<List<CharacterDTO>> getCharacters();
    ApiResponseDTO<CharacterDTO> getCharacterById(Long id);
}
