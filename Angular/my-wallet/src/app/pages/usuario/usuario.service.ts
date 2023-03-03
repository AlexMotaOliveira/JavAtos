import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from './Usuario';
import { UsuarioPaginavel } from './UsuarioPaginavel';
import { UsuarioFiltro } from './UsuarioFiltro';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private httpClient: HttpClient) {}

  private apiBaseUrl = 'http://localhost:8081/usuario';

  salvar(formulario: any) {
    const lancamento = formulario.value;
      return this.httpClient.post<Usuario>(this.apiBaseUrl, lancamento);
  }

  filtrarTabela(filtro: UsuarioFiltro){

    let params = new HttpParams();


    params = params.set('size', filtro.itensPorPagina);
    params = params.set('page', filtro.pagina);

    if(filtro.nome != null){

      params = params.set('nome', filtro.nome)
    }

    return this.httpClient.get<UsuarioPaginavel>(this.apiBaseUrl, {params})
  }
}
