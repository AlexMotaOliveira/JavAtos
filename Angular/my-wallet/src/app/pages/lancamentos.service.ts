import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Lancamento } from './Lancamento';

@Injectable({
  providedIn: 'root',
})
export class LancamentosService {
  constructor(private http: HttpClient) {}

  lancamentos: Lancamento[] = [];
  // {
  //   code: 1,
  //   tipo: 'despesa',
  //   local: 'loja',
  //   descricao: 'compra de lapis',
  //   dataDaCompra: new Date ('20/01/2023'),
  //   dataDeVencimento: new Date ('20/01/2023'),
  //   valor: 50.12225,
  // },
  // {
  //   code: 2,
  //   tipo: 'Receita',
  //   local: 'Atos',
  //   descricao: 'Salario',
  //   dataDaCompra: new Date ('20/01/2023'),
  //   dataDeVencimento: new Date ('20/01/2023'),
  //   valor: 10.000,
  // },
  // ];

  salvar(formulario: any) {
    if (formulario.valid) {
      this.lancamentos.push(formulario.value);
      // http
    }
    formulario.resetForm();
  }

  consultar() {
    console.log('lista dentro do service');
    console.log(this.lancamentos);
    return this.lancamentos;
  }

  getHttp() {
    this.http.get<Lancamento[]>('http://localhost:8080/lancamentos').subscribe({
      next: (item) => {
        item.forEach((data) => this.lancamentos.push(data));
      },
      error: (err) => console.log('Error', err),
    });
    
    // return this.http.get<any>("http://localhost:8080/lancamentos");
  }

  deletar(code: number) {
    // this.lancamentos = this.lancamentos.filter((item) => item.code !== code);
  }
}
