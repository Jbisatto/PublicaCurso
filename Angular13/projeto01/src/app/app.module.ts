import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Pg1Component } from './pg1/pg1.component';
import { MenuComponent } from './menu/menu.component';
import { Pg2Component } from './pg2/pg2.component';
import { Pg3Component } from './pg3/pg3.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Pg404Component } from './pg404/pg404.component';
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    Pg1Component,
    MenuComponent,
    Pg2Component,
    Pg3Component,
    Pg404Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
