package com.example.demo.controllers;

import com.example.demo.entities.Habits;
import com.example.demo.entities.Patient;
import com.example.demo.entities.Specialist;
import com.example.demo.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HabitService habitService;


    @GetMapping(value = "/")
    public String index(Model model){

        List<Habits> habits = habitService.getAllHabits();
        model.addAttribute("Habits",habits);

        List<Patient> patients = habitService.getAllPatients();
        model.addAttribute("Patients",patients);

        return "mainpage";
    }

    @GetMapping(value = "/specialistpage")
    public String specialistpage(Model model){

        List<Habits> habits = habitService.getAllHabits();
        model.addAttribute("Habits",habits);

        List<Patient> patients = habitService.getAllPatients();
        model.addAttribute("Patients",patients);

        return "specialistpage";
    }

    @GetMapping(value = "/loginpage")
    public String login(){

        return "loginpage";
    }

    @GetMapping(value = "/patientpage")
    public String patient(Model model){

        List<Habits> habits = habitService.getAllHabits();
        model.addAttribute("Habits",habits);

        List<Patient> patients = habitService.getAllPatients();
        model.addAttribute("Patients",patients);


        return "patientpage";
    }


    @PostMapping(value = "/addhabit")
    public String addHabit(@RequestParam(name = "habit_id" ,defaultValue = "неверный ИИН") Long id,
                          @RequestParam(name = "habit_title" ,defaultValue = "No title") String title,
                          @RequestParam(name = "habit_desc" ,defaultValue = "No desc") String description,
                          @RequestParam(name = "habit_quantity" ,defaultValue = "0") int qunatity){

        Patient patient = habitService.getPatient(id);
        Specialist specialist = habitService.getSpecialist(patient.getSpecialist().getId());

        if(patient!=null){
            System.out.println("patient not null");
            habitService.addHabit(new Habits(null,title,description,qunatity,0,specialist,patient));
        }

        return "redirect:/specialistpage";
    }

    @PostMapping(value = "/deletehabit")
    public String deleteNote(@RequestParam(name = "id") Long id){

        Habits habit = habitService.getHabit(id);

        if(habit!=null){
            habitService.deleteHabit(habit);
        }
        return "redirect:/specialistpage";
    }

    @GetMapping(value = "/update/{habits}")
    public String updateHabit(Model model,@PathVariable(name = "habits") Long id )
    {
        Habits habit = habitService.getHabit(id);

        model.addAttribute("habit",habit);

        return "/update";
    }

    @PostMapping(value = "/chechhabit")
    public String checkHabit(@RequestParam(name = "id" ,defaultValue = "неверный ИИН") Long id)
    {

        Habits habit = habitService.getHabit(id);

        if(habit != null){
            if(habit.getQuantity_count()<habit.getQuantity())
            {
                habit.setQuantity_count(habit.getQuantity_count()+1);
                habitService.saveHabit(habit);
            }
        }

        try(FileWriter writer = new FileWriter("data.txt", false))
        {
            Date date = new java. util. Date();

            String text = habit.getPatient().getName() + " " + habit.getPatient().getSurname() +" "+ habit.getPatient().getId() + " в " + date +" выполнил задачу " + habit.getTitle() +" на одну единицу ";

            writer.append('\n');
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return "redirect:/patientpage";
    }

    @PostMapping(value = "/chechallhabit")
    public String checkAllHabit(@RequestParam(name = "id" ,defaultValue = "неверный ИИН") Long id)
    {

        Habits habit = habitService.getHabit(id);

        if(habit != null){
            if(habit.getQuantity_count()<habit.getQuantity())
            {
                habit.setQuantity_count(habit.getQuantity());
                habitService.saveHabit(habit);
            }
        }

        try(FileWriter writer = new FileWriter("data.txt", false))
        {
            Date date = new java. util. Date();

            String text = habit.getPatient().getName() + " " + habit.getPatient().getSurname() +" "+ habit.getPatient().getId() + " в " + date +" выполнил задачу " + habit.getTitle() +" на одну единицу ";


            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return "redirect:/patientpage";
    }

    @PostMapping(value = "/updatehabit")
    public String updateHabit(@RequestParam(name = "habit_id" ,defaultValue = "неверный ИИН") Long id,
                              @RequestParam(name = "habit_title" ,defaultValue = "No title") String title,
                              @RequestParam(name = "habit_desc" ,defaultValue = "No desc") String description,
                              @RequestParam(name = "habit_quantity" ,defaultValue = "0") int qunatity)
    {

        Habits habit = habitService.getHabit(id);

        if(habit != null){
            habit.setTitle(title);
            habit.setDescription(description);
            habit.setQuantity(qunatity);
            habitService.saveHabit(habit);
        }

        return "redirect:/specialistpage";
    }

}
