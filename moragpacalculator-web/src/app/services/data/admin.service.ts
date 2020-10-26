import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ModuleDefinition } from "../../data-models/ModuleDefinition";


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }


  getAllModuleDefinitions() {
    return this.http.get<ModuleDefinition[]>(`http://localhost:8081/module-definitions`);
  }

}
