import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboardnav',
  templateUrl: './dashboardnav.component.html',
  styleUrls: ['./dashboardnav.component.css']
})
export class DashboardnavComponent implements OnInit {

  fname:any;
  sname:any;

  constructor(private router:Router,private locationStrategy:LocationStrategy) { }
  
  ngOnInit():void {
    this.fname=sessionStorage.getItem("firstName");
    this.sname=sessionStorage.getItem("lastName");
}

Logout()
  {
    sessionStorage.clear()
    
    history.pushState(null, null, location.href);
    this.locationStrategy.onPopState(() => {
    history.pushState(null, null, location.href);
    this.router.navigate(['/']); 
    })
    this.router.navigate(['/']); 
    

  }
}
