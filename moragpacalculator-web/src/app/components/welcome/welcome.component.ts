import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/data/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private router: Router,
    private AdmimService: AdminService) { }


  ngOnInit(): void {
  }
  getmoddefs() {
    this.AdmimService.getAllModuleDefinitions().subscribe(
      response => {
        console.log(response);
      })
  }
}
