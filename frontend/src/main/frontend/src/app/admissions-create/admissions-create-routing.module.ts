import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdmissionsCreateComponent } from './admissions-create.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: AdmissionsCreateComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmissionsCreateRoutingModule { }
