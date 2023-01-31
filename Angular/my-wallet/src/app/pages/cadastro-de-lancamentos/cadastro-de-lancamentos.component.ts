import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LancamentosService } from '../lancamentos.service';

@Component({
  selector: 'app-cadastro-de-lancamentos',
  templateUrl: './cadastro-de-lancamentos.component.html',
  styleUrls: ['./cadastro-de-lancamentos.component.scss']
})
export class CadastroDeLancamentosComponent {

  lancamentosService;

  constructor(lancamentosService:LancamentosService){
      this.lancamentosService = lancamentosService;
  }

  count:number = 2;

  lista:any[] = [];


  tiposDespesa:any[] = [
    {label: 'Despesa', value: 'DESPESA'},
    {label: 'Receita', value: 'RECEITA'},

  ]

  nome:string = '';
  email:string = '';

  code?:number;
  tipo!:string;
  descricao!:string;
  dataDaCompra!:string;
  dataDeVencimento!:string;
  valor!:number;

  salvar(formulario: NgForm){
      this.lancamentosService.salvar(formulario);
      this.lista = this.lancamentosService.consultar();
  }

  salvarnoBD(){
    console.log("enviando para o bd...")
  }

  // java contrutor
  // TS não tem @AutoWired

}
