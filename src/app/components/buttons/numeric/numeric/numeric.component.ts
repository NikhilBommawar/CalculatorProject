import { Component } from '@angular/core';
import { CalcComponent } from 'src/app/components/calc/calc.component';
import { ButtonModel } from 'src/app/model/ButtonModel';
import { ButtonService } from 'src/app/service/button.service';



@Component({
  selector: 'app-numeric',
  templateUrl: './numeric.component.html',
  styleUrls: ['./numeric.component.css']
})

export class NumericComponent {
  constructor(private btnService : ButtonService, private calcComnt : CalcComponent) { }
  buttonModel : ButtonModel = new ButtonModel();
  

  numericButtons = this.buttonModel.numericButton;

  displayContent : any;


  clickHandler(key : any){
    this.btnService.numBtnHandler(key);
 }


}
