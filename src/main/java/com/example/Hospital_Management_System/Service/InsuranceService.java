package com.example.Hospital_Management_System.Service;

import com.example.Hospital_Management_System.Repository.InsuranceRepository;
import com.example.Hospital_Management_System.dto.request.CreateInsuranceDTO;
import com.example.Hospital_Management_System.schema.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public Insurance createInsurance(CreateInsuranceDTO request){
        Insurance insurance = Insurance.builder()
                .policyNumber(request.getPolicyNumber())
                .provider(request.getProvider())
                .validUntil(LocalDate.now().plusYears(1))
                .build();

        return insuranceRepository.save(insurance);
    }

    public List<Insurance> getAllInsurances(){
        return insuranceRepository.findAll();
    }




}
