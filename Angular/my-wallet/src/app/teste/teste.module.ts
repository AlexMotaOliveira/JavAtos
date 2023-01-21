import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormularioComponent } from './formulario/formulario.component';
import { HomeComponent } from './home/home.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';





@NgModule({
  declarations: [
    FormularioComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    InputTextModule,
    FormsModule,
    ButtonModule
  ],
  exports: [
    HomeComponent
  ]
})
export class TesteModule { }

