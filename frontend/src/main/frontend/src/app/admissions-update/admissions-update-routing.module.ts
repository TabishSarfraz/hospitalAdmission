import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdmissionsUpdateComponent } from './admissions-update.component';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: AdmissionsUpdateComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmissionsUpdateRoutingModule { }
