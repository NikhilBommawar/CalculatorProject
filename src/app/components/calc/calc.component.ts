import { Component } from '@angular/core';
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

  evaluate(value : string) {
    this.backend.eval(value).subscribe((response: any)  => this.value = response);
    // this.backend.eval2(value);
    } 

    
  }


