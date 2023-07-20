import { Component } from '@angular/core';

import { ButtonModel } from 'src/app/model/ButtonModel';
import { ButtonService } from 'src/app/service/button.service';



@Component({
  selector: 'app-function',
  templateUrl: './function.component.html',
  styleUrls: ['./function.component.css']
})
export class FunctionComponent {
constructor(private btnService : ButtonService){}

  buttonModel : ButtonModel = new ButtonModel();
  functionButtons = this.buttonModel.functionButton;


  clickHandler(key : any){
      this.btnService.functionBtnHandler(key);
   }

}
