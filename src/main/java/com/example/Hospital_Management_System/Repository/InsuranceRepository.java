package com.example.Hospital_Management_System.Repository;

import com.example.Hospital_Management_System.schema.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}