import { Component, inject, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

// Use OnInit so that we can call the getEmps() method when the component is initialized
export class AppComponent implements OnInit{

  ngOnInit(): void {
    this.getEmps();
  }

  public employees: Employee[] = []; // holds all the employees coming from the server
  originalEmployees: Employee[] =[]; //// Only read from this array. useful in the search
  editEmployee : Employee | null = null; // the employee being edited. It will be binded to the edit form
  deleteEmployee: Employee | null =null;


  // Injecting the EmployeeService class into the AppComponent class
  employeeService: EmployeeService = inject(EmployeeService);

  public getEmps(): void {
    //because getEmployees is an Observable, we need to subcribe so that we are notified went we get something back from the server
    this.employeeService.getEmployees().subscribe({
      // Handle the response if it's an array of employees
      next: (res: Employee[]) => {
        this.employees = res;
        this.originalEmployees = res; 
      },
      // Handle any HTTP errors
      error(err: HttpErrorResponse) {
        console.log(err.message);
      },
      complete: () => {
        console.log('getEmps() completed');
      }
    }
    );
  }
  /**
   * This function  is the open a modal.
   * We create the button because bootstrap 4.0 needs a button to open a modal
   * @param employee - This is the employee that the user is currently adding, editing or deleting
   * @param modal - Helps to define which modal the user is trying to open
   */
  public onOpenModal(employee : Employee | null, modal : String) : void {
    const container = document.getElementById("main-container");

    const modalButton = document.createElement('button');
    modalButton.type = 'button';
    modalButton.style.display = 'none'; // it wouldn't be shown on the ui
    modalButton.setAttribute('data-toggle', 'modal');
    if (modal === 'add') {
      // set the data-tagert to  the id of the div
      modalButton.setAttribute('data-target', '#addEmployeeModal');
    } 
    if (modal === 'edit' && employee) {
      this.editEmployee = employee;
      // user is tyring to add on employee
      modalButton.setAttribute('data-target', '#updateEmployeeModal');
    } 
    if (modal === 'delete'  && employee) {
      this.deleteEmployee = employee;
      modalButton.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container?.appendChild(modalButton); // now the bottom will be added to the DOM

    modalButton.click(); // button is clicked
  }

  public addEmployeeHandler(addForm: NgForm): void {
    document.getElementById('add-employee-form-close')?.click(); // close the modal
    // send the form to the backend
    // .value is the json presentation of the input
    this.employeeService.addEmployee(addForm.value).subscribe({
      next:(res: Employee) => {
        console.log("Add successful:",res);
        this.getEmps();// call getEmps() to refresh the list of employees
      },
      error: (err: HttpErrorResponse) => {
        console.log("Error adding user: ", err.message);
      },
      complete() {
          addForm.resetForm();
      },
    })
  }
  public editEmployeeHandler(emp: Employee): void {
    
    this.employeeService.updateEmployee(emp).subscribe({
      next:(res: Employee) => {
        console.log(`Update of ${emp.name} successful:`,res);
        this.getEmps();// call getEmps() to refresh the list of employees
      },
      error: (err: HttpErrorResponse) => {
        console.log("Error updating user: ", err.message);
      },
      complete: ()=>{this.editEmployee = null;}
    })
  }
  
  deleteEmployeeHandler(empId: number): void{
    this.employeeService.deleteEmployee(empId).subscribe({
      next:(res: void)=>{
        console.log(`Delete successful:`,res);
        this.getEmps();
      },
      error: (err: HttpErrorResponse) => {
        console.log("Error deleting user: ", err.message);
      },
      complete: ()=>{this.deleteEmployee = null;}
    })
  }
  public searchForEmployees(key: string): void {
    // console.log("key is: ", key);
    const results: Employee[]  = [];
    for(const employee of this.originalEmployees){
      if(employee.name.toLocaleLowerCase().indexOf(key.toLowerCase()) !== -1 
      || employee.email.toLocaleLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.phone.toLocaleLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.jobTitle.toLocaleLowerCase().indexOf(key.toLowerCase()) !== -1
    ){
        results.push(employee);
      }
    }
    // console.log("result length is: ", results.length);

      // if the result is empty and there is nothting being searched, reset to original list
    if (results.length === 0 && !key ){
      this.employees = this.originalEmployees;
    }else {
      this.employees =results;
    }
  }
}
