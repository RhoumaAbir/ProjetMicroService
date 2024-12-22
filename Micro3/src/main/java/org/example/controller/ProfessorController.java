package org.example.controller;

import org.example.entity.Evaluation;
import org.example.entity.Professor;
import org.example.service.EvaluationService;
import org.example.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professors")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @Autowired
    EvaluationService evaluationService;

    @PostMapping("/{evaluationId}")
    public ResponseEntity<Professor> createProfessor(
            @PathVariable("evaluationId") Long evaluationId,
            @RequestBody Professor professor) {

        Evaluation evaluation = evaluationService.getEvaluationById(evaluationId).get();
        if (evaluation == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Return 400 if evaluation is not found
        }
        professor.setEvaluation(evaluation);
        Professor savedProfessor = professorService.saveProfessor(professor);

        return new ResponseEntity<>(savedProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
        return professorService.updateProfessor(id, professorDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
