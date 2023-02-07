import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Lancamento } from './Lancamento';

@Injectable({
  providedIn: 'root',
})
export class LancamentosService {
  constructor(private httpClient: HttpClient) {}

  lancamentos: Lancamento[] = [];
  private apiBaseUrl = 'http://localhost:8080/lancamentos';

  salvar(formulario: any) {
    if (formulario.valid) {
      const lancamento = formulario.value;
      this.httpClient.post<Lancamento>(this.apiBaseUrl, lancamento).subscribe({
        next: (body) => console.log(body),
        error: (err) => console.log('Error', err),
      });
    }
    formulario.resetForm();
  }

  update(lancamento: Lancamento) {
    this.httpClient.post<Lancamento>(this.apiBaseUrl, lancamento).subscribe({
      next: (body) => console.log(body),
      error: (err) => console.log('Error', err),
    });
  }

  consultar() {
    return this.lancamentos;
  }

  getHttp() {
    this.lancamentos = [];
    this.httpClient.get<Lancamento[]>(this.apiBaseUrl).subscribe({
      next: (item) => {
        item.forEach((data) => this.lancamentos.push(data));
      },
      error: (err) => console.log('Error', err),
    });

    // return this.http.get<any>("http://localhost:8080/lancamentos");
  }

  deletar(code: number) {
    this.httpClient.delete<any>(this.apiBaseUrl + '/' + code).subscribe({
      next: (body) => console.log(body),
      error: (err) => console.log('Error', err),
    });
  }
}
