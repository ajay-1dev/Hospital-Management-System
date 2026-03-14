package com.example.Hospital_Management_System.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hospital_Management_System.GlobalException.ResourceNotFoundExceptionHandler;
import com.example.Hospital_Management_System.Repository.PatientRepository;
import com.example.Hospital_Management_System.dto.CreatePatientDto;
import com.example.Hospital_Management_System.schema.Patient;
import com.example.Hospital_Management_System.schema.Enums.BloodGroup;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    
    private final PatientRepository patientRepository;

        public Patient createPatient(CreatePatientDto createPatientDto){
        Patient patient = Patient.builder()
        .birthDate(createPatientDto.getBirthDate())
        .email(createPatientDto.getEmail())
        .gender(createPatientDto.getGender())
        .name(createPatientDto.getName())
        .bloodGroup(BloodGroup.valueOf(createPatientDto.getBloodGroup()))
        .build();
        return patientRepository.save(patient);
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id){
        return patientRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundExceptionHandler("Resource not found with this id : "+id));
    }

    public void deletePatientById(Long id){
        Patient patient = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExceptionHandler("Patient with this id : "+id+" not found to delete"));
        patientRepository.deleteById(id);
    }


    public Patient editPatientById(Long id,CreatePatientDto createPatientDto){
        Patient patient = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundExceptionHandler("patient with this id : "+id+" not found to edit"));
        patient.setBloodGroup(BloodGroup.valueOf(createPatientDto.getBloodGroup()));
        patient.setEmail(createPatientDto.getEmail());
        patient.setGender(createPatientDto.getGender());
        patient.setName(createPatientDto.getName());
        patient.setBirthDate(createPatientDto.getBirthDate());
        return patientRepository.save(patient);
    }

    public List<Patient> getDeletedPatients(){
        return patientRepository.getDeletedPatients();
    }

}
