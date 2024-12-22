package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.example.service.FeignClient.StudentServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceFeignClient studentServiceFeignClient;  // Inject the Feign client

    // Save a student using local repository
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Save a student using the remote Feign client
    public Student saveStudentRemote(Student student) {
        return studentServiceFeignClient.saveStudent(student);  // Remote call using Feign
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get all students using the remote Feign client
    public List<Student> getAllStudentsRemote() {
        return studentServiceFeignClient.getAllStudents();  // Remote call using Feign
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Get a student by ID using the remote Feign client
    public Optional<Student> getStudentByIdRemote(Long id) {
        return studentServiceFeignClient.getStudentById(id);  // Remote call using Feign
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id: " + id));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        return studentRepository.save(student);
    }

    // Update a student using the remote Feign client
    public Student updateStudentRemote(Long id, Student studentDetails) {
        return studentServiceFeignClient.updateStudent(id, studentDetails);  // Remote call using Feign
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id: " + id));
        studentRepository.delete(student);
    }

    // Delete a student using the remote Feign client
    public void deleteStudentRemote(Long id) {
        studentServiceFeignClient.deleteStudent(id);  // Remote call using Feign
    }
}
