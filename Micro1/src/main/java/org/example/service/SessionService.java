package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.entity.Professor;
import org.example.entity.Session;
import org.example.entity.Student;
import org.example.repository.ProfessorRepository;
import org.example.repository.SessionRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;


    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Create or Update a Session
    public Session createSession(Session session, Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with ID: " + professorId));
        session.setProfessor(professor);
        session.setLessons(session.getLessons());
        return sessionRepository.save(session);
    }

    public Boolean bookSpot(Long studentId, Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found with ID: " + sessionId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));

        if (session.getStudents().size() < session.getCapacity()) {
            session.getStudents().add(student);
            sessionRepository.save(session); // Save the updated session with the new student
            return true;
        } else {
            return false;
        }
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found with ID: " + sessionId));
    }

    @Override
    public List<Session> getSessionsByProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new EntityNotFoundException("Professor not found with ID: " + professorId));
        return sessionRepository.findSessionByProfessor(professor);
    }

    @Override
    public List<Session> getSessionsByStudent(Long studentId) {
        List<Session> allSessions = sessionRepository.findAll();
        List<Session> studentSessions = new ArrayList<>();
        for (Session session : allSessions) {
            for (Student student : session.getStudents()) {
                if (student.getId().equals(studentId)) {
                    studentSessions.add(session);
                    break;
                }
            }
        }
        return studentSessions;
    }

    // Delete a session by ID
    public void deleteSessionById(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public List<Session> retrieveAllSessions() {
        return sessionRepository.findAll();
    }

    public Session updateSession(Session updatedSession, Long idSesssion){
        Session session = this.sessionRepository.findById(idSesssion).get();
        session.setLessons(updatedSession.getLessons());
        session.setDate(updatedSession.getDate());
        session.setStartTime(updatedSession.getStartTime());
        session.setEndTime(updatedSession.getEndTime());
        return this.sessionRepository.save(session);
    }
}