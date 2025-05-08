package com.example.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Serviceimp implements EmpService {

    // List<Employee> employees = new ArrayList<>();

    @Autowired
    private Emprepositry emprepositry;

    @Override
    public List<Employee> reademployee() {
        List<EmployeeEntity> employeeEntities = emprepositry.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);

        }
        return employees;
    }


    @Override
    public boolean deletemployees(Long id) {
        EmployeeEntity employeeEntity = emprepositry.findById(id).get();
        emprepositry.delete(employeeEntity);
        return true;

    }

    @Override
    public Employee readonlyEmployee(Long id) {
        EmployeeEntity employeeEntity = emprepositry.findById(id).get();
        Employee emp = new Employee();
        emp.setId(employeeEntity.getId());
        emp.setName(employeeEntity.getName());
        emp.setPhone(employeeEntity.getPhone());
        emp.setEmail(employeeEntity.getEmail());

        return emp;

    }


    @Override
    public String createemployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        emprepositry.save(employeeEntity);
        return "Add succesfully";
    }


    @Override
    public String updateemployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = emprepositry.findById(id).get();
        employeeEntity.setName(employee.getName());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setEmail(employee.getEmail());

        emprepositry.save(employeeEntity);
        return "Update";
        

    }

}
