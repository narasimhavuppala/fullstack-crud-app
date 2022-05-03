import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeService } from '../employe.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.sass']
})
export class AddEmployeeComponent implements OnInit {

  employeeForm!: FormGroup;
  constructor(private fb: FormBuilder, private empService:EmployeService, private route:Router) { 
   
  }

  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      name: ['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      role: ['',[Validators.required]],
      salary:[0,Validators.min(1000)]
      
    });
  }

  onSubmit(){
    if (this.employeeForm.valid) {
      console.log("Form Submitted!");
      let resource = JSON.stringify(this.employeeForm.value);
      console.log(this.employeeForm.value);
      console.log(resource);
      this.empService.saveEmployee(this.employeeForm.value).subscribe(res=>{
        console.log(res);
        this.employeeForm.reset();
        this.route.navigate(["/list"])
      })
     
    }
  }

}
