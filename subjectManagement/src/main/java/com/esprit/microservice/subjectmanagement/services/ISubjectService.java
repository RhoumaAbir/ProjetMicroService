package com.esprit.microservice.subjectmanagement.services;

import com.esprit.microservice.subjectmanagement.entities.Subject;

import java.util.List;

public interface ISubjectService {
     Subject createSubject(Subject subject);
     Subject modifySubject(Long id, Subject subject);
     void deleteSubject(Long id);
     Subject getSubjectById(Long id);
     List<Subject> getAllSubjects();
     Subject updateAvailability(Long id);
}
