import { Component } from '@angular/core';

@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.scss'],
})
export class LancamentosComponent {
  lista: any[] = [
    {
      code: 1,
      tipo: 'despesa',
      local: 'loja',
      descricao: 'compra de lapis',
      dataDaCompra: '20/01/2023',
      dataDeVencimento: '20/01/2023',
      valor: 50.12225,
    },
    {
      code: 2,
      tipo: 'Receita',
      local: 'Atos',
      descricao: 'Salario',
      dataDaCompra: '20/01/2023',
      dataDeVencimento: '20/01/2023',
      valor: 10.000,
    },
  ];
  statuses: any[] = ['escolar', 'vesturario'];

  onRowEditInit(product: any) {}

  onRowEditSave(product: any) {}

  onRowEditCancel(product: any, ri: any) {}

  deletar(code: number) {
    this.lista = this.lista.filter((item) => item.code !== code);
  }


  descricao: string = '';
  dataInicial ='';
  dataFinal = '';


  filtarTabela(){
    this.lista = this.lista.filter((item) =>{
      return item
                .descricao
                .toLowerCase()
                .indexOf(this.descricao.toLowerCase()) >= 0;
    });
  }
}
