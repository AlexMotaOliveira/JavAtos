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



@NgModule({
  declarations: [
    LancamentosComponent,
    CadastroDeLancamentosComponent
  ],
  imports: [
    CommonModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    TableModule,
    DropdownModule,
    TooltipModule
  ],
  exports:[
    LancamentosComponent,
    CadastroDeLancamentosComponent
  ]
})
export class PagesModule { }
