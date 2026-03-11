package com.example.emp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.emp.controller.EmpContoller;
import com.example.emp.model.Employee;
import com.example.emp.service.EmpService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(EmpContoller.class)
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmpService empService;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void testEmpSave() throws Exception {
//        // Arrange
//        Employee employee = new Employee();
//        employee.setEmpid(1L);
//        employee.setName("Aman Gupta");
//        employee.setEmail("aman@example.com");
//        employee.setPhone("1234567890");
//        employee.setSalary(50000);
//        employee.setDesignation("Software Engineer");
//        employee.setDeparment("IT");
//        when(empService.saveEmployee(any(Employee.class))).thenReturn(employee);
//       // when(empService.saveEmployee(any(Employee.class))).thenReturn(employee);
//        
//        mockMvc.perform(post("/employees")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(employee)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(employee)));
//    }
    
    
    @Test
    void testSaveEmployee() throws Exception {
    	 Employee emp = new Employee(1L,"Aman", "aman@gmail", "80520",5000.0,"SDE","capgemini","IT");
         Mockito.when(empService.saveEmployee(Mockito.any(Employee.class)))
                .thenReturn(emp);
         			mockMvc.perform(post("/emp/save")
        	        .contentType(MediaType.APPLICATION_JSON)
        	        .content(objectMapper.writeValueAsString(emp)))
        	        .andDo(print())
        	        .andExpect(status().isCreated());
    }
    
    @Test
    void testGetEmployeeById() throws Exception {

        Employee emp = new Employee(1L,"Aman", "aman@gmail", "80520",5000.0,"SDE","capgemini","IT");

        Mockito.when(empService.getEmployeeByID(1L))
                .thenReturn(Optional.of(emp));

        mockMvc.perform(get("/emp/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Aman"));
    }
    
    @Test
    void testGetAllEmployees() throws Exception {

        Employee emp1 = new Employee(1L,"Aman", "aman@gmail", "80520",5000.0,"SDE","capgemini","IT");
        Employee emp2 = new Employee(2L, "Rahul","rahul@gmail.com","707155", 40000.0,"SO","capgemini","Sales");

        Mockito.when(empService.getAllEmployee())
                .thenReturn(Arrays.asList(emp1, emp2));

        mockMvc.perform(get("/emp/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }
    
    
    @Test
    void testDeleteEmployee() throws Exception {

        Mockito.when(empService.deleteEmpByid(1L)).thenReturn(true);

        mockMvc.perform(delete("/emp/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee deleted successfully"));
    }
    
    
    @Test
    void testUpdateEmployee() throws Exception {

        Employee emp = new Employee(1L,"Aman", "aman@gmail", "80520",5000.0,"SDE","capgemini","IT");

        Mockito.when(empService.updateEmployee(Mockito.eq(1L), Mockito.any(Employee.class)))
                .thenReturn(emp);

        mockMvc.perform(put("/emp/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)))
                .andExpect(status().isOk());
               // .andExpect().value(60000.0));
    }
    
    
    
    
}