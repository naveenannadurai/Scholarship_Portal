import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  history : any[];

  applicationno=sessionStorage.getItem("application");

  constructor(private service : StudentService,private router:Router) {
   }

  ngOnInit():void {
    this.service.getstatus(this.applicationno).subscribe(
      response => {
        this.history=response;
      }
    )

this.reloadComponent

  }
  reloadComponent() {
    let currentUrl = this.router.url;
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigate([currentUrl]);
    }

}
