package com.example.Hospital_Management_System.Repository;

import com.example.Hospital_Management_System.schema.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}