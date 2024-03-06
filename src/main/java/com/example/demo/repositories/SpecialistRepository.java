package com.example.demo.repositories;

import com.example.demo.entities.Habits;
import com.example.demo.entities.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SpecialistRepository extends JpaRepository<Specialist,Long> {
}
