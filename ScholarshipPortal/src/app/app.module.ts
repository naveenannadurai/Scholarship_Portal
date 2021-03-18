import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ParticlesModule } from 'angular-particle';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { StudentDashBoardComponent } from './components/student-dash-board/student-dash-board.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardnavComponent } from './components/dashboardnav/dashboardnav.component';
import { PersonalDetailsComponent } from './components/personal-details/personal-details.component';
import { ScholarshiplistComponent } from './components/scholarshiplist/scholarshiplist.component';
import { HistoryComponent } from './components/history/history.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { ScholarshipformComponent } from './components/scholarshipform/scholarshipform.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { AdmindashnavComponent } from './components/admindashnav/admindashnav.component';
import { StudentlistComponent } from './components/studentlist/studentlist.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminscholarshipComponent } from './components/adminscholarship/adminscholarship.component';
import { StudentdetailsComponent } from './components/studentdetails/studentdetails.component';
import { StudentsdetailsComponent } from './components/studentsdetails/studentsdetails.component';
import { ForgetComponent } from './components/forget/forget.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    StudentDashBoardComponent,
    FooterComponent,
    HomeComponent,
    RegisterComponent,
    AboutusComponent,
    LoginComponent,
    DashboardnavComponent,
    PersonalDetailsComponent,
    ScholarshiplistComponent,
    HistoryComponent,
    AdminLoginComponent,
    ScholarshipformComponent,
    AdmindashboardComponent,
    AdmindashnavComponent,
    StudentlistComponent,
    AdminscholarshipComponent,
    StudentdetailsComponent,
    StudentsdetailsComponent,
    ForgetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ParticlesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
