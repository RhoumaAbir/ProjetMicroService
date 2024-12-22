package com.example.projetmicro.Service;

import com.example.projetmicro.Entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICoursService   {
    List<Cours> retrieveCours();

    Cours updateCours (Cours cours);

    Cours addCours (Cours cours);


    void removeCours (long idCours);
    public Cours getCourById(Long idSource);

}
