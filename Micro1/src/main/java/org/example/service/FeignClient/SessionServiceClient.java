package org.example.service.FeignClient;



import org.example.entity.Session;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "session-service" )  // Remplacez l'URL par l'URL de votre service distant
public interface SessionServiceClient {

    // Créer ou mettre à jour une session
    @PostMapping("/create")
    Session createSession(@RequestBody Session session, @RequestParam Long professorId);

    // Récupérer une session par son ID
    @GetMapping("/{sessionId}")
    Session getSessionById(@PathVariable Long sessionId);

    // Récupérer toutes les sessions
    @GetMapping("/all")
    List<Session> getAllSessions();

    // Réserver une place pour un étudiant dans une session
    @PostMapping("/book")
    Boolean bookSpot(@RequestParam Long studentId, @RequestParam Long sessionId);

    // Mettre à jour une session
    @PutMapping("/{sessionId}")
    Session updateSession(@RequestBody Session updatedSession, @PathVariable Long sessionId);

    // Supprimer une session
    @DeleteMapping("/{sessionId}")
    void deleteSessionById(@PathVariable Long sessionId);

    // Récupérer les sessions par professeur
    @GetMapping("/by-professor")
    List<Session> getSessionsByProfessor(@RequestParam Long professorId);

    // Récupérer les sessions par étudiant
    @GetMapping("/by-student")
    List<Session> getSessionsByStudent(@RequestParam Long studentId);
}

