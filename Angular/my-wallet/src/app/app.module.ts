import { NgModule } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { SidebarModule } from 'primeng/sidebar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { TableModule } from 'primeng/table';
import { PagesModule } from './pages/pages.module';
import { TesteModule } from './teste/teste.module';


@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SidebarModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    TableModule,
    PagesModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports:[

  ]
})
export class AppModule { }
