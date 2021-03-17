import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Scholarshipstatus } from 'src/app/model/scholarship';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-scholarshiplist',
  templateUrl: './scholarshiplist.component.html',
  styleUrls: ['./scholarshiplist.component.css']
})
export class ScholarshiplistComponent implements OnInit {
  scholarship:any[];

  applicationno=sessionStorage.getItem("application");

  status = new Scholarshipstatus();

  constructor(private service:AdminService,public actRoute: ActivatedRoute,private ser:StudentService) { }

  ngOnInit():void {
    this.service.getlist().subscribe(
      response => {
        this.scholarship=response;
      }
    )
  }

  apply(scholarshipid)
  {
    this.status.applicationNumber=this.applicationno;
    this.status.scholarshipId=scholarshipid;

    this.ser.apply(this.status).subscribe(
      data=>{
        console.log(data);
        if(data.status=="SUCCESS"){
          Swal.fire(
            'Success!',
            data.message,
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

}
