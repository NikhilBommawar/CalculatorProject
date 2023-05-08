import { Component } from '@angular/core';
import { ButtonModel } from 'src/app/model/ButtonModel';


@Component({
  selector: 'app-function',
  templateUrl: './function.component.html',
  styleUrls: ['./function.component.css']
})
export class FunctionComponent {
  buttonModel : ButtonModel = new ButtonModel();
  functionButtons = this.buttonModel.functionButton;
}
