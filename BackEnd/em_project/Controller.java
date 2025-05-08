package com.example.em_project;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:3000/")
public class Controller {
    
    // Service emps = new Serviceimp();
    // List<Employee> employees = new ArrayList();

    @Autowired 
    EmpService emps;

    @GetMapping("employees")
    public List<Employee> Getallemployee() {
        return emps.reademployee();
    }

    @GetMapping("employees/{id}")
    public Employee getMethodName(@PathVariable Long id) {
        return emps.readonlyEmployee(id);
    }
    
    @PostMapping("employees")
    public String readAllemployee(@RequestBody Employee employee) {   
        return emps.createemployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deletemployees(@PathVariable Long id)
    {
        if(emps.deletemployees(id))
            return "delete";
        return "not found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee ){  
        return emps.updateemployee(id, employee);
    }
}
