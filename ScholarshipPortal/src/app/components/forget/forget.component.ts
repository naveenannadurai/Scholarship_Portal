import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Admin } from 'src/app/model/admin';
import { Student } from 'src/app/model/student';
import { AdminService } from 'src/app/service/admin.service';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent implements OnInit {

  emailId:string;
  emailId1:string;

  admin = new Admin();
  student= new Student();
  constructor(private adser:AdminService,private stser:StudentService) { }

  ngOnInit() {
  }

  alogin(Form : NgForm){
    this.admin.email=this.emailId;

    this.adser.forgot(this.admin).subscribe(
      data=>{
        console.log(data);
        if(data.status=="SUCCESS"){
          Swal.fire(
            data.message,
            data.name,
            'success'
          )
        }
        else{
          Swal.fire(
            'Sorry!',
            data.message,
            'error'
          )
        }
      }
    )
  }

  slogin(Form : NgForm){
    this.student.email=this.emailId1;

    this.stser.forgot(this.student).subscribe(
      report=>{
        console.log(report);
        if(report.status=="SUCCESS"){
          Swal.fire(
            report.message,
            report.name,
            'success'
          )
        }
        else{
          Swal.fire(
            'Sorry!',
            report.message,
            'error'
          )
        }
      }
    )
  }
}
