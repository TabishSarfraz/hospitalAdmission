import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdmissionsListComponent } from './admissions-list.component';


const routes: Routes = [
  {
    path: "", component: AdmissionsListComponent
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmissionsListRoutingModule { }
