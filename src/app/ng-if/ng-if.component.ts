import { Component } from '@angular/core';

@Component({
  selector: 'app-ng-if',
  templateUrl: './ng-if.component.html',
  styleUrls: ['./ng-if.component.css']
})

export class NgIfComponent {

  exibir = true;
  numero = 11;
  lista = ['Java','Spring'];

  isExibir(){
    this.exibir = !this.exibir;
    console.log(this.exibir);
  }

}
