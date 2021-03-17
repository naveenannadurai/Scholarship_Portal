import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Admin } from 'src/app/model/admin';
import { AdminService } from 'src/app/service/admin.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  emailId:string;
  pass:string;
  name:any;
  contact:any;

  admin = new Admin();

  constructor(private registerService:AdminService) { }

  ngOnInit():void {
  }

  login(Form : NgForm){
    this.admin.email=this.emailId;
    this.admin.password=this.pass;

    this.registerService.loginStudent(this.admin).subscribe(
      data=>{console.log(data);
        if(data.status=="SUCCESS"){
          Swal.fire(
            'Login!',
            data.message,
            'success'
          )
          setTimeout(() => 
{
          this.name=data.name;
          this.contact=data.contact;
          sessionStorage.setItem("adminName",this.name);
          sessionStorage.setItem("contact",this.contact);
          window.location.href="/admindash/form";
},2000);
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
}
