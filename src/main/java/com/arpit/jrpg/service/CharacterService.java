package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.characters.CharacterDTO;
import com.arpit.jrpg.model.dto.characters.CreateCharacterDTO;
import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.model.entity.Character;
import com.arpit.jrpg.model.entity.CharacterClass;
import com.arpit.jrpg.repository.CharacterClassRepository;
import com.arpit.jrpg.repository.CharacterRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CharacterService implements ICharacterService {
    CharacterRepository characterRepository;
    CharacterClassRepository characterClassRepository;

    public CharacterService(CharacterRepository characterRepository, CharacterClassRepository characterClassRepository) {
        this.characterRepository = characterRepository;
        this.characterClassRepository = characterClassRepository;
    }

    @Override
    public ApiResponseDTO<CharacterDTO> createCharacter(CreateCharacterDTO dto) {
        CharacterClass characterClass = characterClassRepository.findById(dto.getClassId()).orElseThrow(() -> new RuntimeException("Character Class doesn't exist"));
        Character character = getCharacter(dto, characterClass);

        CharacterDTO characterDTO = convertCharacterToDTO(characterRepository.save(character));

        return new ApiResponseDTO<>(
                HttpStatus.CREATED,
                "Character created successfully",
                characterDTO,
                LocalDateTime.now()
        );
    }

    @Override
    public ApiResponseDTO<List<CharacterDTO>> getCharacters() {
        List<Character> characters = characterRepository.findAll();

        List<CharacterDTO> characterDTOS = characters.stream().map(this::convertCharacterToDTO).toList();

        return new ApiResponseDTO<>(
                HttpStatus.OK,
                "All characters fetched successfully",
                characterDTOS,
                LocalDateTime.now()
        );
    }

    @Override
    public ApiResponseDTO<CharacterDTO> getCharacterById(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new RuntimeException("Character not found!!"));

        CharacterDTO characterDTO = convertCharacterToDTO(character);

        return new ApiResponseDTO<>(
                HttpStatus.OK,
                "Character fetched successfully",
                characterDTO,
                LocalDateTime.now()
        );
    }

    private static @NonNull Character getCharacter(CreateCharacterDTO dto, CharacterClass characterClass) {
        Character character = new Character();

        character.setName(dto.getName());

        character.setLevel(1);
        character.setExperience(0);
        character.setGold(0);

        character.setHp(characterClass.getBaseHp());
        character.setMp(characterClass.getBaseMp());

        character.setStrength(characterClass.getBaseStrength());
        character.setDefense(characterClass.getBaseDefense());
        character.setAgility(characterClass.getBaseAgility());
        character.setIntelligence(characterClass.getBaseIntelligence());

        character.setCharacterClass(characterClass);
        return character;
    }

    private CharacterDTO convertCharacterToDTO(Character character) {
        CharacterDTO dto = new CharacterDTO();

        dto.setCharacterId(character.getCharacter_id());
        dto.setName(character.getName());
        dto.setLevel(character.getLevel());
        dto.setExperience(character.getExperience());
        dto.setHp(character.getHp());
        dto.setMp(character.getMp());
        dto.setStrength(character.getStrength());
        dto.setDefense(character.getDefense());
        dto.setAgility(character.getAgility());
        dto.setIntelligence(character.getIntelligence());
        dto.setGold(character.getGold());

        return dto;
    }
}
