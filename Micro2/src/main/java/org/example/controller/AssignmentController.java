package org.example.controller;

import org.example.entity.Assignment;
import org.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/sessions/{sessionId}")
    @ResponseBody
    public ResponseEntity<Assignment> createAssignment(
            @PathVariable Long sessionId,
            @RequestBody Assignment assignment) {
        System.out.println("Received Assignment: " + assignment);
        Assignment createdAssignment = assignmentService.createAssignment(sessionId, assignment);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }

    @PutMapping("/{assignmentId}")
    public ResponseEntity<Assignment> updateAssignment(
            @PathVariable Long assignmentId,
            @RequestBody Assignment updatedAssignment) {
        Assignment updated = assignmentService.updateAssignment(assignmentId, updatedAssignment);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getbyid/{assignmentId}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long assignmentId) {
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);

        if (assignment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 without a body
        }

        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<List<Assignment>> getAssignmentsBySession(@PathVariable Long sessionId) {
        List<Assignment> assignments = assignmentService.getAssignmentsBySession(sessionId);
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }
}
