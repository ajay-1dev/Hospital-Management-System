package com.example.Hospital_Management_System.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientDto {
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;
    private String bloodGroup;
}
