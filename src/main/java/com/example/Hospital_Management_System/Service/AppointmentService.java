package com.example.Hospital_Management_System.Service;

import com.example.Hospital_Management_System.GlobalException.ResourceNotFoundExceptionHandler;
import com.example.Hospital_Management_System.Repository.AppointmentRepository;
import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.Repository.PatientRepository;
import com.example.Hospital_Management_System.dto.request.CreateAppointmentDTO;
import com.example.Hospital_Management_System.dto.request.CreateDepartmentDTO;
import com.example.Hospital_Management_System.schema.Appointment;
import com.example.Hospital_Management_System.schema.Doctor;
import com.example.Hospital_Management_System.schema.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment createAppointment(CreateAppointmentDTO request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundExceptionHandler("Patient Not Found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() ->
                        new ResourceNotFoundExceptionHandler("Doctor Not Found"));

        Appointment appointment = Appointment.builder()
                .appointmentTime(request.getAppointmentTime())
                .reason(request.getReason())
                .patient(patient)
                .doctor(doctor)
                .build();

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }


    public Appointment updateAppointment(Long id,CreateAppointmentDTO request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Appointment Not Found"));
        if(request.getAppointmentTime() != null) {
            appointment.setAppointmentTime(request.getAppointmentTime());
        }
        if(request.getReason() != null) {
            appointment.setReason(request.getReason());
        }
        return appointmentRepository.save(appointment);
    }

    public String deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
        return "Appointment Deleted";
    }

}
