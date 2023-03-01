import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cadastro-de-usuario',
  templateUrl: './cadastro-de-usuario.component.html',
  styleUrls: ['./cadastro-de-usuario.component.scss']
})
export class CadastroDeUsuarioComponent {

  constructor(private usuarioService: UsuarioService){
  }

  usuario:any = "";

  nome:string ="";
  email:string ="";
  senha:string ="";

  salvar(formulario: NgForm){
    console.log(formulario)
    this.usuarioService.salvar(formulario).subscribe({
      next: (body) => {
        console.log(body);
        this.usuario = body;
      },
      error: (err) => console.log('Error', err),
    });
}

}
