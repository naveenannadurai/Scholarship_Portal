import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-studentsdetails',
  templateUrl: './studentsdetails.component.html',
  styleUrls: ['./studentsdetails.component.css']
})
export class StudentsdetailsComponent implements OnInit {

  list : any[];
  list1 : object;
  list2 : object;

  application = sessionStorage.getItem("application");

  constructor(private service : StudentService) { }

  ngOnInit():void {
    this.service.getstudentById(this.application).subscribe(
      data=>{
            this.list=data;
            this.list1=this.list[0];
            this.list2=this.list[1];
      }
    )

  }

}
