package com.arpit.jrpg.model.dto.characters;

public class CreateCharacterDTO {
    private String name;
    private Long classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
