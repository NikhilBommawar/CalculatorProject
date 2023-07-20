import { Injectable } from '@angular/core';

import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';
// import { InputModel } from 'src/app/model/InputModel';

@Injectable({
  providedIn: 'root'
})



export class BackendService {
  
  constructor(private http : HttpClient) { }

  

  readonly httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'Authorization':'authkey',
      'userid':'1'
    })
  };


  baseUrl : string = 'http://localhost:8080/SecurityDemo4/';

  eval(stack : any) : any{
    
  let username='nikhil'
  let password='nikhil'

  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password)});

    console.log("stack in backend eval", stack ) 
    console.log(JSON.stringify(stack))
    return  this.http.post(this.baseUrl + 'calc',JSON.stringify(stack),{headers});
  }
 }

 




