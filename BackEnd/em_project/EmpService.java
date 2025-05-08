package com.example.em_project;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    public List<Employee> reademployee();
    public Employee readonlyEmployee(Long id);
    public String createemployee(Employee employee);
    public boolean deletemployees(Long id);
    public String updateemployee(Long id, Employee employee);
}
