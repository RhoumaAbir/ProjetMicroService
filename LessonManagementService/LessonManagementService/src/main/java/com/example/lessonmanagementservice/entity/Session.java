package com.example.lessonmanagementservice.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private  int capacity;
    @ManyToMany
    private List<Student> listOfStudents;
    @ManyToOne
    private Professor professor;
    @ManyToMany
    private List<Lesson> lessons;
    @ManyToOne
    private Level level;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }
    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public String getEndTime() {
        return endTime;
    }
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
