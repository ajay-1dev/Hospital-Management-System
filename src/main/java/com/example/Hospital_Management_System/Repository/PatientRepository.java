package com.example.Hospital_Management_System.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hospital_Management_System.dto.CountOfBloodGroupDTO;
import com.example.Hospital_Management_System.schema.Patient;
import com.example.Hospital_Management_System.schema.Enums.BloodGroup;;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM patients where deleted_at is not null")
    public List<Patient> getDeletedPatients();

    //JpaQueryMethod
    public List<Patient> findByEmailOrBirthDate(String email, LocalDate birthdate);

    //JPQL
    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    public List<Patient> findByBloodGroup(BloodGroup bloodgroup);

    @Query("Select p From Patient p where p.birthDate > :dob")
    List<Patient> findByGreaterThanBirthDate(@Param("dob")LocalDate dob);

    /*
    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p GROUP BY p.bloodGroup")
    List<Object[]> countEachBloodGroupType();
    */


    //JPQL constructor expression query or Projection in JPQL
    @Query("SELECT new com.example.Hospital_Management_System.dto.CountOfBloodGroupDTO(p.bloodGroup, COUNT(p)) FROM Patient p GROUP BY p.bloodGroup")
    List<CountOfBloodGroupDTO> countEachBloodGroupType();

    /*
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.bloodGroup = :bloodgroup WHERE p.id = :id")
    public int updateBloodGroupWithId(@Param("id") Long id, @Param(bloodgroup) BloodGroup bloodgroup)
    */
}
