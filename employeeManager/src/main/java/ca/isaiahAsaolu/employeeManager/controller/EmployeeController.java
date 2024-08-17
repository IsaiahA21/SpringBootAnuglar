package ca.isaiahAsaolu.employeeManager.controller;

import ca.isaiahAsaolu.employeeManager.model.Employee;
import ca.isaiahAsaolu.employeeManager.service.EmployeeService;
import ca.isaiahAsaolu.employeeManager.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is used to represent a controller that handles HTTP requests.
 * Controllers are small and simple classes
 */
@RestController
@RequestMapping("/employee")// this class will handle all requests that start with /employee
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<String> defaultRequest() {
        LoggerUtil.formatLog(EmployeeController.class,"Default request received");
        return  new ResponseEntity<>("Default request received", HttpStatus.OK);
    }

    @GetMapping("/all")
    // returns an HTTP response with a list of employees
    public ResponseEntity<List<Employee>> getAllEmployees() {
        LoggerUtil.formatLog(EmployeeController.class,"Request to get all employees");
        List<Employee> employees = employeeService.findAllEmployees();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    // returns an HTTP response with a list of employees
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long theId) {
        LoggerUtil.formatLog(EmployeeController.class,"Request to get employee with id: " + theId );
        Employee employee = employeeService.findEmployeeById(theId);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        LoggerUtil.formatLog(EmployeeController.class,"Request to add a new employee: " + employee);
        Employee createdEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        LoggerUtil.formatLog(EmployeeController.class,"Request to update employee: " + employee);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long theId){
        LoggerUtil.formatLog(EmployeeController.class,"Request to delete employee with id: " + theId);
        employeeService.deleteEmployee(theId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
