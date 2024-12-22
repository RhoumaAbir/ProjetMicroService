package org.example.service;

import org.example.entity.Professor;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public Professor updateProfessor(Long id, Professor professorDetails) {

        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found for this id: " + id));
        professor.setFirstName(professorDetails.getFirstName());
        professor.setLastName(professorDetails.getLastName());
        professor.setDepartment(professorDetails.getDepartment());
        professor.setEmail(professorDetails.getEmail());
        professor.setPhoneNumber(professorDetails.getPhoneNumber());
        return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found for this id: " + id));
        professorRepository.delete(professor);
    }
}
