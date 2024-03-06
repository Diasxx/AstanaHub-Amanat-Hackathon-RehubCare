package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_specialist")
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "text")
    private String title;

    @Column(name = "surname" , columnDefinition = "text")
    private String text;

    @Column(name = "speciality" , columnDefinition = "text")
    private String speciality;

    @Column(name = "login" , columnDefinition = "text")
    private String login;

    @Column(name = "password" , columnDefinition = "text")
    private String password;
}
