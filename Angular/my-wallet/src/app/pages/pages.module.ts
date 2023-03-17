import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import { FormControl, FormsModule } from '@angular/forms';
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
import { CadastroDeUsuarioComponent } from './usuario/cadastro-de-usuario/cadastro-de-usuario.component';
import { ListagemDeUsuarioComponent } from './usuario/listagem-de-usuario/listagem-de-usuario.component';


@NgModule({
  declarations: [
    LancamentosComponent,
    CadastroDeLancamentosComponent,
    HomeComponent,
    CadastroDeUsuarioComponent,
    ListagemDeUsuarioComponent
  ],
  imports: [
    CommonModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    FormControl,
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
  ]
})
export class PagesModule { }
