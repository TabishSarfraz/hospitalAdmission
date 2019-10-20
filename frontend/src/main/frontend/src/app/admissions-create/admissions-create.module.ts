import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmissionsCreateRoutingModule } from './admissions-create-routing.module';
import { AdmissionsCreateComponent } from './admissions-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [AdmissionsCreateComponent],
  imports: [
    CommonModule,
    AdmissionsCreateRoutingModule,
    ReactiveFormsModule, FormsModule
  ],
  exports: [AdmissionsCreateComponent],
})
export class AdmissionsCreateModule { }
