import { Injectable } from '@angular/core';

import { HttpClient , HttpHeaders } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';

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

  eval(value : string) : any{
    console.log(value)
   return  this.http.post(this.baseUrl + 'calc',value);
  }

  eval2(value2 : string) : any {
    console.log(this.httpOptions)
     return this.http.post(this.baseUrl + 'calc', value2, this.httpOptions);
      // .pipe(
      //   tap((result) => console.log('result-->',result))
      //   // catchError(this.handleError('error', []))
      // );
  }

  // handleError(arg0: string, arg1: never[]): any {
  //  console.log('hiiiiiii');
  // }



  }


