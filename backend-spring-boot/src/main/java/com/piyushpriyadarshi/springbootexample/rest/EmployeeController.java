package com.piyushpriyadarshi.springbootexample.rest;

import com.piyushpriyadarshi.springbootexample.entity.Employee;
import com.piyushpriyadarshi.springbootexample.model.PaginationRequest;
import com.piyushpriyadarshi.springbootexample.repository.EmployeeRepository;
import com.piyushpriyadarshi.springbootexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public Page<Employee> getAllEmployee(@RequestBody PaginationRequest paginationRequest){
        Page<Employee> employees;
        if(paginationRequest!=null){
            System.out.println(paginationRequest.getPageNumber());
            employees=employeeService.getAllEmployee(paginationRequest.getPageNumber(),paginationRequest.getPageSize());
        }
        else{
            employees=employeeService.getAllEmployee();
        }
        return employees;
    }

}
