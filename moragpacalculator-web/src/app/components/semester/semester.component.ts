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
    this.theSemester.semesterModule.find((module) => module.id === moduleId, [0]).enrollment = false;
    this.studentSevice.updateStudentSemesterModule(module[0]);
  }

  enrollCompulsoryModule(moduleId) {
    this.theSemester.semesterModule.find((module) => module.id === moduleId, [0]).enrollment = true;
    this.studentSevice.updateStudentSemesterModule(module[0]);
  }
}