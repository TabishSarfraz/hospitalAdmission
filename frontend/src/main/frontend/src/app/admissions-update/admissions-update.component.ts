import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Admissions } from '../shared/model/admissions';
import { AdmissionsListService } from '../admissions-list/admissions-list.service';
import { Category } from '../shared/model/category';
import { Patient } from '../shared/model/patient';

@Component({
  selector: 'app-admissions-update',
  templateUrl: './admissions-update.component.html',
  styleUrls: ['./admissions-update.component.css']
})
export class AdmissionsUpdateComponent implements OnInit {

  categoryForm: FormGroup;
  paramSub: Subscription;
  admission: Admissions;
  categoryList: Array<Category> ;
  submitted: boolean = false;
  error: boolean = true;
  errorDate: boolean = false;

  currentDate: Date = new Date();

  categorySelected: Category = new Category();
  patientCreated: Patient = new Patient();

  disableCat: boolean = false;

  constructor(private _formBuilder: FormBuilder,
    private _route: ActivatedRoute,
    private _router: Router, private admissionListService: AdmissionsListService) {
      this.categoryForm = _formBuilder.group({
        firstName: ['', [Validators.required]],
        lastName: ['', [Validators.required]],
        birthDate: ['', [Validators.required]],
        genderForm: ['', [Validators.required]],
        catForm: ['', [Validators.required]],

      });
      
      this.admission = new Admissions();

     }

  ngOnInit() {

    this.paramSub = this._route.params.subscribe(
      params => {
          if(params.id){
              this.admission.id = params.id;
              this.getAdmission(this.admission.id);
          }
      }
    )

    this.admissionListService.getCategories().subscribe(
      data =>{

      this.categoryList = data;

    }, error => {
      console.log(error)
    });

  }

  formSubmission(){


      this.errorDate = false;
      this.submitted = true;
      this.categorySelected.name = this.categoryForm.value.catForm;
      this.patientCreated.firstName = this.categoryForm.value.firstName;
      this.patientCreated.lastName = this.categoryForm.value.lastName;
      this.patientCreated.gender = this.categoryForm.value.genderForm;
      this.patientCreated.dateBirth = this.categoryForm.value.birthDate;

      this.categorySelected.id = null;
      this.admission.id = this.admission.id;
      this.admission.dateAdmission = this.admission.dateAdmission;
      this.admission.externalID = this.admission.externalID;

      this.admission.category = this.categorySelected;
      this.admission.patient = this.patientCreated;

      console.log('form submission');
      console.log(this.admission);

      this.admissionListService.updateAdmission(this.admission).subscribe(
        data =>{

          this.error = false;

      }, error => {

        this.error = true;
        console.log(error);

      });

 

  }

  returnHome(){

    this._router.navigate(['home']);

  }

  validateDateCheck(){

    let d1 = new Date(this.categoryForm.value.birthDate);
    let d2 = this.currentDate;

    if( d1.getDate() > d2.getDate() || d1.getMonth() > d2.getMonth() ||  d1.getFullYear() > d2.getFullYear() ){

      this.errorDate = true;
  

    }else{
      this.errorDate = false;
    }

  }


  getAdmission(id: number){

    this.admissionListService.getAdmissionItem(id).subscribe(
      data => {
        console.log("get"+ id);
        this.admission = data;
        console.log(this.admission);

        this.categoryForm.controls.genderForm.patchValue(this.admission.patient.gender);
        this.categoryForm.controls.firstName.patchValue(this.admission.patient.firstName);
        this.categoryForm.controls.lastName.patchValue(this.admission.patient.lastName);
        this.categoryForm.controls.birthDate.patchValue(this.admission.patient.dateBirth);
        this.categoryForm.controls.catForm.patchValue(this.admission.category.name);

        this.categoryForm.updateValueAndValidity();

      }, error => {
        console.log(error);
      }
    )

  }



}
