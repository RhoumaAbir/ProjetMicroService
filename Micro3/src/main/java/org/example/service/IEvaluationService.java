package org.example.service;

import org.example.entity.Evaluation;

import java.util.List;
import java.util.Optional;

public interface IEvaluationService {
    List<Evaluation> getAllEvaluations();
    Optional<Evaluation> getEvaluationById(Long id);
    Evaluation saveEvaluation(Evaluation evaluation);
    void deleteEvaluation(Long id);
    Evaluation updateEvaluation(Long id, Evaluation updatedEvaluation);
}
