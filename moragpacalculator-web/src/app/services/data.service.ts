import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Module } from '../data-models/Module';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private unenrolledEelectiveModuleArray = new Subject<Array<Module>>();
  latestUnenrolledEelectiveModuleArray = this.unenrolledEelectiveModuleArray.asObservable();

  private cummulativeTC = new Subject<Array<Number>>();
  private cummulativeTR = new Subject<Array<Number>>();
  latestcummulativeTCArray = this.cummulativeTC.asObservable();
  latestcummulativeTRArray = this.cummulativeTR.asObservable();


  constructor() { }

  updateUnenrolledEelectiveModuleArray(newArray: Module[]) {
    this.unenrolledEelectiveModuleArray.next(newArray);
  }

  updatCummulativeTCArray(newArray: Number[]) {
    this.cummulativeTC.next(newArray);
  }

  updateCummulativeTRArray(newArray: Number[]) {
    this.cummulativeTR.next(newArray);
  }


} 