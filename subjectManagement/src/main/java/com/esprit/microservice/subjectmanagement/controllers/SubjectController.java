package com.esprit.microservice.subjectmanagement.controllers;

import com.esprit.microservice.subjectmanagement.entities.Subject;
import com.esprit.microservice.subjectmanagement.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;

    @GetMapping("/hello")
    public String hello() {
        return "hello from subject management";
    }

    @PostMapping("/add")
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable long id) {
        return subjectService.getSubjectById(id);
    }

    @PutMapping("/update/{id}")
    public Subject updateSubject(@PathVariable long id, @RequestBody Subject subject) {
        return subjectService.modifySubject(id,subject);
    }

    @PutMapping("/available/{id}")
    public Subject updateAvailability(@PathVariable long id) {
        return subjectService.updateAvailability(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubject(@PathVariable long id) {
        subjectService.deleteSubject(id);
    }
}
