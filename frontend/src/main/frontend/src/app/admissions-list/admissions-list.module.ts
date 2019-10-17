import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmissionsListRoutingModule } from './admissions-list-routing.module';
import { AdmissionsListComponent } from './admissions-list.component';


@NgModule({
  declarations: [AdmissionsListComponent],
  imports: [
    CommonModule,
    AdmissionsListRoutingModule
  ]
})
export class AdmissionsListModule { }
