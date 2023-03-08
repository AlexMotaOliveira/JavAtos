import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { UsuarioFiltro } from '../UsuarioFiltro';
import {Usuario} from "../Usuario";

@Component({
  selector: 'app-listagem-de-usuario',
  templateUrl: './listagem-de-usuario.component.html',
  styleUrls: ['./listagem-de-usuario.component.scss'],
})
export class ListagemDeUsuarioComponent {
  constructor(private usuarioService: UsuarioService) {
    this.filtrarTabela();
  }

  lista:any[] = []
  rows:number = 5;
  filtro:UsuarioFiltro = new UsuarioFiltro();
  totalElements:number = 0;


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

  aoSelecionarPagina(event:any){
    const pagina = event.first / event.rows;
    this.rows = event.rows;
    this.filtrarTabela(pagina);
  }

  onRowEditInit(usuario:Usuario){}

  onRowEditSave(usuario:Usuario){
    this.usuarioService.update(usuario);
    this.filtrarTabela();
  }

  onRowEditCancel(usuario:Usuario, code:number){}

  deletar(id:number){
    console.log(id)
    this.usuarioService.deletar(id).subscribe({
      next: (item) => this.filtrarTabela(),
      error: (err) => console.log('Error', err),
    });
  }}
