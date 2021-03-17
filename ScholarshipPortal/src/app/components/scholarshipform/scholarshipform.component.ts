import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Scholarship } from 'src/app/model/scholarship';
import { AdminService } from 'src/app/service/admin.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-scholarshipform',
  templateUrl: './scholarshipform.component.html',
  styleUrls: ['./scholarshipform.component.css']
})
export class ScholarshipformComponent implements OnInit {

  name:any;
  description:any;
  provider:any;
  amount:any;
  requirements:any;

  scholar = new Scholarship();

  constructor(private service:AdminService) { }

  ngOnInit():void {

    }

    register(Form :NgForm){

      this.scholar.name=this.name;
      this.scholar.description=this.description;
      this.scholar.provider=this.provider;
      this.scholar.amount=this.amount;
      this.scholar.requirements=this.requirements;

      this.service.registerscholar(this.scholar).subscribe(
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
          window.location.href="admindash/sslist";
},1500);
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
