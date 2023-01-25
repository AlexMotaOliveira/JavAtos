import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cadastro-de-lancamentos',
  templateUrl: './cadastro-de-lancamentos.component.html',
  styleUrls: ['./cadastro-de-lancamentos.component.scss']
})
export class CadastroDeLancamentosComponent {

  count:number = 2;

  lista:any[] = [
    {
      // code: 2,
      // tipo: 'despesa',
      // local: 'loja',
      // descricao: 'compra de lapis',
      // dataDaCompra: '20/01/2023',
      // dataDeVencimento: '20/01/2023',
      // valor: 50.12225,
    }
  ];

  nome:string = '';
  email:string = '';

  code?:number;
  tipo!:string;
  descricao!:string;
  dataDaCompra!:string;
  dataDeVencimento!:string;
  valor!:number;

  salvar(formulario: NgForm){
    this.count++;
    console.log("entrou no metodo")
    if(formulario.valid){
      this.lista.push(formulario.value);
      console.log("add na lista")
    }
    formulario.resetForm();
  }

  salvarnoBD(){
    console.log("enviando para o bd...")
  }
}
