package com.esprit.microservice.subjectmanagement.dao;

import com.esprit.microservice.subjectmanagement.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    @Query("SELECT l FROM Level l JOIN l.subjects s WHERE s.id = :subjectId")
    List<Level> findBySubjectId(@Param("subjectId") Long subjectId);
}
