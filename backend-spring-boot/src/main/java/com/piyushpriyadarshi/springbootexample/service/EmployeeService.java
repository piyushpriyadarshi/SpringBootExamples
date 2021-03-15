package com.piyushpriyadarshi.springbootexample.service;

import com.piyushpriyadarshi.springbootexample.entity.Employee;
import com.piyushpriyadarshi.springbootexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private final int PAGE_SIZE=25;
    private final int PAGE_NUMBER=0;

    public Page<Employee> getAllEmployee(){
        return this.getAllEmployee(this.PAGE_NUMBER,this.PAGE_SIZE);
    }


    public Page<Employee> getAllEmployee(int pageNumber,int pageSize){
        System.out.println(pageNumber+"\t"+pageSize);
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Employee> employeePage=employeeRepository.findAll(pageable);
        return employeePage;
    }
}
