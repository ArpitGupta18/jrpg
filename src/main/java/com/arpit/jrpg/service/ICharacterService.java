package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.characters.CharacterDTO;
import com.arpit.jrpg.model.dto.characters.CreateCharacterDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;

public interface ICharacterService {
    ApiResponseDTO<CharacterDTO> createCharacter(CreateCharacterDTO dto);
}
