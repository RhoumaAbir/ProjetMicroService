package org.example.service;

import org.example.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
     Student saveStudent(Student student);
     List<Student> getAllStudents();
     Optional<Student> getStudentById(Long id);
     Student updateStudent(Long id, Student studentDetails);
     void deleteStudent(Long id);
}
