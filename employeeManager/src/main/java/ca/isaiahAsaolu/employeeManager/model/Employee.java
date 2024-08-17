package ca.isaiahAsaolu.employeeManager.model;

import jakarta.persistence.*;

import java.io.Serializable;

/* Employee is in the Model. It is a class that represents the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class. It is used to store the data of an employee. It is a simple class with no methods. It is used to store the data of an employee. It is a POJO (Plain Old Java Object) class.
* It is used to store the data of an employee. It is a simple class with no methods.
* */

@Entity // This annotation is used to specify that the class is an entity and is mapped to a database table.
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to specify that the primary key is automatically generated by the system.
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    // toString method

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}