import { Injectable } from '@angular/core';
import { CalcComponent } from '../components/calc/calc.component';
import { InputModel } from '../model/InputModel';


@Injectable({
  providedIn: 'root'
})

export class CalcService {

  value: string = '';
  num !: number;
  constructor(private calcComp: CalcComponent,
   
  ) { }

  input : InputModel = new InputModel();

  // Numeric Button Handler
  numBtnHandler(key: string) {
    this.value += key;
    this.calcComp.setDisplay(this.value);
  }

  // Operation Button Handler
  operationBtnHandler(key: any) {
    if (key == '=') {
      this.calcComp.evaluate(this.value);                             // this.num = Number(this.value);
                                              // console.log(this.input.operand)
                                              // this.input.operand.push(this.num);
      
    }
    else {
      this.value += key;
      this.calcComp.setDisplay(this.value);

                                                // this.num = Number(this.value);
                                                // console.log(this.input.operand)
                                                // this.input.operand.push(this.num);
                                                // this.value = '';
                                                // this.input.operation = key;
                                                // console.log(this.input.operation)
                                                // this.calcComp.setDisplay(this.value);
    }
    }

    // Function Button Handler
  functionBtnHandler(key : string) {
   if(key === 'AC'){
       this.value = '0';
       this.calcComp.setDisplay(this.value);
    }
    else{
     this.value = this.value.slice(0,-1);
     this.calcComp.setDisplay(this.value);
    }

  }
}
