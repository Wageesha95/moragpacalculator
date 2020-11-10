import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Module } from '../data-models/Module';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private unenrolledEelectiveModuleArray = new Subject<Array<Module>>();
  latestUnenrolledEelectiveModuleArray = this.unenrolledEelectiveModuleArray.asObservable();

  constructor() { }

  updateUnenrolledEelectiveModuleArray(newArray: Module[]) {
    this.unenrolledEelectiveModuleArray.next(newArray);
  }

}