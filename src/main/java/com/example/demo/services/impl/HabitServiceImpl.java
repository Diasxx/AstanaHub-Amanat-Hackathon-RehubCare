package com.example.demo.services.impl;

import com.example.demo.entities.Habits;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Specialist;
import com.example.demo.repositories.HabitRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.SpecialistRepository;
import com.example.demo.services.HabitService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class HabitServiceImpl implements HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @Override
    public Habits addHabit(Habits habit) {
        return habitRepository.save(habit);
    }

    @Override
    public List<Habits> getAllHabits() {
        return habitRepository.findAll();
    }

    @Override
    public Habits getHabit(Long id) {
        return habitRepository.getOne(id);
    }

    @Override
    public void deleteHabit(Habits habit) {
        habitRepository.delete(habit);
    }

    @Override
    public Habits saveHabit(Habits habit) {
        return habitRepository.save(habit);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.getOne(id);
    }

    @Override
    public Specialist getSpecialist(Long id) {
        return specialistRepository.getOne(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
