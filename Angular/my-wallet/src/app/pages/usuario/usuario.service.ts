import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from './Usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private httpClient: HttpClient) {}

  private apiBaseUrl = 'http://localhost:8081/usuario';

  salvar(formulario: any) {
    const lancamento = formulario.value;
      const response = this.httpClient.post<Usuario>(this.apiBaseUrl, lancamento)
      return response;
  }
}
