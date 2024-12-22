package org.example.service;


import org.example.entity.Session;

import java.util.List;

public interface ISessionService {
    Session createSession(Session session, Long professorId);
    List<Session> retrieveAllSessions();
    Session getSessionById(Long sessionId);
    List<Session> getSessionsByProfessor(Long professorId);
    List<Session> getSessionsByStudent(Long studentId);
    void deleteSessionById(Long sessionId);
}
