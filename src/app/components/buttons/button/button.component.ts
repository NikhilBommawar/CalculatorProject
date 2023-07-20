import { Component, ElementRef, ViewChild } from '@angular/core';


@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent {
  
  displayContent : any;

  @ViewChild('display')
  display!: ElementRef;


  

}
