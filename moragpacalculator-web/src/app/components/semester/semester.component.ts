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
    private studentSevice: StudentService) { }

  ngOnInit(): void {
  }

  openXl(content) {
    this.modalService.open(content, { size: 'xl' });
  }

  unenrollCompulsoryModule(moduleId) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = false;
    this.studentSevice.updateStudentSemesterModule(thisModule).subscribe(
      response => {
        console.log(response);
      })
  }

  enrollCompulsoryModule(moduleId) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = true;
    this.studentSevice.updateStudentSemesterModule(thisModule).subscribe(
      response => {
        console.log(response);
      })
  }
}