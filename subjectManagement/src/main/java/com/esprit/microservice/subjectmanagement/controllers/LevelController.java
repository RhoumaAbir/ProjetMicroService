package com.esprit.microservice.subjectmanagement.controllers;
import com.esprit.microservice.subjectmanagement.entities.Level;
import com.esprit.microservice.subjectmanagement.services.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    ILevelService levelService;

    @PostMapping("/add/{id}")
    public Level addLevel(@RequestBody Level level,@PathVariable long id) {
        return levelService.createLevel(level,id);
    }

    @GetMapping("/all/{id}")
    public List<Level> getAllLevels(@PathVariable long id) {
        return levelService.getAllLevels(id);
    }

    @GetMapping("/{id}")
    public Level getLevelById(@PathVariable long id) {
        return levelService.getLevelById(id);
    }

    @PutMapping("/update/{id}")
    public Level updateLevel(@PathVariable long id, @RequestBody Level level) {
        return levelService.modifyLevel(id,level);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLevel(@PathVariable long id) {
        levelService.deleteLevel(id);
    }
}
