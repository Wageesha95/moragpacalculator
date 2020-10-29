import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from "../../services/data/student.service";
import { Student } from "../../data-models/Student";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profileId = "5f985cfa91ea123cba02beba";
  theStudent: Student;

  constructor(private router: Router,
    private StudentService: StudentService) { }

  ngOnInit(): void {
  }

  getStudent(profileId: String) {
    this.StudentService.getStudentByProfileId(profileId).subscribe(
      response => {
        this.theStudent = response;
        console.log(response);
      })
  }

  getAllCourseModuleDefinitions

}
