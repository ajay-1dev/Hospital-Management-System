package com.example.Hospital_Management_System.controller;

import com.example.Hospital_Management_System.Service.AppointmentService;
import com.example.Hospital_Management_System.dto.request.CreateAppointmentDTO;
import com.example.Hospital_Management_System.schema.Appointment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody @Valid CreateAppointmentDTO appointment){
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){

        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody @Valid CreateAppointmentDTO appointmentDTO){
        return appointmentService.updateAppointment(id, appointmentDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id){
        return appointmentService.deleteAppointment(id);
    }

}
