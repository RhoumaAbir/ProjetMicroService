package com.example.lessonmanagementservice.service;
import com.example.lessonmanagementservice.entity.Lesson;
import com.example.lessonmanagementservice.entity.Subject;
import com.example.lessonmanagementservice.repository.LessonRepository;
import com.example.lessonmanagementservice.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements ILessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Lesson createLesson(Lesson lesson, Long subjectId) {
       // Subject subject =this.subjectRepository.findById(subjectId).get();
       // subject.getLessons().add(lesson);
      //  subjectRepository.save(subject);
        return lessonRepository.save(lesson);
    }

    public List<Lesson> retrieveAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with ID: " + lessonId));
    }

    public Lesson updateLesson(Lesson updatedLesson, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found with ID: " + lessonId));
        lesson.setCours(updatedLesson.getCours());
        lesson.setTitle(updatedLesson.getTitle());
        lesson.setSubject(updatedLesson.getSubject());
        return lessonRepository.save(lesson);
    }

    // Delete a Lesson by ID
    public void deleteLessonById(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
