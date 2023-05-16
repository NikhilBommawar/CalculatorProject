import { Injectable } from '@angular/core';

import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';
import { InputModel } from 'src/app/model/InputModel';

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


  baseUrl : string = 'http://localhost:8080/home/';

  eval(stack : any) : any{
    console.log("stack in backend eval", stack ) 
    console.log(JSON.stringify(stack))
   return  this.http.post(this.baseUrl + 'calc',JSON.stringify(stack));
  }

 
  }

  // handleError(arg0: string, arg1: never[]): any {
  //  console.log('hiiiiiii');
  // }




