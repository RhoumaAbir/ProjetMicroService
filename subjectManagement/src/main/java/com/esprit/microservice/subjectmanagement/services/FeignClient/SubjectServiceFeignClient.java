package com.esprit.microservice.subjectmanagement.services.FeignClient;


import com.esprit.microservice.subjectmanagement.entities.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "subject-service")  // Nom du microservice à appeler
public interface SubjectServiceFeignClient {

    @PostMapping("/subjects")
    Subject createSubject(@RequestBody Subject subject);

    @PutMapping("/subjects/{id}")
    Subject modifySubject(@PathVariable Long id, @RequestBody Subject newSubject);

    @DeleteMapping("/subjects/{id}")
    void deleteSubject(@PathVariable Long id);

    @GetMapping("/subjects/{id}")
    Subject getSubjectById(@PathVariable Long id);

    @GetMapping("/subjects")
    List<Subject> getAllSubjects();

    @PutMapping("/subjects/{id}/availability")
    Subject updateAvailability(@PathVariable Long id);
}