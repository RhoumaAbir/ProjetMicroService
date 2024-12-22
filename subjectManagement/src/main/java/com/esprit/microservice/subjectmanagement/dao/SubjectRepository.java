package com.esprit.microservice.subjectmanagement.dao;

import com.esprit.microservice.subjectmanagement.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
