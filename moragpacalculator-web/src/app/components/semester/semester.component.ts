import { Component, OnInit, Input } from '@angular/core';
import { Semester } from 'src/app/data-models/Semester';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Module } from 'src/app/data-models/Module';
import { StudentService } from 'src/app/services/data/student.service';

@Component({
  selector: 'app-semester',
  templateUrl: './semester.component.html',
  styleUrls: ['./semester.component.css']
})
export class SemesterComponent implements OnInit {

  @Input('semester_value') theSemester: Semester;
  unenroledElectiveModuleArray: Module[];


  constructor(
    private modalService: NgbModal,
    private studentService: StudentService) { }


  ngOnInit(): void {
    this.getUnenrolledElectiveModules(this.theSemester.studentCategory.course, this.theSemester.userId);
  }

  calculateTotalSemesterCredits(semester: Semester) {
    let totalCredits: number = 0;
    semester.semesterModule.forEach(module => totalCredits += module.credit)
    return totalCredits;
  }

  semesterGPA(semester: Semester) {
    let TR: number = 0;
    let TC: number = 0;
    semester.semesterModule.filter((module) => module.enrollment == true && module.result != null).forEach((module) => { TR = TR + (module.credit * module.result), TC = TC + module.credit })
    return TR / TC;

  }



  openXl(content) {
    this.modalService.open(content, { size: 'xl' });
  }

  getUnenrolledElectiveModules(courseName, profileId) {

    this.studentService.getUnenrolledElectiveModules(courseName, profileId).subscribe(
      response => {
        this.unenroledElectiveModuleArray = response;
        console.log(this.unenroledElectiveModuleArray);
      })
  }

  removeEnrolledElectiveModuleFromSemester(moduleId: String, semesterId: String) {
    const updatedSemesterModuleArray = this.theSemester.semesterModule.filter((module) => module.id !== moduleId);
    const module = this.theSemester.semesterModule.filter((module) => module.id === moduleId);
    module[0].id = null
    module[0].enrollment = false
    module[0].result = null;
    this.unenroledElectiveModuleArray.push(module[0])
    this.theSemester.semesterModule = updatedSemesterModuleArray;
    this.studentService.removeEnrolledElectiveModuleFromSemester(moduleId, semesterId).subscribe(
      response => {
        console.log(response);
      }
    );
    console.log(this.unenroledElectiveModuleArray)
    console.log(this.theSemester.semesterModule)
  }

  unenrollCompulsoryModule(moduleId) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = false;
    this.studentService.updateStudentSemesterModule(thisModule).subscribe(
      response => {
        console.log(response);
      })
  }



  enrollCompulsoryModule(moduleId) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = true;
    this.studentService.updateStudentSemesterModule(thisModule).subscribe(
      response => {
        console.log(response);
      })
  }
}