package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.emp.model.Employee;
import com.example.emp.repository.EmpRepoistory;

@Service
public class employeeServiceImpl implements EmpService{

	
	private EmpRepoistory empRepoistory;
	
	public employeeServiceImpl(EmpRepoistory empRepoistory) {
		this.empRepoistory = empRepoistory;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepoistory.save(employee);
		
	}

	@Override
	public Optional<Employee> getEmployeeByID(Long id) {
		return empRepoistory.findById(id);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepoistory.findAll();
	}

	@Override
	public boolean deleteEmpByid(Long id) {
		if(empRepoistory.existsById(id)) {
			 empRepoistory.deleteById(id);
			 return true;
		}
		return false;
	}

	@Override
	public Employee updateEmployee(Long id, Employee emp) {
	    return empRepoistory.findById(id)
	        .map(oldEmp -> {
	            // Update all fields
	            oldEmp.setName(emp.getName());
	            oldEmp.setEmail(emp.getEmail());
	            oldEmp.setPhone(emp.getPhone());
	            oldEmp.setSalary(emp.getSalary());
	            oldEmp.setCompanyName(emp.getCompanyName());
	            oldEmp.setDesignation(emp.getDesignation());
	            oldEmp.setDeparment(emp.getDeparment());
	            return empRepoistory.save(oldEmp);
	        })
	        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}

}
