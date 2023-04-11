import { Component } from '@angular/core';
import { LancamentosService } from '../lancamentos.service';
import { Lancamento } from './Lancamento';
import { LancamentoFiltro } from './LancamentoFiltro';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.scss'],
})
export class LancamentosComponent {


   lista:Lancamento [] = [];
   filtro: LancamentoFiltro = new LancamentoFiltro();
   totalElements: number = 0;
   rows = 5;


  constructor(private lancamentosService: LancamentosService,
              private router:Router){
    this.filtrarTabela()
  }

  onRowEditInit(product: Lancamento) {}

  onRowEditSave(product: Lancamento) {
    this.lancamentosService.update(product);
  }

  onRowEditCancel(product: Lancamento, ri: any) {}

  deletar(code: number) {
    this.lista = [];
    this.lancamentosService.deletar(code).subscribe({
      next: () => this.filtrarTabela(),
      error: (err) => console.log('Error', err),
    });
  }


  filtrarTabela(pagina: number = 0){
   this.lista =[];
  this.filtro.pagina = pagina;
  this.filtro.itensPorPagina = this.rows;

   this.lancamentosService.filtrarTabela(this.filtro).subscribe({
    next: (item) => {
      this.lista = item.content;
      this.totalElements = item.totalElements;
    },
    error: (err) => {
      console.log('Error', err)
      this.router.navigate(['login'])
      localStorage.clear();
    },
   })
  }

  aoSelecionarPagina(event: any){
    const pagina = event.first / event.rows;
    this.rows = event.rows;
    this.filtrarTabela(pagina);
  }

}
