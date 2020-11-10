import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Semester } from 'src/app/data-models/Semester';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Module } from 'src/app/data-models/Module';
import { StudentService } from 'src/app/services/data/student.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-semester',
  templateUrl: './semester.component.html',
  styleUrls: ['./semester.component.css']
})
export class SemesterComponent implements OnInit {

  @Input('semester_value') theSemester: Semester;
  @Output() cummulativeGPAEvent = new EventEmitter<Array<Number>>();
  @Output() getCummulativeValueGPAEvent = new EventEmitter<{ semesterNo: number, getCummulativeGPA: Function }>();
  @Output() addElectiveModuleEvent = new EventEmitter<{ moduleId: String }>();
  @Output() removeElectiveModuleEvent = new EventEmitter<any>();
  unenroledElectiveModuleArrayChild: Module[];


  constructor(
    private modalService: NgbModal,
    private studentService: StudentService,
    private data: DataService) { }


  ngOnInit(): void {
    this.data.latestUnenrolledEelectiveModuleArray.subscribe(updatedArray => this.unenroledElectiveModuleArrayChild = updatedArray);
  }

  calculateTotalSemesterCredits(semester: Semester) {
    let totalCredits: number = 0;
    semester.semesterModule.forEach(module => totalCredits += module.credit)
    return totalCredits;
  }

  public cummulativeGPA(semesterNo: number) {

    this.getCummulativeValueGPAEvent.emit({
      semesterNo: semesterNo,
      getCummulativeGPA: (result) => {
        this.theSemester.cumulativeGPA = result;
      }
    });
  }
  getCummulativeGPA(semester: Semester) {
    let TR: number = 0;
    let TC: number = 0;
    semester.semesterModule.filter((module) => module.enrollment == true && module.result != null).forEach((module) => { TR = TR + (module.credit * module.result), TC = TC + module.credit })

    var cummulativeGPAChild: number[] = [0, 0, 0];
    cummulativeGPAChild[0] = +semester.semesterNo;
    cummulativeGPAChild[1] = TC;
    cummulativeGPAChild[2] = TR;
    this.cummulativeGPAEvent.emit(cummulativeGPAChild);
  }

  semesterGPA(semester: Semester) {
    let TR: number = 0;
    let TC: number = 0;
    semester.semesterModule.filter((module) => module.enrollment == true && module.result != null).forEach((module) => { TR = TR + (module.credit * module.result), TC = TC + module.credit })
    this.theSemester.semesterGPA = TR / TC;
  }

  fixSemester(semester: Semester) {
    this.semesterGPA(semester)
    this.getCummulativeGPA(semester)
    this.cummulativeGPA(+semester.semesterNo)
  }

  openXl(content) {
    this.modalService.open(content, { size: 'xl' });
  }





  unenrollCompulsoryModule(moduleId) {
    //  if (this.theSemester.semesterModule.filter((module) => module.id === moduleId && module.result == null).length = 1) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = false;
    // } else {
    //make alert
    //  }
  }

  enrollCompulsoryModule(moduleId) {
    const thisModule = this.theSemester.semesterModule.find((module) => module.id === moduleId);
    thisModule.enrollment = true;
  }

  addElectiveModule(moduleCode: String) {
    var newModule = this.unenroledElectiveModuleArrayChild.find((module) => module.moduleCode === moduleCode);
    console.log(newModule)
    newModule.enrollment = true;
    this.theSemester.semesterModule.push(newModule);
    this.unenroledElectiveModuleArrayChild.splice(this.unenroledElectiveModuleArrayChild.findIndex((module) => module.moduleCode === moduleCode), 1);
    const updatedArray = this.unenroledElectiveModuleArrayChild;
    this.data.updateUnenrolledEelectiveModuleArray(updatedArray);
  }

  removeEnrolledElectiveModuleFromSemester(moduleCode: String) {
    const updatedSemesterModuleArray = this.theSemester.semesterModule.filter((module) => module.moduleCode !== moduleCode);
    var module = this.theSemester.semesterModule.filter((module) => module.moduleCode === moduleCode);
    module[0].id = null
    module[0].enrollment = false
    module[0].result = null;
    this.unenroledElectiveModuleArrayChild.push(module[0]);
    const updatedArray: Module[] = this.unenroledElectiveModuleArrayChild;
    this.data.updateUnenrolledEelectiveModuleArray(updatedArray);
    this.theSemester.semesterModule = updatedSemesterModuleArray;
  }
}


