import { Component } from '@angular/core';
import { ButtonModel } from 'src/app/model/ButtonModel';


@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent {
  buttonModel : ButtonModel = new ButtonModel();
 operationButtons = this.buttonModel.operationButton;
}
