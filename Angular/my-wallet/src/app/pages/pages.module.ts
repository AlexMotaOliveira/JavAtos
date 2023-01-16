import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './cadastro-de-lancamentos/cadastro-de-lancamentos.component';



@NgModule({
  declarations: [
    LancamentosComponent,
    CadastroDeLancamentosComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    LancamentosComponent,
    CadastroDeLancamentosComponent
  ]
})
export class PagesModule { }
