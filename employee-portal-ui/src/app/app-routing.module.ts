import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddEmployeeComponent } from './employee/add-employee/add-employee.component';
import { ListEmmployeeComponent } from './employee/list-emmployee/list-emmployee.component';

const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'add', component: AddEmployeeComponent },
  { path: 'list', component: ListEmmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
