import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { AdminscholarshipComponent } from './components/adminscholarship/adminscholarship.component';
import { ForgetComponent } from './components/forget/forget.component';
import { HistoryComponent } from './components/history/history.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PersonalDetailsComponent } from './components/personal-details/personal-details.component';
import { RegisterComponent } from './components/register/register.component';
import { ScholarshipformComponent } from './components/scholarshipform/scholarshipform.component';
import { ScholarshiplistComponent } from './components/scholarshiplist/scholarshiplist.component';
import { StudentDashBoardComponent } from './components/student-dash-board/student-dash-board.component';
import { StudentdetailsComponent } from './components/studentdetails/studentdetails.component';
import { StudentlistComponent } from './components/studentlist/studentlist.component';
import { StudentsdetailsComponent } from './components/studentsdetails/studentsdetails.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'adminlogin',component:AdminLoginComponent},
  {path:'about',component:AboutusComponent},
  {path:'forgot',component:ForgetComponent},
  {path:'register',component:RegisterComponent},
  {
    path:'dash',
    component:StudentDashBoardComponent,
    children:[
      {path:'personal',component:PersonalDetailsComponent},
      {path:'list',component:ScholarshiplistComponent},
      {path:'stlist',component:StudentsdetailsComponent},
      {path:'history',component:HistoryComponent}

    ]
  },
  {
    path:'admindash',
    component:AdmindashboardComponent,
    children:[
      {path:'form',component:ScholarshipformComponent},
      {path:'slist',component:StudentlistComponent},
      {path:'sslist',component:AdminscholarshipComponent},
      {path:'stulist',component:StudentdetailsComponent}
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
