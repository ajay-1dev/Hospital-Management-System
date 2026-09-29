package com.example.Hospital_Management_System.Service;

import com.example.Hospital_Management_System.GlobalException.ResourceNotFoundExceptionHandler;
import com.example.Hospital_Management_System.Repository.DepartmentRepository;
import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.dto.request.CreateDoctorDTO;
import com.example.Hospital_Management_System.schema.Department;
import com.example.Hospital_Management_System.schema.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    public Doctor createDoctor(CreateDoctorDTO request) {
        Doctor doctor = Doctor.builder()
                .name(request.getName())
                .email(request.getEmail())
                .specialization(request.getSpecialization())
                .build();
        doctor = doctorRepository.save(doctor);
        return doctor;

    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Doctor Not Found"));
    }

    public Doctor updateDoctorById(Long id, CreateDoctorDTO request) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Doctor Not Found"));
        if(request.getName() != null){
            doctor.setName(request.getName());
        }
        if (request.getEmail() != null){
            doctor.setEmail(request.getEmail());
        }
        if (request.getSpecialization() != null){
            doctor.setSpecialization(request.getSpecialization());
        }
//        if (request.getDepartment() != null){
//            Department department = departmentRepository.findByName(request.getDepartment())
//                    .orElseThrow(() -> new RuntimeException("Department Not Found"));
//            doctor.getDepartments().add(department);
//            department.getDoctors().add(doctor);
//            departmentRepository.save(department);
//        }

        return doctorRepository.save(doctor);
    }
}
