package com.example.Hospital_Management_System.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDoctorDTO {
    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "specialization is mandatory")
    private String specialization;

    @NotNull(message = "email is mandatory")
    @Email(message = "provide valid Email")
    private String email;


    private String department;
}
