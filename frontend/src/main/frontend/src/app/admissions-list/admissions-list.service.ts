import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admissions } from '../shared/model/admissions';

@Injectable({
  providedIn: 'root'
})
export class AdmissionsListService {

  private baseUrl = "http://localhost:8080/api/admissions";

  constructor(private httpClient: HttpClient) { }


  getAdmissionsList():Observable<any>{

    return this.httpClient.get(this.baseUrl + '/getAllAdmissions');

  }

  deleteAdmissionItem(id):Observable<any>{

    return this.httpClient.delete(this.baseUrl + "/deleteAdmission?id="+id);

  }


  getCategories():Observable<any>{

    return this.httpClient.get(this.baseUrl + '/getCategories');

  }

  createAdmission(admission: Admissions):Observable<any>{

    return this.httpClient.post(this.baseUrl + '/createAdmission', admission);

  }


}
