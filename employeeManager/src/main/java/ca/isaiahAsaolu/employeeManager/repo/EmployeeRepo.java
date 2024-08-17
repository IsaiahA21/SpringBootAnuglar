package ca.isaiahAsaolu.employeeManager.repo;

import ca.isaiahAsaolu.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* EmployeeRepo is an interface that extends the JpaRepository interface
* provided by Spring Data JPA. It is used to perform CRUD operations on the Employee entity.
* Long is the type of the primary key of the Employee entity.
*
* The JpaRepository interface provides methods for saving, updating, deleting, and finding entities.
* We don't need to implement theses we can just use them.
*
* Spring Data JPA automatically provides the implementation for all the methods at runtime when your application starts.
* */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Optional return type is used to avoid NullPointerException
    Optional<Employee> findEmployeeById(Long id); // query method to find an employee by id.
    // Spring Data JPA will automatically generate the query based on the method name
}
