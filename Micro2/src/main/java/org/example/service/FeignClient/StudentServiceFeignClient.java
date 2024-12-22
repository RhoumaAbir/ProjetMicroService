package org.example.service.FeignClient;
import org.example.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@FeignClient(name = "Student-service")
public interface StudentServiceFeignClient {
    @PostMapping("/students")
    Student saveStudent(@RequestBody Student student);

    @GetMapping("/students")
    List<Student> getAllStudents();

    @GetMapping("/students/{id}")
    Optional<Student> getStudentById(@PathVariable("id") Long id);

    @PutMapping("/students/{id}")
    Student updateStudent(@PathVariable("id") Long id, @RequestBody Student studentDetails);

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") Long id);
}
