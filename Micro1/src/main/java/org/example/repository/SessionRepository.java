package org.example.repository;

import org.example.entity.Professor;
import org.example.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SessionRepository extends JpaRepository<Session,Long>  {

    List<Session>findSessionByProfessor(Professor professor);
}
