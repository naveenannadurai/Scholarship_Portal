import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindashnav',
  templateUrl: './admindashnav.component.html',
  styleUrls: ['./admindashnav.component.css']
})
export class AdmindashnavComponent implements OnInit {


  name:any;
  contact:any;

  constructor(private router:Router,private locationStrategy:LocationStrategy) { }

  ngOnInit():void {
    this.name=sessionStorage.getItem("adminName");
    this.contact=sessionStorage.getItem("contact");
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
