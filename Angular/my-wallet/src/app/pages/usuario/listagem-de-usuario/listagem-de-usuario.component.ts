import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { UsuarioFiltro } from '../UsuarioFiltro';
import {Usuario} from "../Usuario";
import {LancamentosService} from "../../lancamentos.service";

@Component({
  selector: 'app-listagem-de-usuario',
  templateUrl: './listagem-de-usuario.component.html',
  styleUrls: ['./listagem-de-usuario.component.scss'],
})
export class ListagemDeUsuarioComponent {
  constructor(private usuarioService: UsuarioService,
              private lancamentosService: LancamentosService) {
    this.filtrarTabela();
  }

  lista:any[] = []
  rows:number = 0;
  filtro:UsuarioFiltro = new UsuarioFiltro();
  totalElements:number = 5;


  filtrarTabela(pagina: number = 0) {
    this.lista = [];
    this.filtro.pagina = pagina;
    this.filtro.itensPorPagina = this.rows;

    this.usuarioService.filtrarTabela(this.filtro).subscribe({
      next: (item) => {
        console.log(item.content)
        this.lista = item.content;
        this.totalElements = item.totalElements;
      },
      error: (err) => console.log('Error', err),
    });
  }

  aoSelecionarPagina(evento:any){}

  onRowEditInit(usuario:Usuario){}

  onRowEditSave(usuario:Usuario){}

  onRowEditCancel(usuario:Usuario, code:number){}

  deletar(code:number){}
}
