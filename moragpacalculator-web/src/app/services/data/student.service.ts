import { Injectable } from '@angular/core';
import { Student } from "../../data-models/Student";
import { HttpClient, HttpParams } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(
    private http: HttpClient
  ) { }



  getStudentByProfileId(profileId) {
    let params = new HttpParams();
    params = params.append('profileId', profileId);
    return this.http.get<Student>(`http://localhost:8081/student`, { params: params });
  }

}
