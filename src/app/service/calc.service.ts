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
  undoStack : any =[];
  key : any;
  readonly input: any;

  constructor(private calcComp: CalcComponent) { }
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
      this.calcComp.evaluate(this.stack);
      this.undoStack = [...this.stack];
      this.stack.splice(0);
       console.log(this.stack)
     console.log(this.undoStack)
     
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
    else if(key === 'DEL'){
      this.value = this.calcComp.getDisplay();
    //  console.log(typeof(this.value));
     let value2 = this.value + "";
    //  console.log(typeof(value2));
     this.value = value2.slice(0,-1);
     this.calcComp.setDisplay(this.value);
    }

    else if(key === 'UNDO'){
      this.undoStack.pop();
      this.undoStack.pop();
      this.calcComp.evaluate(this.undoStack);

    }

  }

   pushNumber() {
    if(this.value != ''){
     let input = new InputModel();
    input.type = "NUMBER";
    input.value = this.calcComp.getDisplay() + "";
    console.log("input ",input)
    this.stack.push(input)
  }
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


}
