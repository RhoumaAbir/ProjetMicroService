package com.example.lessonmanagementservice.service;



import com.example.lessonmanagementservice.entity.Lesson;

import java.util.List;

public interface ILessonService {

    Lesson createLesson(Lesson lesson, Long subjectId);

    List<Lesson> retrieveAllLessons();

    Lesson getLessonById(Long sessionId);

    void deleteLessonById(Long sessionId);
}
