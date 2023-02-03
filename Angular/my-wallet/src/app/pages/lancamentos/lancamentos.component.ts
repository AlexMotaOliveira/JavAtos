import { Component } from '@angular/core';
import { LancamentosService } from '../lancamentos.service';
import { Lancamento } from '../Lancamento';

@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.scss'],
})
export class LancamentosComponent {


  constructor(private lancamentosService: LancamentosService){
    lancamentosService.getHttp();
    this.lista = lancamentosService.consultar();
  }

  lista: any[] = [];

  onRowEditInit(product: any) {}

  onRowEditSave(product: any) {}

  onRowEditCancel(product: any, ri: any) {}

  deletar(code: number) {
    this.lancamentosService.deletar(code);
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
