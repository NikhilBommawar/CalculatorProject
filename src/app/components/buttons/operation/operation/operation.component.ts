import { Component } from '@angular/core';
import { CalcComponent } from 'src/app/components/calc/calc.component';
import { ButtonModel } from 'src/app/model/ButtonModel';
import { ButtonService } from 'src/app/service/button.service';



@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent {

  constructor(private btnService : ButtonService) { }

  buttonModel: ButtonModel = new ButtonModel();
  operationButtons = this.buttonModel.operationButton;

  clickHandler(key: any) {
    this.btnService.operationBtnHandler(key);
  }

}
