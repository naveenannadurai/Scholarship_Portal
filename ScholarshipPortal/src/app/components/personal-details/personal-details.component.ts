import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentDetails } from 'src/app/model/student-details';
import { StudentService } from 'src/app/service/student.service';

import Swal from 'sweetalert2'


@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {

  rollno:number;
  institute:string;
  course:string;
  year:number;
  mode:string;
  cgpa:number;

  
  religion:string;
  community:string;
  Accomodation:string;
  aadhar_no:number;
  phone:number;
  monthincome:number;

  father:string;
  mother:string;

  sslcboard:string;
  sslcperc:number;
  sslcyear:number;
  sslcrollno:number;
  
  
  hscboard:string;
  hscperc:number;
  hscyear:number;
  hscroll:number;
  
  orphan:string;
  dis:string;
  disper:number;
  Maritial:string;
  
  Profession:string;
  ifsc:number;
  account:number;

  applicationNo:any;

  studentdet = new StudentDetails();

  constructor(private registerService:StudentService) { }

  ngOnInit():void {
  }

  register(Form:NgForm){
    
    
    this.studentdet.rollNo = this.rollno;
    this.studentdet.institute = this.institute;
    this.studentdet.course = this.course;
    this.studentdet.year = this.year;
    this.studentdet.modeOfStudy = this.mode;
    this.studentdet.cgpa = this.cgpa;
    this.studentdet.religion = this.religion;
    this.studentdet.community = this.community;
    this.studentdet.stay = this.Accomodation;
    this.studentdet.aadhar = this.aadhar_no;
    this.studentdet.phone = this.phone;
    this.studentdet.income = this.monthincome;
    this.studentdet.fatherName = this.father;
    this.studentdet.motherName = this.mother;
    this.studentdet.sslcExamName = this.sslcboard;
    this.studentdet.sslcPercentage = this.sslcperc;
    this.studentdet.sslcPassingYear = this.sslcyear;
    this.studentdet.sslcRollno = this.sslcrollno;
    this.studentdet.hscExamName = this.hscboard;
    this.studentdet.hscPercentage = this.hscperc;
    this.studentdet.hscPassingYear = this.hscyear;
    this.studentdet.hscRollno = this.hscroll;
    this.studentdet.isOrphan = this.orphan;
    this.studentdet.isDisabled = this.dis;
    this.studentdet.disabledpercentage = this.disper;
    this.studentdet.maritalStatus = this.Maritial;
    this.studentdet.parentProfession = this.Profession;
    this.studentdet.ifsc = this.ifsc;
    this.studentdet.accountNumber = this.account; 
    
    this.applicationNo=sessionStorage.getItem("application");

    this.registerService.registerDetails(this.studentdet,this.applicationNo).subscribe(
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
          window.location.href="/dash/list";
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
