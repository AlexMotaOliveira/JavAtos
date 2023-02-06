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
      this.lancamentos.push(formulario.value);
      const lancamento = formulario.value;
      this.httpClient.post<Lancamento>(this.apiBaseUrl, lancamento).subscribe({
        next: (body) => console.log(body),
        error: (err) => console.log('Error', err)
      })
    }
    formulario.resetForm();
  }

  consultar() {
    console.log('lista dentro do service');
    console.log(this.lancamentos);
    return this.lancamentos;
  }

  getHttp() {
    this.httpClient.get<Lancamento[]>(this.apiBaseUrl).subscribe({
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
