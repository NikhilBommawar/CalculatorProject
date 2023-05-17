import { Component, ViewChild } from '@angular/core';
import { InputModel } from 'src/app/model/InputModel';
import { BackendService } from 'src/app/service/backend/backend.service';
import { CalcService } from 'src/app/service/calc.service';

@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css'],
  providers:[CalcService,BackendService]
})
export class CalcComponent {
  
 constructor(private backend : BackendService){}
 
  value : string = "0";

  setDisplay(value: string) {
    
   this.value = value;
  }

  getDisplay(){
    console.log("getDisplay"+this.value)
   return this.value;
  }

  evaluate(stack : any) : any{
    const _this  = this;
     this.backend.eval(stack).subscribe((response: any)  =>{
      _this.value = response;
      _this.setDisplay(_this.value);
   });
    
    } 

 }


