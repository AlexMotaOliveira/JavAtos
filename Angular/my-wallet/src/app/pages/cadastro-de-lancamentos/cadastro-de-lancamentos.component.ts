import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Lancamento } from '../Lancamento';
import { LancamentosService } from '../lancamentos.service';

@Component({
  selector: 'app-cadastro-de-lancamentos',
  templateUrl: './cadastro-de-lancamentos.component.html',
  styleUrls: ['./cadastro-de-lancamentos.component.scss']
})
export class CadastroDeLancamentosComponent {

  constructor(private lancamentosService:LancamentosService){

  }

  count:number = 2;

  lista:Lancamento[] = [];


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

}
