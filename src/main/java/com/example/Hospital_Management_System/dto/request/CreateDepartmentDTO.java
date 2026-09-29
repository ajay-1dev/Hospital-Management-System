package com.example.Hospital_Management_System.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDepartmentDTO {
    @NotNull(message = "department name is mandatory")
    private String name;
}
