import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Employee } from "./employee";
import { HttpClient } from "@angular/common/http"; 
import { environment } from '../environments/environment';

//This decorator marks the class as a service that can be injected into other classes or components.
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private APIurl = environment.API_BASE_URL + "/employee";

  constructor(private http: HttpClient) {}

  // Observable is used to handle the asynchronous data
  public getEmployees(): Observable<Employee[]> {
      return this.http.get<Employee[]>(`${this.APIurl}/all`);
  }

  public addEmployee(employee : Employee): Observable<Employee> {
      return this.http.post<Employee>(`${this.APIurl}/add`, employee);
  }
  public updateEmployee(employee : Employee): Observable<Employee> {
      return this.http.put<Employee>(`${this.APIurl}/update`, employee);
  }
  public deleteEmployee(employeeId : number): Observable<void> {
      return this.http.delete<void>(`${this.APIurl}/delete/${employeeId}`);
  }
}
