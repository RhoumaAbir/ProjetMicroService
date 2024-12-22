package com.example.projetmicro.Repository;

import com.example.projetmicro.Entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
