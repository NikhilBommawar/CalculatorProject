import { Injectable } from '@angular/core';
import { CalcComponent } from '../components/calc/calc.component';

@Injectable({
  providedIn: 'root'
})
export class ButtonService {

 constructor(private calcComp: CalcComponent) { }
 

   key !: string;

   setKey(key : string){
     this.key = key;
   }

   getKey() : string {
    return this.key;
   }

   numBtnHandler(key: string){
    this.calcComp.numBtnHandler(key);
   }

   operationBtnHandler(key: any){
    this.calcComp.operationBtnHandler(key);

  }

  functionBtnHandler(key : string) {
    this.calcComp.functionBtnHandler(key);
  }


}
