package com.employeeexam.employeeexam.service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.employeeexam.employeeexam.contract.EmployeeDTO;
import com.employeeexam.employeeexam.model.Employee;
import com.employeeexam.employeeexam.repository.EmployeeRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    
    private final ModelMapper modelMapper = new ModelMapper();

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployeeDetails(@Valid EmployeeDTO request) {

        Employee employeeDetails = modelMapper.map(request, Employee.class);

        return employeeRepository.save(employeeDetails);
    }
    
}
