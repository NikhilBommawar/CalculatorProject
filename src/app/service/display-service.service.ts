import { Injectable, ViewChild, ElementRef } from '@angular/core';
import { DisplayComponent } from '../components/display/display/display.component'; 

@Injectable({
  providedIn: 'root'
})
export class DisplayServiceService {

  constructor() { }

  displayContent : any;

  @ViewChild('display')
  display!: ElementRef;

  displayComponent : DisplayComponent = new DisplayComponent();

  // to get display content
  getDisplayContent(){
    return this.displayComponent.getDisplayfromComponent();
  }

  // to set display content
  setDisplayContent(content : any){
    this.displayComponent.setDisplayInComponent(content);
  }

  
}
