package org.example.service.FeignClient;

import org.example.entity.Assignment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "assignment-service")  // Nom du service tel qu'il est enregistré dans Eureka ou défini dans votre configuration
public interface AssignmentServiceFeignClient {

    @PostMapping("/assignments/{sessionId}")
    Assignment createAssignment(@PathVariable("sessionId") Long sessionId, @RequestBody Assignment assignment);

    @PutMapping("/assignments/{assignmentId}")
    Assignment updateAssignment(@PathVariable("assignmentId") Long assignmentId, @RequestBody Assignment updatedAssignment);

    @DeleteMapping("/assignments/{assignmentId}")
    void deleteAssignment(@PathVariable("assignmentId") Long assignmentId);

    @GetMapping("/assignments/{assignmentId}")
    Assignment getAssignmentById(@PathVariable("assignmentId") Long assignmentId);

    @GetMapping("/assignments/session/{sessionId}")
    List<Assignment> getAssignmentsBySession(@PathVariable("sessionId") Long sessionId);

    @GetMapping("/assignments")
    List<Assignment> getAllAssignments();
}
