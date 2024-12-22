package org.example.service;

import org.example.entity.Assignment;
import org.example.entity.Session;
import org.example.repository.AssignmentRepository;
import org.example.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public Assignment createAssignment(Long sessionId, Assignment assignment) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));
        if (assignment.getTitle() == null || assignment.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Assignment title is required.");
        }
        if (assignment.getDeadline() == null || assignment.getDeadline().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Deadline cannot be in the past.");
        }
        assignment.setSession(session);
        assignment.setCreatedAt(LocalDate.now());
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(Long assignmentId, Assignment updatedAssignment) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found"));

        if (updatedAssignment.getTitle() != null) {
            assignment.setTitle(updatedAssignment.getTitle());
        }
        if (updatedAssignment.getDescription() != null) {
            assignment.setDescription(updatedAssignment.getDescription());
        }
        if (updatedAssignment.getDeadline() != null) {
            assignment.setDeadline(updatedAssignment.getDeadline());
        }
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public Assignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null); // Return null if not found
    }

    public List<Assignment> getAssignmentsBySession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session not found"));
        return session.getAssignments();
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }





}
