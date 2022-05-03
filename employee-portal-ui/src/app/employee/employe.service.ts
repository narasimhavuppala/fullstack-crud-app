import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  private url = "http://localhost:8080/employee-portal/employee";

  constructor(private httpclient: HttpClient) { }

  public getAllEmployees(): Observable<Employee[]> {
    return this.httpclient.get<Employee[]>(this.url);
  }

  public saveEmployee(emp:any){
    return this.httpclient.post(this.url,emp);
  }
}