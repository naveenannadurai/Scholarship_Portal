import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Scholarshipstatus } from 'src/app/model/scholarship';
import { AdminService } from 'src/app/service/admin.service';
import { StudentService } from 'src/app/service/student.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-adminscholarship',
  templateUrl: './adminscholarship.component.html',
  styleUrls: ['./adminscholarship.component.css']
})
export class AdminscholarshipComponent implements OnInit {

  scholarship:any[];
  mySubscription: any;
  applicationno=sessionStorage.getItem("application");

  status = new Scholarshipstatus();

  constructor(private service:AdminService,public router: Router,private ser:StudentService) { }

  ngOnInit():void {
    this.service.getlist().subscribe(
      response => {
        this.scholarship=response;
      }
    )
  }
  delete(scholarid){
    this.service.delete(scholarid).subscribe(
      data=>{
        console.log(data);
        if(data.status=="SUCCESS"){
          Swal.fire(
            'Scholarship!',
            data.message,
            'success'
          )
          this.reloadComponent();
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

  reloadComponent() {
    let currentUrl = this.router.url;
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate([currentUrl]);
    }
}
