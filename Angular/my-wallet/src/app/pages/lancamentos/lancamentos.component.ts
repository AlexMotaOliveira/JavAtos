import { Component } from '@angular/core';

@Component({
  selector: 'app-lancamentos',
  templateUrl: './lancamentos.component.html',
  styleUrls: ['./lancamentos.component.scss']
})
export class LancamentosComponent {

  lista:any [] = [
    {code: 1,	name:'lapis',	category:'escolar',	price: 1},
    {code: 2,	name:'lapis',	category:'escolar',	price: 1},
    {code: 3,	name:'lapis',	category:'escolar',	price: 1},
    {code: 4,	name:'lapis',	category:'escolar',	price: 1},
    {code: 5,	name:'lapis',	category:'escolar',	price: 1},
    {code: 6,	name:'lapis',	category:'escolar',	price: 1},
    {code: 7,	name:'lapis',	category:'escolar',	price: 1},
    {code: 8,	name:'lapis',	category:'escolar',	price: 1},
    {code: 9,	name:'lapis',	category:'escolar',	price: 1},
    {code: 10,	name:'lapis',	category:'escolar',	price: 1}
  ];
  statuses:any []= ['escolar','vesturario'];

  onRowEditInit(product:any){

  }

  onRowEditSave(product:any){

  }

  onRowEditCancel(product:any, ri:any){

  }

  deletar(code:number){
      this.lista = this.lista.filter(item => item.code !== code);
  }


}
