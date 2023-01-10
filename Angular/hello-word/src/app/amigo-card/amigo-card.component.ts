import { Component } from '@angular/core';

@Component({
  selector: 'app-amigo-card',
  templateUrl: './amigo-card.component.html',
  styleUrls: ['./amigo-card.component.css']
})
export class AmigoCardComponent {


  pessoas: string[] = [];

  nome = "";

  // java String nome
  adicionar(variavelCriada: string){
    this.nome = variavelCriada;
    console.log(variavelCriada)
  }

  capturarNome(evento: any){
    console.log(evento)
    this.nome = evento.target.value + 1;
  }

  adicionarNome(variavelCriada: string){
    console.log(variavelCriada);

    this.pessoas.push(variavelCriada)
  }

}
