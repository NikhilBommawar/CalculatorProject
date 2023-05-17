import { Component } from '@angular/core';

import { ButtonModel } from 'src/app/model/ButtonModel';
import { CalcService } from 'src/app/service/calc.service';


@Component({
  selector: 'app-function',
  templateUrl: './function.component.html',
  styleUrls: ['./function.component.css']
})
export class FunctionComponent {
constructor(private calcService : CalcService){}

  buttonModel : ButtonModel = new ButtonModel();
  functionButtons = this.buttonModel.functionButton;


  clickHandler(key : any){
      this.calcService.functionBtnHandler(key);
   }

}
