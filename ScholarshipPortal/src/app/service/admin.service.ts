import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  baseUrl='http://localhost:8765/admin/';

  getlist():Observable<any>{
    return this.http.get(this.baseUrl+'getScholarshipList');
  }

  loginStudent(admin : object):Observable<any>{
    return this.http.post(this.baseUrl+'adminLogin',admin);
  }

  registerscholar(scholar:object):Observable<any>{
    return this.http.post(this.baseUrl+'registerScholarship',scholar);
  }

  delete(scholarid:number):Observable<any>{
    return this.http.delete(this.baseUrl+'delete/'+scholarid);
  }

  forgot(admin:object):Observable<any>{
    return this.http.post(this.baseUrl+'forgot',admin);
  }
}
