import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Lancamento } from './lancamentos/Lancamento';
import { LancamentoFiltro } from './lancamentos/LancamentoFiltro';
import { LancamentoPaginavel } from './lancamentos/LancamentoPaginavel';



@Injectable({
  providedIn: 'root',
})
export class LancamentosService {
  constructor(private httpClient: HttpClient) {}

  lancamentos: Lancamento[] = [];
  private apiBaseUrl = 'http://localhost:8080/lancamentos';

  salvar(formulario: any) {
      const lancamento = formulario.value;
      const response = this.httpClient.post<Lancamento>(this.apiBaseUrl, lancamento);
      formulario.resetForm();
      return response;

  }

  update(lancamento: Lancamento) {
    this.httpClient.post<Lancamento>(this.apiBaseUrl, lancamento).subscribe({
      next: (body) => console.log(body),
      error: (err) => console.log('Error', err),
    });
  }

  consultar() {
    this.lancamentos = [];
    this.httpClient.get<Lancamento[]>(this.apiBaseUrl).subscribe({
      next: (item) => {
        item.forEach((data) => this.lancamentos.push(data));
      },
      error: (err) => console.log('Error', err),
    });

    return this.lancamentos;
  }

  deletar(code: number) {
    return this.httpClient.delete<any>(this.apiBaseUrl + '/' + code);
  }


  filtrarTabela(filtro: LancamentoFiltro){

    let params = new HttpParams();


    params = params.set('size', filtro.itensPorPagina);
    params = params.set('page', filtro.pagina);

    if(filtro.descricao != null){

      params = params.set('descricao', filtro.descricao)
    }

    if(filtro.dataInicial != null){

      params = params.set('dataInicial', filtro.dataInicial)
    }

    if(filtro.dataFinal != null){

      params = params.set('dataFinal', filtro.dataFinal)
    }


    return this.httpClient.get<LancamentoPaginavel>(this.apiBaseUrl, {params})
  }
}
