package com.example.lessonmanagementservice.repository;



import com.example.lessonmanagementservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {



}
