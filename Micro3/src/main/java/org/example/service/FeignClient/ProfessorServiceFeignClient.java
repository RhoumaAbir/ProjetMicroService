package org.example.service.FeignClient;


import org.example.entity.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "professor-service" ) // Remplacer l'URL par celle de votre service
public interface ProfessorServiceFeignClient {

    @PostMapping("/")
    Professor saveProfessor(@RequestBody Professor professor);

    @GetMapping("/")
    List<Professor> getAllProfessors();

    @GetMapping("/{id}")
    Optional<Professor> getProfessorById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professorDetails);

    @DeleteMapping("/{id}")
    void deleteProfessor(@PathVariable("id") Long id);
}

