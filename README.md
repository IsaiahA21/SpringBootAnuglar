# Employee Manager FullStack Application
 Fullstack Angular, Spring Boot and MySQL application

## Description
This is a fullstack application that allows users to manage employees. The frontend is built using Angular and the backend is built using Spring Boot. The database used is MySQL. The application allows users to add, update, delete and view employees.

## SpringBoot MySQL Database environment variables
requires the following environment variables to be set:
```DB_USERNAME```
```DB_PASSWORD```

To do so create a .env file

Then navigate to `Run/Debug configuration` \ 
Create a new application and set "Environment variables" to the .env you created
![Run_Debug_Configurations.png](screenshots/Run_Debug_Configurations.png)

## Running the application
### Backend (Spring Boot)
1. Navigate to the backend directory (cd EmployeeManager)
2. Make sure you have the following environment variables set:
```DB_USERNAME```
```DB_PASSWORD```\
The application.properties file can be found at `employeeManager/src/main/resources/application.properties`

3. Run the following command to start the Spring Boot application:
``` ./mvnw spring-boot:run```
4. Or you can run the application using your IDE (IntelliJ, Eclipse, etc)\
The application will run on port 8080

### Frontend (Angular)
1. Navigate to the frontend directory (cd EmployeeManagerFrontend)
2. Run the following command to start the Angular application:
```ng serve```\
The application will run on port 4200

## Youtube demo
[youtube demo](https://youtu.be/OcTEFVhLh1U)

<details>
<summary>Screenshots</summary>

![zero Image](screenshots/zeroImage.png)
![zeroOne Image](screenshots/zeroOne.png)
![first Image](screenshots/firstImage.png)
![second Image](screenshots/secondImage.png)
![edit Employee](screenshots/editEmployee.png)
![delete Employee](screenshots/deleteEmployee.png)
![search Employee](screenshots/searchEmployee.png)
</details>
