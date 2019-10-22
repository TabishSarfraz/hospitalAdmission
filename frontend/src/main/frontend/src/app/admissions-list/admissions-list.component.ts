import { Component, OnInit, Input, Output } from '@angular/core';
import { AdmissionsListService } from './admissions-list.service';
import { Observable } from 'rxjs';
import { Admissions } from '../shared/model/admissions';
import { Router, ActivatedRoute } from '@angular/router';
import { $ } from 'protractor';

@Component({
  selector: 'app-admissions-list',
  templateUrl: './admissions-list.component.html',
  styleUrls: ['./admissions-list.component.css']
})
export class AdmissionsListComponent implements OnInit {
  admissionsList: Array<Admissions> = [];
   private admissionItemSelected: Admissions = new Admissions();
   admissionItemSelectedOutPut: Admissions;




  constructor(private admissionListService: AdmissionsListService, private router: Router,
    private route: ActivatedRoute) {}

  ngOnInit() {

    this.route.params.subscribe( params =>{
      let id = +params['id'];
    });

    this.admissionListService.getAdmissionsList().subscribe(
      data =>{

      this.admissionsList = data;

    }, error => {
      console.log(error)
    });




  }

  deleteAdmission(id: number){

    this.admissionListService.deleteAdmissionItem(id).subscribe(
      data => {
        console.log("deleted"+ id);
        this.ngOnInit();

      }, error => {
        console.log(error);
      }
    )

  }


  deleteSelectedAdmission(){

    this.deleteAdmission(this.admissionItemSelected.id);


  }

  setDynamicValue(admissionItem: Admissions){

    this.admissionItemSelected = admissionItem;

  }





 

}
