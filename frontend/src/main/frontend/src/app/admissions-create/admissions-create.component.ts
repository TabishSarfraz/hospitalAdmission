import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Admissions } from '../shared/model/admissions';
import { AdmissionsListService } from '../admissions-list/admissions-list.service';
import { Category } from '../shared/model/category';
import { Patient } from '../shared/model/patient';

@Component({
  selector: 'app-admissions-create',
  templateUrl: './admissions-create.component.html',
  styleUrls: ['./admissions-create.component.css']
})
export class AdmissionsCreateComponent implements OnInit {

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
      this.admission.id = null;
      this.admission.dateAdmission = null;
      this.admission.externalID = null;

      this.admission.category = this.categorySelected;
      this.admission.patient = this.patientCreated;

      console.log('form submission');
      console.log(this.admission);

      this.error = false;

      this.admissionListService.createAdmission(this.admission).subscribe(
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


}
