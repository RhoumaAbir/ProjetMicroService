package org.example.repository;

import org.example.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
