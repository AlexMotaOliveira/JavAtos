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

  constructor(private lancamentosService: LancamentosService){
    this.lista = lancamentosService.consultar();
  }

  onRowEditInit(product: Lancamento) {}

  onRowEditSave(product: Lancamento) {
    this.lancamentosService.update(product)
  }

  onRowEditCancel(product: Lancamento, ri: any) {}

  deletar(code: number) {
    this.lista = [];
    this.lancamentosService.deletar(code).subscribe({
      next: () => this.lista = this.lancamentosService.consultar(),
      error: (err) => console.log('Error', err),
    });
  }


  descricao: string = '';
  dataInicial ='';
  dataFinal = '';


  filtarTabela(){
   this.lista =[];

    const filtro:LancamentoFiltro = {
      descricao: this.descricao,
      dataInicial: this.dataInicial,
      dataFinal:this.dataFinal
    }


   this.lancamentosService.filtrarTabela(filtro).subscribe({
    next: (item) => {
      item.forEach((data) => {
        console.log(data)
        this.lista.push(data)
      });
    },
    error: (err) => console.log('Error', err),
   })
  }
}
