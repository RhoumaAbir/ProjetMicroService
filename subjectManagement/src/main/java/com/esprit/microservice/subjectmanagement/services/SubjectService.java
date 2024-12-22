package com.esprit.microservice.subjectmanagement.services;

import com.esprit.microservice.subjectmanagement.dao.SubjectRepository;
import com.esprit.microservice.subjectmanagement.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject modifySubject(Long id, Subject newSubject) {
        Subject subject = subjectRepository.findById(id).get();
        subject.setName(newSubject.getName());
        subject.setDescription(newSubject.getDescription());
        subject.setCode(newSubject.getCode());
        subject.setCredits(newSubject.getCredits());
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public List<Subject> getAllSubjects() {
        return  subjectRepository.findAll();
    }

    @Override
    public Subject updateAvailability(Long id) {
        Subject subject = subjectRepository.findById(id).get();
        subject.setAvailable(!subject.isAvailable());
        return subjectRepository.save(subject);
    }
}
