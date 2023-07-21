package com.employeeexam.employeeexam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeexam.employeeexam.contract.EmployeeDTO;
import com.employeeexam.employeeexam.contract.Response;
import com.employeeexam.employeeexam.model.Employee;
import com.employeeexam.employeeexam.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
     private final EmployeeService employeeService;

    @SneakyThrows
    @Operation(summary = "Save employee details request")
    @PostMapping(value = {"/save"})
    public ResponseEntity<Response> saveEmployee(@Valid @RequestBody EmployeeDTO request) {
        Employee employeeDetailsResponse = employeeService.saveEmployeeDetails(request);
        return new ResponseEntity<>(
                Response.builder()
                        .payload(String.valueOf(employeeDetailsResponse))
                        .message("Successfully saved")
                        .build(),
                HttpStatus.OK);
    }
    
    
}
