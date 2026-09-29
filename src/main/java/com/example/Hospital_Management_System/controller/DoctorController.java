package com.example.Hospital_Management_System.controller;

import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.Service.DoctorService;
import com.example.Hospital_Management_System.dto.request.CreateDoctorDTO;
import com.example.Hospital_Management_System.schema.Doctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody @Valid CreateDoctorDTO doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody @Valid CreateDoctorDTO doctor) {
        return doctorService.updateDoctorById(id,doctor);
    }
}
