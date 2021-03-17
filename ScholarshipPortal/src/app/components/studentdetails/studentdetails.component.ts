import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-studentdetails',
  templateUrl: './studentdetails.component.html',
  styleUrls: ['./studentdetails.component.css']
})
export class StudentdetailsComponent implements OnInit {

  list : any[];
  list1 : object;
  list2 : object;

  application = sessionStorage.getItem("number");

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
