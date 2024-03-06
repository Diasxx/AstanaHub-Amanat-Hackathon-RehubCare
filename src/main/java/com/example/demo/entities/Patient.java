package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "surname" , columnDefinition = "text")
    private String surname;

    @Column(name = "login" , columnDefinition = "text")
    private String login;

    @Column(name = "password" , columnDefinition = "text")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Specialist specialist;

}
