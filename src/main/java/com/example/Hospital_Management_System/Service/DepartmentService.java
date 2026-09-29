package com.example.Hospital_Management_System.Service;

import com.example.Hospital_Management_System.GlobalException.ResourceNotFoundExceptionHandler;
import com.example.Hospital_Management_System.Repository.DepartmentRepository;
import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.dto.request.CreateDepartmentDTO;
import com.example.Hospital_Management_System.schema.Department;
import com.example.Hospital_Management_System.schema.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public Department createDepartment(CreateDepartmentDTO createDepartmentDTO,Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Doctor not found"));
        Department department = Department.builder()
                .name(createDepartmentDTO.getName())
                .headDoctor(doctor)
                .build();
        return departmentRepository.save(department);
    }

    public Department assignHeadDoctor(Long departmentId, Long headDoctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Department not found"));
        Doctor doctor = doctorRepository.findById(headDoctorId)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Doctor not found"));
        department.setHeadDoctor(doctor);

        return departmentRepository.save(department);

    }

    public Department assignDoctor(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Department not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Doctor not found"));
        department.getDoctors().add(doctor);
        doctorRepository.save(doctor);
        return departmentRepository.save(department);

    }
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public String deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return "Department deleted";
    }
}
