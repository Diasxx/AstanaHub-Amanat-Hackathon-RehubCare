package com.example.demo.services;


import com.example.demo.entities.Habits;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Specialist;

import java.util.List;

public interface HabitService {

    Habits addHabit(Habits habit);
    List<Habits> getAllHabits();
    Habits getHabit(Long id);
    void deleteHabit(Habits habit);
    Habits saveHabit(Habits habit);
    Patient getPatient(Long id);
    List<Patient> getAllPatients();
    Specialist getSpecialist(Long id);


}
