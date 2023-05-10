import { Injectable } from '@angular/core';
import { InputModel } from 'src/app/model/InputModel';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  
  constructor(private http : HttpClient) { }

  baseUrl : string = 'http://localhost:8080/home/';

  eval(value : string) {
    console.log(value)
    this.http.post(this.baseUrl + 'calc',value)
    .subscribe(response => console.log(response));
  }
}
