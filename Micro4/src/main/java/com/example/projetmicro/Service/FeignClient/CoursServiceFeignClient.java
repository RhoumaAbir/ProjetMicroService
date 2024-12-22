package com.example.projetmicro.Service.FeignClient;


import com.example.projetmicro.Entity.Cours;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cours-service")  // Remplacez l'URL par l'URL de votre service de cours
public interface CoursServiceFeignClient {

    // Récupérer tous les cours
    @GetMapping("/cours")
    List<Cours> retrieveCours();

    // Ajouter un nouveau cours
    @PostMapping("/cours")
    Cours addCours(@RequestBody Cours cours);

    // Mettre à jour un cours existant
    @PutMapping("/cours/{id}")
    Cours updateCours(@PathVariable("id") Long id, @RequestBody Cours cours);

    // Supprimer un cours par ID
    @DeleteMapping("/cours/{id}")
    void removeCours(@PathVariable("id") Long id);

    // Récupérer un cours par ID
    @GetMapping("/cours/{id}")
    Cours getCourById(@PathVariable("id") Long id);
}