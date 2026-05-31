package com.arpit.jrpg.service;

import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.model.dto.skill.SkillDTO;

public interface ISkillService {
    ApiResponseDTO<String> learnSkill(Long characterId, Long skillId);
}
