import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmissionsUpdateRoutingModule } from './admissions-update-routing.module';
import { AdmissionsUpdateComponent } from './admissions-update.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [AdmissionsUpdateComponent],
  imports: [
    CommonModule,
    AdmissionsUpdateRoutingModule,
    ReactiveFormsModule, FormsModule
  ],
  exports: [AdmissionsUpdateComponent],
})
export class AdmissionsUpdateModule { }
