package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.model.dto.skill.SkillDTO;
import com.arpit.jrpg.model.entity.Character;
import com.arpit.jrpg.model.entity.Skill;
import com.arpit.jrpg.repository.CharacterRepository;
import com.arpit.jrpg.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SkillService implements ISkillService{
    CharacterRepository characterRepository;
    SkillRepository skillRepository;

    public SkillService(CharacterRepository characterRepository, SkillRepository skillRepository) {
        this.characterRepository = characterRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public ApiResponseDTO<String> learnSkill(Long characterId, Long skillId) {
        Character character = characterRepository.findById(characterId).orElseThrow(() -> new RuntimeException("Character not found"));

        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));

        if (character.getSkills().contains(skill)) {
            return new ApiResponseDTO<>(
                    HttpStatus.BAD_REQUEST,
                    "Character already knows this skill",
                    null,
                    LocalDateTime.now()
            );
        }

        character.getSkills().add(skill);

        characterRepository.save(character);

        return new ApiResponseDTO<>(
                HttpStatus.OK,
                "Skill learned successfully",
                null,
                LocalDateTime.now()
        );
    }
}
