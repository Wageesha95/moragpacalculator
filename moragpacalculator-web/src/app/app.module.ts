import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { MaterialModule } from './modules/material/material.module';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SemesterComponent } from './components/semester/semester.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminService } from './services/data/admin.service';
import {StudentService} from "./services/data/student.service";
import { AdminComponent } from './components/admin/admin.component';
import { ErrorComponent } from './components/error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    HomeComponent,
    LoginComponent,
    SemesterComponent,
    AdminComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule
  ],
  providers: [AdminService,StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
