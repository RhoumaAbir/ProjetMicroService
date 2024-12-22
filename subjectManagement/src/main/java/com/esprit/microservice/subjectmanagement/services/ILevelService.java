package com.esprit.microservice.subjectmanagement.services;

import com.esprit.microservice.subjectmanagement.entities.Level;

import java.util.List;

public interface ILevelService {
    Level createLevel(Level level,Long id);
    Level modifyLevel(Long id, Level newLevel);
    void deleteLevel(Long id);
    Level getLevelById(Long id);
    List<Level> getAllLevels(Long id);
}
