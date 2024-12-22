package com.example.projetmicro.Service;

import com.example.projetmicro.Entity.Cours;
import com.example.projetmicro.Repository.CoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursServiceImpl implements ICoursService{
    @Autowired
    CoursRepository coursRepository;


    @Override
    public List<Cours> retrieveCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }
    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }
    @Override
    public void removeCours(long idCours) {
        coursRepository.deleteById(idCours);
    }
    @Override
    public Cours getCourById(Long idSource) {
        return coursRepository.findById(idSource).orElse(null);
    }
}
