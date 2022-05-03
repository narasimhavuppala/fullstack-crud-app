import { Component, OnInit } from '@angular/core';
import { EmployeService } from '../employe.service';
import { Employee } from '../Employee';

@Component({
  selector: 'app-list-emmployee',
  templateUrl: './list-emmployee.component.html',
  styleUrls: ['./list-emmployee.component.sass']
})
export class ListEmmployeeComponent implements OnInit {

  empList:Employee[]=[];

  constructor(private service: EmployeService) { }
  
  ngOnInit(): void {
    this.service.getAllEmployees().subscribe(data=>{
      this.empList=data;
    })
  }

}
