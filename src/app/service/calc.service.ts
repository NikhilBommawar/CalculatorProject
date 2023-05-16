import { Injectable } from '@angular/core';
import { CalcComponent } from '../components/calc/calc.component';
import { InputModel } from '../model/InputModel';



@Injectable({
  providedIn: 'root'
})

export class CalcService {
  
 

  value: string = '';
  operand !: string ;
  num !: number;
  stack :any = [] ;
  key : any;
  readonly input: any;

  constructor(private calcComp: CalcComponent) { }

  // input : InputModel = new InputModel();

  // NUMERIC BUTTON HANDLER
   numBtnHandler(key: string) {
    this.value += key;
    console.log(key)
    this.calcComp.setDisplay(this.value);
  }

  // OPERATION BUTTON HANDLER
  operationBtnHandler(key: any) {
    this.key = key;
    if (key == '=') {
      this.pushNumber();
      console.log("The complate stack array going to backend ",this.stack);
      this.value = this.calcComp.evaluate(this.stack);
      this.stack.splice(0);
    
      
    }
    else {
      console.log(key)
      this.pushNumber();
      this.pushOperator();
      console.log(this.stack);
      this.value = "";
      this.calcComp.setDisplay(this.value);


    }
    }

     // FUNCTION BUTTON HANDLER
  functionBtnHandler(key : string) {
   if(key === 'AC'){
       this.value = '';
       this.calcComp.setDisplay(this.value);
       this.stack.splice(0);

    }
    else{
     this.value = this.calcComp.getDisplay();
     this.value = this.value.slice(0,-1);
     this.calcComp.setDisplay(this.value);
    }

  }

   pushNumber() {
     let input = new InputModel();
    input.type = "NUMBER";
    input.value = this.value;
    this.stack.push(input)
 }

  pushOperator(){
    let input = new InputModel();
    input.type = "OPERATOR";
    
    switch(this.key){

      case "+":
        input.value = "add";
        break;

       case "-":
          // input.type = "operator";
          input.value = "subtract";
          break;

       case "*":
            // input.type = "operator";
            input.value = "multiply";
            break;

       case "/":
              // input.type = "operator";
              input.value = "division";
              break;

   }

   
    this.stack.push(input)
     
  }

  resetArray() {
     this.stack.splice(0);
  }
}
