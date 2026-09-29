package com.example.Hospital_Management_System.controller;

import com.example.Hospital_Management_System.Service.DepartmentService;
import com.example.Hospital_Management_System.dto.request.CreateDepartmentDTO;
import com.example.Hospital_Management_System.schema.Department;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/department")
@RequiredArgsConstructor
public class DepartmentController {


    private final DepartmentService departmentService;

    @PostMapping("/{doctorId}")
    public Department addDepartment(@PathVariable Long doctorId,@RequestBody @Valid CreateDepartmentDTO department) {
        return departmentService.createDepartment(department,doctorId);
    }

    @PutMapping("/assignheaddoctor/{departmentId}/{headDoctorId}")
    public Department assignHeadDoctor(@PathVariable Long departmentId, @PathVariable Long headDoctorId) {
        return departmentService.assignHeadDoctor(departmentId,headDoctorId);
    }

    @PutMapping("/assigndoctor/{departmentId}/{doctorId}")
    public Department assignDoctor(@PathVariable Long departmentId, @PathVariable Long doctorId) {
        return departmentService.assignDoctor(departmentId,doctorId);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
}

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
    }

}
