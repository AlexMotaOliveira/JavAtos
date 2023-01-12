import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TabMenuModule } from 'primeng/tabmenu';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [

    AppComponent
  ],
  imports: [
    BrowserModule,
    ButtonModule,
    TableModule,
    TabMenuModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([]),
    TableModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
