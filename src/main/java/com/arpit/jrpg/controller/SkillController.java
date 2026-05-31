package com.arpit.jrpg.controller;

import com.arpit.jrpg.model.dto.response.ApiResponseDTO;
import com.arpit.jrpg.service.SkillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class SkillController {
    SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/{id}/skills/{skillId}")
    public ApiResponseDTO<String> learnSkill(@PathVariable Long id, @PathVariable Long skillId) {
        return skillService.learnSkill(id, skillId);
    }
}
