import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailId:string;
  pass:string;
  fname:any;
  sname:any;
  appl:any;
  regstudent = new Student();

  constructor(private registerService:StudentService) { }

  ngOnInit():void {
  }

  login(Form:NgForm){
    this.regstudent.email=this.emailId;
    this.regstudent.password=this.pass;

    this.registerService.loginStudent(this.regstudent).subscribe(
      data=>{
        console.log(data);
        if(data.status=="SUCCESS"){
          Swal.fire(
            'Login!',
            data.message,
            'success'
          )
          setTimeout(() => 
{
          this.fname=data.studentFname;
          this.sname=data.studentLname;
          this.appl=data.applicationNumber;
           sessionStorage.setItem("firstName",this.fname);
           sessionStorage.setItem("lastName",this.sname);
           sessionStorage.setItem("application",this.appl);
          window.location.href="/dash/personal";
},3000);
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
