import {  Component,ElementRef, Input, ViewChild } from '@angular/core';

// import { DisplayServiceService } from 'src/app/service/display-service.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
 
})
export class DisplayComponent  {
   @Input()
  displayContent : any = ' ';
  
}
