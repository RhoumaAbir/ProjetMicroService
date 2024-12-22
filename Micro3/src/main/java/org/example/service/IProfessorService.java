package org.example.service;

import org.example.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    Professor saveProfessor(Professor professor);
    List<Professor> getAllProfessors();
    Optional<Professor> getProfessorById(Long id);
    Professor updateProfessor(Long id, Professor professorDetails);
    void deleteProfessor(Long id);
}
