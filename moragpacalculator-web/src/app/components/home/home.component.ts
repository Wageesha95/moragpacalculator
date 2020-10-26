import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {StudentService} from "../../services/data/student.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profileId="5f7d2f5406d4835ca1b9c955";

  constructor(private router: Router,
    private StudentService:StudentService) { }

  ngOnInit(): void {
  }

  getStudent(profileId:String) {
    this.StudentService.getStudentByProfileId(profileId).subscribe(
      response => {
        console.log(response);
      })
  }

}
