import { Component } from '@angular/core';
import { LancamentosService } from '../lancamentos.service';
import { Lancamento } from './Lancamento';
import { LancamentoFiltro } from './LancamentoFiltro';

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


  constructor(private lancamentosService: LancamentosService){
    this.filtarTabela()
  }

  onRowEditInit(product: Lancamento) {}

  onRowEditSave(product: Lancamento) {
    this.lancamentosService.update(product)
  }

  onRowEditCancel(product: Lancamento, ri: any) {}

  deletar(code: number) {
    this.lista = [];
    this.lancamentosService.deletar(code).subscribe({
      next: () => this.filtarTabela(),
      error: (err) => console.log('Error', err),
    });
  }


  filtarTabela(pagina: number = 0){
   this.lista =[];
  this.filtro.pagina = pagina;
  this.filtro.itensPorPagina = this.rows;

   this.lancamentosService.filtrarTabela(this.filtro).subscribe({
    next: (item) => {
      this.lista = item.content;
      this.totalElements = item.totalElements;
    },
    error: (err) => console.log('Error', err),
   })
  }

  aoSelecionarPagina(event: any){
    const pagina = event.first / event.rows;
    console.log(event);
    console.log(pagina);
    this.rows = event.rows;
    this.filtarTabela(pagina);
  }

}
