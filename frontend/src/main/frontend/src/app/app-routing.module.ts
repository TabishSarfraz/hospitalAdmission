import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: "",
    loadChildren: "../app/admissions-list/admissions-list.module#AdmissionsListModule"
  },

  {
    path: "home",
    loadChildren: "../app/admissions-list/admissions-list.module#AdmissionsListModule"
  },

  {
    path: "create",
    loadChildren: "../app/admissions-create/admissions-create.module#AdmissionsCreateModule"
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
