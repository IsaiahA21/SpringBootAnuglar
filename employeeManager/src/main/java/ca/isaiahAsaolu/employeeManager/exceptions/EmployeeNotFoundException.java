package ca.isaiahAsaolu.employeeManager.exceptions;

/**
 * This class is used to represent an exception that is thrown when an employee is not found.
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
