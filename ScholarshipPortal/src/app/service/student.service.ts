import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  baseUrl='http://localhost:8765/student/';

  registerStudent(student : object):Observable<any>{
    // alert(JSON.stringify(student))
    return this.http.post(this.baseUrl+'registerStudent',student);
  }

  loginStudent(student : object):Observable<any>{
    return this.http.post(this.baseUrl+'studentLogin',student);
  }

  registerDetails(student:object,accountNo:number):Observable<any>{
    return this.http.post(this.baseUrl+'registerDetails/'+accountNo,student);
  }

  getlist():Observable<any>{
    return this.http.get(this.baseUrl+'getstudentList');
  }

  apply(nxt:object):Observable<any>{
    return this.http.post(this.baseUrl+'setStatus',nxt);
  }

  getstatus(accountNo:any):Observable<any>{
    return this.http.get(this.baseUrl+'getStatus/'+accountNo);
  }

  approve(status:object):Observable<any>{
    return this.http.put(this.baseUrl+'approve',status);
  }

  reject(status:object):Observable<any>{
    return this.http.put(this.baseUrl+'reject',status);
  }

  getstudentById(application:any):Observable<any>{
    return this.http.get(this.baseUrl+'getstudent/'+application)
  }

  forgot(student:object):Observable<any>{
    return this.http.post(this.baseUrl+'forgot',student);
  }

}
