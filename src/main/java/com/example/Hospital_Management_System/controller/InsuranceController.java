package com.example.Hospital_Management_System.controller;

import com.example.Hospital_Management_System.Service.InsuranceService;
import com.example.Hospital_Management_System.dto.request.CreateInsuranceDTO;
import com.example.Hospital_Management_System.schema.Insurance;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping
    public Insurance createInsurance(@RequestBody @Valid CreateInsuranceDTO createInsuranceDTO) {
        return insuranceService.createInsurance(createInsuranceDTO);
    }

    @GetMapping
    public List<Insurance> getAllInsurances(){
        return insuranceService.getAllInsurances();
    }
}
