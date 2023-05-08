import { AfterViewChecked, AfterViewInit, Component,ElementRef, OnInit, ViewChild } from '@angular/core';

// import { DisplayServiceService } from 'src/app/service/display-service.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
 
})
export class DisplayComponent {
 
  
  displayContent :string = "";
  
  
// @ViewChild('displayContent')
//   display!: ElementRef;
 
  // ngAfterViewInit(): void {
  //  
  // }
  
 getDisplayfromComponent(){
  return this.displayContent;
 }

 
 setDisplayInComponent(content : string){
  this.displayContent =content;
  console.log("i am content ----->"+content)
  // console.log(this.display.nativeElement)
 }
  

 pressMe(){
  this.displayContent = 'it is coming';
 }
}
