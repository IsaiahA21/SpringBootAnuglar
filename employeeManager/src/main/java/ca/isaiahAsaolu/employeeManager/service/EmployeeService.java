package ca.isaiahAsaolu.employeeManager.service;

import ca.isaiahAsaolu.employeeManager.exceptions.EmployeeNotFoundException;
import ca.isaiahAsaolu.employeeManager.model.Employee;
import org.springframework.stereotype.Service;
import ca.isaiahAsaolu.employeeManager.repo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


@Service // A service is a class that contains business logic and acts as an intermediary between a controller, a repository and database.
public class EmployeeService {
    @Autowired // This annotation is used to automatically inject the EmployeeRepo bean into the EmployeeService class.
    // Field Injection
    private EmployeeRepo employeeRepo;
    /*
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }*/

    public  Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public  Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public  void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee by id: " + id + " was not found")); // This method is not implemented in the EmployeeRepo interface automatically


    }
}
