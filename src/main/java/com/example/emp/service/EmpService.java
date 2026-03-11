package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import com.example.emp.model.Employee;

public interface EmpService{
	
	Employee saveEmployee(Employee employee);
	Optional<Employee> getEmployeeByID(Long id);
	List<Employee> getAllEmployee();
	boolean deleteEmpByid(Long id);
	Employee updateEmployee(Long id,Employee emp);
	

}
