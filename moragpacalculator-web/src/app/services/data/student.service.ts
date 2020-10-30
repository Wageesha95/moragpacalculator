import { Injectable } from '@angular/core';
import { Student } from "../../data-models/Student";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Module } from 'src/app/data-models/Module';

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

  getUnenrolledElectiveModules(courseName, profileId) {
    let params = new HttpParams();
    params = params.append('courseName', courseName);
    params = params.append('profileId', profileId);
    return this.http.get<Array<Module>>(`http://localhost:8081/unenrolled-elective-modules`, { params: params });
  }

  // updateStudentSemester(profileId) {
  //   let params = new HttpParams();
  //   params = params.append('profileId', profileId);
  //   return this.http.get<Student>(`http://localhost:8081/student`, { params: params });
  // }

  updateStudentSemesterModule(module: Module) {
    return this.http.put<Module>(`http://localhost:8081/module`, module);
  }
}
