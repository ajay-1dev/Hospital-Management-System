package com.example.Hospital_Management_System.dto;

import com.example.Hospital_Management_System.schema.Enums.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountOfBloodGroupDTO {
    private BloodGroup bloodGroup;
    private Long count;
}
