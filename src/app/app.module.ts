import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalcComponent } from './components/calc/calc.component';
import { DisplayComponent } from './components/display/display/display.component';
import { ButtonComponent } from './components/buttons/button/button.component';
import { FunctionComponent } from './components/buttons/function/function/function.component';
import { OperationComponent } from './components/buttons/operation/operation/operation.component';
import { NumericComponent } from './components/buttons/numeric/numeric/numeric.component';
import { DisplayServiceService } from './service/display-service.service';
 import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    DisplayComponent,
    ButtonComponent,
    FunctionComponent,
    OperationComponent,
    NumericComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
    
  ],
  providers: [DisplayServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
