package com.esprit.microservice.subjectmanagement.services;

import com.esprit.microservice.subjectmanagement.dao.LevelRepository;
import com.esprit.microservice.subjectmanagement.dao.SubjectRepository;
import com.esprit.microservice.subjectmanagement.entities.Level;
import com.esprit.microservice.subjectmanagement.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LevelService implements ILevelService {

    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Level createLevel(Level level, Long id) {
        // Retrieve the subject by ID
        Subject subject = subjectRepository.findById(id).orElse(null);
        if (subject != null) {
            // Save the new level first, if it's not already saved
            levelRepository.save(level);

            // Ensure the subjects list is initialized before using it
            if (subject.getLevels() == null) {
                subject.setLevels(new ArrayList<>());
                System.out.println("t3adat");
            }

            // Add the level to the subject's list of levels (if not already present)
            if (!subject.getLevels().contains(level)) {
                subject.getLevels().add(level);
                System.out.println("t3adat2");
            }

            // Add the subject to the level's list of subjects (if not already present)
            if (level.getSubjects() == null) {
                level.setSubjects(new ArrayList<>());
                System.out.println("t3adat3");
            }
            if (!level.getSubjects().contains(subject)) {
                level.getSubjects().add(subject);
                System.out.println("t3adat4");
            }

            // Save both entities to ensure the relationship is persisted
            subjectRepository.save(subject);
            levelRepository.save(level);
            System.out.println("t3adat5");
            return level;
        }
        System.out.println("mat3adatech");
        return null;
    }



    @Override
    public Level modifyLevel(Long id, Level newLevel) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Level not found with id " + id));
        level.setName(newLevel.getName());
        level.setDescription(newLevel.getDescription());
        level.setAcademicYear(newLevel.getAcademicYear());
        level.setYear(newLevel.getYear());
        return levelRepository.save(level);
    }

    @Override
    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).get();
    }

    @Override
    public List<Level> getAllLevels(Long id) {
        return levelRepository.findBySubjectId(id);
    }
}
