import { Component } from '@angular/core';
import { ButtonModel } from 'src/app/model/ButtonModel';
import { DisplayServiceService } from 'src/app/service/display-service.service';
import { DisplayComponent } from 'src/app/components/display/display/display.component';


@Component({
  selector: 'app-numeric',
  templateUrl: './numeric.component.html',
  styleUrls: ['./numeric.component.css']
})

export class NumericComponent {
  buttonModel : ButtonModel = new ButtonModel();
  displayComponent : DisplayComponent = new DisplayComponent();
  numericButtons = this.buttonModel.numericButton;

  displayContent : any;

  constructor(private displayService: DisplayServiceService){

  }

  doNumeric(numeric : any){
    console.log(numeric)
  this.displayContent = this.displayService.getDisplayContent();
  // this.displayComponent.setDisplayInComponent(this.displayContent + numeric +'');
  this.displayService.setDisplayContent(this.displayContent + numeric+'');
}
}
