package com.esprit.microservice.subjectmanagement.services.FeignClient;


import com.esprit.microservice.subjectmanagement.entities.Level;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "level-service")  // URL du service, à ajuster
public interface LevelServiceFeignClient {

    @PostMapping("/create")
    Level createLevel(@RequestBody Level level, @RequestParam Long subjectId);

    @PutMapping("/modify/{id}")
    Level modifyLevel(@PathVariable Long id, @RequestBody Level newLevel);

    @DeleteMapping("/delete/{id}")
    void deleteLevel(@PathVariable Long id);

    @GetMapping("/get/{id}")
    Level getLevelById(@PathVariable Long id);

    @GetMapping("/getAll/{subjectId}")
    List<Level> getAllLevels(@PathVariable Long subjectId);
}