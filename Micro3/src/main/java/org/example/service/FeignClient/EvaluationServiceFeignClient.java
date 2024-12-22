package org.example.service.FeignClient;


import org.example.entity.Evaluation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "evaluation-service")  // Remplacer l'URL par l'adresse correcte de votre service
public interface EvaluationServiceFeignClient {

    @GetMapping("/")
    List<Evaluation> getAllEvaluations();

    @GetMapping("/{id}")
    Optional<Evaluation> getEvaluationById(@PathVariable("id") Long id);

    @PostMapping("/")
    Evaluation saveEvaluation(@RequestBody Evaluation evaluation);

    @DeleteMapping("/{id}")
    void deleteEvaluation(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    Evaluation updateEvaluation(@PathVariable("id") Long id, @RequestBody Evaluation updatedEvaluation);
}
