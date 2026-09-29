package com.example.Hospital_Management_System.Repository;

import com.example.Hospital_Management_System.schema.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String department);
}