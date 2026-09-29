package com.example.Hospital_Management_System.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentDTO {

    @NotNull(message = "patientId is mandatory")
    private Long patientId;

    @NotNull(message = "doctorId is mandatory")
    private Long doctorId;

    @NotNull(message = "appointmentTime is mandatory")
    private LocalDateTime appointmentTime;

    @NotNull(message = "reason is mandatory")
    private String reason;
}