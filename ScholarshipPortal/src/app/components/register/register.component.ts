import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstName:string;
  lastname:string;
  gender:string;
  DOB:Date;
  emailId:string;
  city:string;
  state:string;
  country:string;
  pincode:number;
  pass:string;
  status;


  regstudent = new Student();

  constructor(private registerService:StudentService) { }

  ngOnInit():void {
  }
  register(Form : NgForm)
  {
    this.regstudent.firstName=this.firstName;
    this.regstudent.lastName=this.lastname;
    this.regstudent.gender=this.gender;
    this.regstudent.birth=this.DOB;
    this.regstudent.email=this.emailId;
    this.regstudent.city=this.city;
    this.regstudent.state=this.state;
    this.regstudent.country=this.country;
    this.regstudent.pincode=this.pincode;
    this.regstudent.password=this.pass;

    this.registerService.registerStudent(this.regstudent).subscribe(
      data=>{
        console.log(data);
        
        if(data.status=="SUCCESS"){
          Swal.fire(
            'Done!',
            data.message,
            'success'
          )
          setTimeout(() => 
{
          window.location.href="/login";
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
