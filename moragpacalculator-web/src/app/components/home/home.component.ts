import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from "../../services/data/student.service";
import { Student } from "../../data-models/Student";
import { Module } from 'src/app/data-models/Module';
import { DataService } from 'src/app/services/data.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  profileId = "5f7d2f5406d4835ca1b9c955";
  //"5f985cfa91ea123cba02beba";
  theStudent: Student;

  cummulativeTC: number[] = [-1, -1, -1, -1, -1, -1, -1, -1];
  cummulativeTR: number[] = [-1, -1, -1, -1, -1, -1, -1, -1];
  unenroledElectiveModuleArrayParent: Module[];

  constructor(private router: Router,
    private studentService: StudentService,
    private data: DataService) { }

  ngOnInit(): void {
    this.data.latestUnenrolledEelectiveModuleArray.subscribe(updatedArray => this.unenroledElectiveModuleArrayParent = updatedArray);
  }

  getStudent(profileId: String) {
    this.studentService.getStudentByProfileId(profileId).subscribe(
      response => {
        console.log(response);
        this.theStudent = response;
        //need to modifi with after execution
        this.getUnenrolledElectiveModules(this.theStudent.studentCategory.course, this.theStudent.userProfile.id);
      })
  }

  getUnenrolledElectiveModules(courseName, profileId) {
    this.studentService.getUnenrolledElectiveModules(courseName, profileId).subscribe(
      response => {
        var updatedUnenroledElectiveModuleArray: Module[] = response;
        this.data.updateUnenrolledEelectiveModuleArray(updatedUnenroledElectiveModuleArray);
      })
  }

  reciveCummulativeGPAEvent($event) {
    const cummulativeGPAParent: number[] = $event;
    const childSemesterNo: number = cummulativeGPAParent[0];
    const childCummulativeTC: number = cummulativeGPAParent[1];
    const childCummulativeTR: number = cummulativeGPAParent[2];

    console.log(childSemesterNo)

    let count = 0;
    if (!(childSemesterNo == 1)) {

      for (let i = 0; i < childSemesterNo - 1; i++) {
        if (this.cummulativeTR[i] == -1) {
          count = -2;
          console.log(count)
          break;
        }
      }

    }

    if (!(count == -2)) {
      switch (childSemesterNo) {
        case 1: {
          this.cummulativeTC[0] = childCummulativeTC;
          this.cummulativeTR[0] = childCummulativeTR
          break;
        }
        case 2: {
          this.cummulativeTC[1] = this.cummulativeTC[0] + childCummulativeTC;
          this.cummulativeTR[1] = this.cummulativeTR[0] + childCummulativeTR;
          break;
        }
        case 3: {
          this.cummulativeTC[2] = this.cummulativeTC[1] + childCummulativeTC;
          this.cummulativeTR[2] = this.cummulativeTR[1] + childCummulativeTR;
          break;
        }
        case 4: {
          this.cummulativeTC[3] = this.cummulativeTC[2] + childCummulativeTC;
          this.cummulativeTR[3] = this.cummulativeTR[2] + childCummulativeTR;
          break;
        }
        case 5: {
          this.cummulativeTC[4] = this.cummulativeTC[3] + childCummulativeTC;
          this.cummulativeTR[4] = this.cummulativeTR[3] + childCummulativeTR;
          break;
        }
        case 6: {
          this.cummulativeTC[5] = this.cummulativeTC[4] + childCummulativeTC;
          this.cummulativeTR[5] = this.cummulativeTR[4] + childCummulativeTR;
          break;
        }
        case 7: {
          this.cummulativeTC[6] = this.cummulativeTC[5] + childCummulativeTC;
          this.cummulativeTR[6] = this.cummulativeTR[5] + childCummulativeTR;
          break;
        }
        case 8: {
          this.cummulativeTC[7] = this.cummulativeTC[6] + childCummulativeTC;
          this.cummulativeTR[7] = this.cummulativeTR[6] + childCummulativeTR;
          break;
        }
      }
    }
  }

  sendCummulativeGPAValue(semesterNo, getCummulativeGPA) {
    console.log(this.cummulativeTC);
    console.log(this.cummulativeTR);
    console.log(semesterNo);
    let count = 0;
    for (let i = 0; i < semesterNo; i++) {
      if (this.cummulativeTR[i] == -1 || this.cummulativeTR[i] == NaN) {
        count = -2;
        break;
      }
    }
    if (count == -2) {
      getCummulativeGPA(0);
    } else {
      if (semesterNo == 6) {//--Should be changed with adding property to identify training semester
        getCummulativeGPA(0);
      } else {
        console.log(this.cummulativeTR[semesterNo - 1] + " " + this.cummulativeTC[semesterNo - 1])
        getCummulativeGPA(this.cummulativeTR[semesterNo - 1] / this.cummulativeTC[semesterNo - 1]);
      }
    }
  }
}