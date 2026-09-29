package com.example.Hospital_Management_System.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientDto {

    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "birthDate is mandatory")
    private LocalDate birthDate;

    @NotNull(message = "email is mandatory")
    @Email(message = "provide valid Email")
    private String email;

    @NotNull(message = "gender is mandatory")
    private String gender;

    @NotNull(message = "bloodGroup is mandatory")
    private String bloodGroup;
}
