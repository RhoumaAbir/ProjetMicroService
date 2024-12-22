package org.example.service;

import org.example.entity.Evaluation;
import org.example.entity.Professor;
import org.example.repository.EvaluationRepository;
import org.example.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService implements IEvaluationService {
    @Autowired
    EvaluationRepository evaluationRepository;

    @Autowired
    ProfessorRepository  professorRepository;

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> getEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    @Override
    public Evaluation saveEvaluation(Evaluation evaluation) {


        if (evaluation.getId() != null && evaluationRepository.existsById(evaluation.getId())) {
            Evaluation existingEvaluation = evaluationRepository.findById(evaluation.getId()).get();
            existingEvaluation.setCourseName(evaluation.getCourseName());
            existingEvaluation.setFeedback(evaluation.getFeedback());
            existingEvaluation.setScore(evaluation.getScore());

            return evaluationRepository.save(existingEvaluation);
        } else {
            return evaluationRepository.save(evaluation);
        }
    }
    @Override
    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public Evaluation updateEvaluation(Long id, Evaluation updatedEvaluation) {
        return evaluationRepository.findById(id).map(evaluation -> {
            evaluation.setCourseName(updatedEvaluation.getCourseName());
            evaluation.setScore(updatedEvaluation.getScore());
            evaluation.setFeedback(updatedEvaluation.getFeedback());
            evaluation.setEvaluationDate(updatedEvaluation.getEvaluationDate());
            return evaluationRepository.save(evaluation);
        }).orElseThrow(() -> new RuntimeException("Evaluation not found with id " + id));
    }
}
