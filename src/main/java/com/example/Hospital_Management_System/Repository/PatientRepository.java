package com.example.Hospital_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Hospital_Management_System.schema.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM patients where deleted_at is not null")
    public List<Patient> getDeletedPatients();
}
