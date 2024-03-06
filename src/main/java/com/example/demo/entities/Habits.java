package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_habits")
public class Habits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "description" , columnDefinition = "text")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "quantity_count")
    private int quantity_count;

    @ManyToOne(fetch = FetchType.EAGER)
    private Specialist specialist;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

}
