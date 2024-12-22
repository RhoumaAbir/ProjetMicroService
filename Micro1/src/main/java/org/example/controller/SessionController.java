package org.example.controller;


import jakarta.persistence.EntityNotFoundException;
import org.example.entity.Session;
import org.example.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/addSession/{professorId}")
    public Session createSession(@RequestBody Session session,
                                 @PathVariable("professorId") Long professorId) {
        return sessionService.createSession(session, professorId);
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        try {
            Session session = sessionService.getSessionById(id);
            return ResponseEntity.ok(session);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bookSpot/{sessionId}/{studentId}")
    public ResponseEntity<String> bookSpot(@PathVariable Long studentId, @PathVariable Long sessionId) {
        boolean booked = sessionService.bookSpot(studentId, sessionId);
        if (booked) {
            return ResponseEntity.ok("Spot booked successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No spots available");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable Long id, @RequestBody Session session) {
        try {
            Session updatedSession = sessionService.updateSession(session, id);
            return ResponseEntity.ok(updatedSession);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        try {
            sessionService.deleteSessionById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byProfessor/{professorId}")
    public ResponseEntity<List<Session>> getSessionsByProfessor(@PathVariable Long professorId) {
        try {
            List<Session> sessions = sessionService.getSessionsByProfessor(professorId);
            return ResponseEntity.ok(sessions);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byStudent/{studentId}")
    public ResponseEntity<List<Session>> getSessionsByStudent(@PathVariable Long studentId) {
        List<Session> sessions = sessionService.getSessionsByStudent(studentId);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/retrieveAll")
    public ResponseEntity<List<Session>> retrieveAllSessions() {
        return ResponseEntity.ok(sessionService.retrieveAllSessions());
    }
}
