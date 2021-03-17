import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Scholarshipstatus } from 'src/app/model/scholarship';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrls: ['./studentlist.component.css']
})
export class StudentlistComponent implements OnInit {

  list : any[];

  status = new Scholarshipstatus();
  constructor(private service : StudentService,private router:Router) { }

  ngOnInit():void {
    this.service.getlist().subscribe(
      data=>{
        this.list=data;
      }
    )
  }

  approve(application,scholar){
    this.status.applicationNumber=application;
    this.status.scholarshipId=scholar;
    this.service.approve(this.status).subscribe(
      data=>{
        Swal.fire(
          'Approved!',
          'Student scholarship Successfully approved!',
          'success'
        )
        
    this.reloadComponent();
      }
    )
  }

  reject(application,scholar){
    this.status.applicationNumber=application;
    this.status.scholarshipId=scholar;
    this.service.reject(this.status).subscribe(
      data=>{
        Swal.fire(
          'Rejected!',
          'Student scholarship Successfully Rejected!',
          'error'
        )
        
    this.reloadComponent();
      }
    )
  }

  view(application){
    sessionStorage.setItem("number",application);
    window.location.href="admindash/stulist";
  }

  reloadComponent() {
    let currentUrl = this.router.url;
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate([currentUrl]);
    }

}
