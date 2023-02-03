import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { DropdownModule } from 'primeng/dropdown';
import {TooltipModule} from 'primeng/tooltip';
import { HomeComponent } from './home/home.component';
import { SelectButtonModule } from 'primeng/selectbutton';
import { CalendarModule } from 'primeng/calendar';
import { InputNumberModule } from 'primeng/inputnumber';
import { HttpClientModule } from '@angular/common/http';
import { LancamentosService } from './lancamentos.service';


@NgModule({
  declarations: [
    LancamentosComponent,
    CadastroDeLancamentosComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    TableModule,
    DropdownModule,
    TooltipModule,
    SelectButtonModule,
    InputTextModule,
    CalendarModule,
    InputNumberModule,
    HttpClientModule
  ],
  exports:[
    LancamentosComponent,
    CadastroDeLancamentosComponent,
    HomeComponent
  ]
})
export class PagesModule { }
