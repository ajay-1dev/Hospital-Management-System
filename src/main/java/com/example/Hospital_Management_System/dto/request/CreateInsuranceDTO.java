package com.example.Hospital_Management_System.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateInsuranceDTO {

    @NotNull(message = "policy number is mandatory")
    private String policyNumber;

    @NotNull(message = "provider is mandatory")
    private String provider;

}
