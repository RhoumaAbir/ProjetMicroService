package com.esprit.microservice.subjectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String code;

    private String description;

    private Integer credits;

    private boolean available = true;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private List<Level> levels;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    private List<Professor> professors = new ArrayList<>();
}
