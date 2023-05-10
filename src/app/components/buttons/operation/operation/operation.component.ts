import { Component } from '@angular/core';
import { ButtonModel } from 'src/app/model/ButtonModel';
import { CalcService } from 'src/app/service/calc.service';


@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent {

  constructor(private calcService: CalcService) { }

  buttonModel: ButtonModel = new ButtonModel();
  operationButtons = this.buttonModel.operationButton;

  clickHandler(key: any) {
    this.calcService.operationBtnHandler(key);
  }
}
