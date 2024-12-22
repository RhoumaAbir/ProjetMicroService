package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JsonIgnore
    private Evaluation evaluation;

    @ManyToMany
    @JsonIgnore
    private List<Session> sessions = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Subject> subjects = new ArrayList<>();
}


