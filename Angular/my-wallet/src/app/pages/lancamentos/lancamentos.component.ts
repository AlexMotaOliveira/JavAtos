import { Component } from '@angular/core';
import { LancamentosService } from '../lancamentos.service';
import { Lancamento } from '../Lancamento';

@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.scss'],
})
export class LancamentosComponent {


   lista:Lancamento [] = [];

  constructor(private lancamentosService: LancamentosService){
    lancamentosService.getHttp();
    this.lista = lancamentosService.consultar();
  }

  onRowEditInit(product: Lancamento) {}

  onRowEditSave(product: Lancamento) {
    this.lancamentosService.update(product)
  }

  onRowEditCancel(product: Lancamento, ri: any) {}

  deletar(code: number) {
    this.lancamentosService.deletar(code);
    this.lancamentosService.getHttp();
    this.lista = this.lancamentosService.consultar();

  }


  descricao: string = '';
  dataInicial ='';
  dataFinal = '';


  filtarTabela(){
    this.lista = this.lista.filter((item) =>{
      return item
                .descricao
                .toLowerCase()
                .indexOf(this.descricao.toLowerCase()) >= 0;
    });
  }
}
