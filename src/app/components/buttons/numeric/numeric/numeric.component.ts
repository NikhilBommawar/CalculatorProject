import { Component } from '@angular/core';
import { CalcComponent } from 'src/app/components/calc/calc.component';
import { ButtonModel } from 'src/app/model/ButtonModel';
import { CalcService } from 'src/app/service/calc.service';


@Component({
  selector: 'app-numeric',
  templateUrl: './numeric.component.html',
  styleUrls: ['./numeric.component.css']
})

export class NumericComponent {
  constructor(private calcService : CalcService) { }
  buttonModel : ButtonModel = new ButtonModel();
  

  numericButtons = this.buttonModel.numericButton;

  displayContent : any;


  clickHandler(key : any){
    this.calcService.numBtnHandler(key);
 }
}
