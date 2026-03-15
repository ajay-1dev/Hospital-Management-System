package com.example.Hospital_Management_System.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hospital_Management_System.Service.PatientService;
import com.example.Hospital_Management_System.dto.CountOfBloodGroupDTO;
import com.example.Hospital_Management_System.dto.CreatePatientDto;
import com.example.Hospital_Management_System.schema.Patient;
import com.example.Hospital_Management_System.schema.Enums.BloodGroup;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequiredArgsConstructor
@RequestMapping("Api/v1/patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> getPatient() {
        List<Patient> patients = patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK)
        .body(patients);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK)
        .body(patient);
    }
    

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody CreatePatientDto createPatientDto) {        
        Patient patient = patientService.createPatient(createPatientDto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(patient);
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.status(HttpStatus.OK)
        .body("Patient Record Deleted Sucessfully");
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Patient> EditById(@PathVariable("id") Long id, @RequestBody CreatePatientDto createPatientDto) {
        Patient patient = patientService.editPatientById(id, createPatientDto);
        return ResponseEntity.status(HttpStatus.OK)
        .body(patient);
    }
    

    //using Native Query
    @GetMapping("deletedrecords")
    public ResponseEntity<List<Patient>> getDeletedPatients() {
        List<Patient> patients = patientService.getDeletedPatients();
        return ResponseEntity.status(HttpStatus.OK)
        .body(patients);
    }

    //Using Jpa Query Method
    @GetMapping("{email}/{birthdate}")
    public ResponseEntity<List<Patient>> getPatientByEmailOrBirthDate(@PathVariable("email") String email, @PathVariable("birthdate") String birthdate) {
        List<Patient> patients = patientService.getpatientsByEmailOrBirthDate(email,LocalDate.parse(birthdate));
        return ResponseEntity.status(HttpStatus.OK)
        .body(patients);
    }

    //JPQL
    @GetMapping("bloodgroup/{bloodgroup}")
    public ResponseEntity<List<Patient>> getPatientByBloodGroup(@PathVariable("bloodgroup") String bloodGroup){
        return ResponseEntity.status(HttpStatus.OK)
        .body(patientService.getPateintByBloodGroup((BloodGroup.valueOf(bloodGroup)))); 
    }

    //JPQl
    @GetMapping("greaterthanbirthdate/{dob}")
    public ResponseEntity<List<Patient>> getPatientGreaterThanBirthDate(@PathVariable("dob") String dob) {
        return ResponseEntity.status(HttpStatus.OK)
        .body(patientService.getPatientGreaterThanBirthDate(LocalDate.parse(dob)));
    }

    //JPQL
    @GetMapping("countof/bloodgroup")
    public ResponseEntity<List<CountOfBloodGroupDTO>> getCountOfBloodGroup() {
        return ResponseEntity.status(HttpStatus.OK)
        .body(patientService.getCountOfBloodGroup());
    }
    
    
    
}
