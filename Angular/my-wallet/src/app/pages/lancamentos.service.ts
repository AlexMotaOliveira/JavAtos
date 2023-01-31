import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LancamentosService {


  lancamentos:any [] = [];


  salvar(formulario:any){
    if(formulario.valid){
      this.lancamentos.push(formulario.value);
      // http
    }
    formulario.resetForm();
  }

  consultar(){
    console.log("lista de lançamentos")
    return this.lancamentos;
  }

  constructor() { }
}
