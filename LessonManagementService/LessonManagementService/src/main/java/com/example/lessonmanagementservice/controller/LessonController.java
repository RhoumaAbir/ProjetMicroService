package com.example.lessonmanagementservice.controller;


import com.example.lessonmanagementservice.entity.Lesson;
import com.example.lessonmanagementservice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lessons")
@CrossOrigin(origins = "http://localhost:4200")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Create a new Lesson
    @PostMapping("/create/{id}")
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson, @PathVariable Long id) {
        Lesson createdLesson = lessonService.createLesson(lesson, id);
        return ResponseEntity.ok(createdLesson);
    }

    // Retrieve all Lessons
    @GetMapping("/getAllLessons")
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonService.retrieveAllLessons();
        return ResponseEntity.ok(lessons);
    }

    // Retrieve a Lesson by ID
    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lesson);
    }

    // Update a Lesson by ID
    @PutMapping("/update/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson updatedLesson, @PathVariable Long lessonId) {
        Lesson lesson = lessonService.updateLesson(updatedLesson, lessonId);
        return ResponseEntity.ok(lesson);
    }

    // Delete a Lesson by ID
    @DeleteMapping("/delete/{lessonId}")
    public ResponseEntity<Void> deleteLessonById(@PathVariable Long lessonId) {
        lessonService.deleteLessonById(lessonId);
        return ResponseEntity.noContent().build();
    }
}
