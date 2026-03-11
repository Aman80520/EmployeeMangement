package com.example.emp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.emp.exception.ResourseNotFoundException;
import com.example.emp.model.Employee;
import com.example.emp.service.EmpService;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpContoller {

    private EmpService employeeService;
    
    public EmpContoller(EmpService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee saveEmployee = employeeService.saveEmployee(emp);
		
		return new ResponseEntity<Employee>(saveEmployee,HttpStatus.CREATED);
       
		
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee emp= employeeService.getEmployeeByID(id).orElseThrow(()->new ResourseNotFoundException("This emp id"+id+" is not present"));
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmpByid(id);
        if (deleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            throw new ResourseNotFoundException("This emp id "+id+" is not present");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        Employee updated = employeeService.updateEmployee(id, emp);
        return ResponseEntity.ok(updated);
    }
}