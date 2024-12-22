package com.example.projetmicro.Controller;

import com.example.projetmicro.Entity.Cours;
import com.example.projetmicro.Repository.CoursRepository;
import com.example.projetmicro.Service.CoursServiceImpl;
import com.example.projetmicro.Service.ICoursService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Cours")
public class CoursRestController {
    @Autowired
    CoursServiceImpl coursService ;

    @GetMapping("/retrieve-all")
    public List<Cours> getCours(){
        List<Cours> coursList = coursService.retrieveCours() ;
        return coursList ;
    }

    @PostMapping("/add")
    public Cours AddCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);

    }
    @PutMapping("/Update/{idCours}")
    public Cours UpdateCour(@RequestBody Cours cours) {
        return coursService.updateCours(cours);

    }
    @DeleteMapping("/Delete/{cours-id}")
    public void DeleteCours(@PathVariable("cours-id") Long idCours ){
        coursService.removeCours(idCours);
    }


    @GetMapping("/trouver_Cour/{idCours}")
    public Cours getCourById(@PathVariable("idCours") Long idCours){
        return coursService.getCourById(idCours);}
}
