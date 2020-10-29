import { Component, OnInit, Input } from '@angular/core';
import { Semester } from 'src/app/data-models/Semester';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Module } from 'src/app/data-models/Module';


@Component({
  selector: 'app-semester',
  templateUrl: './semester.component.html',
  styleUrls: ['./semester.component.css']
})
export class SemesterComponent implements OnInit {

  @Input('semester_value') theSemester: Semester;
  unenroledElectiveModuleArray: Module[];

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  openXl(content) {
    this.modalService.open(content, { size: 'xl' });
  }


}