import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LancamentosComponent } from './pages/lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './pages/cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroDeUsuarioComponent } from './pages/usuario/cadastro-de-usuario/cadastro-de-usuario.component';
import { ListagemDeUsuarioComponent } from './pages/usuario/listagem-de-usuario/listagem-de-usuario.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'lancamentos', component: LancamentosComponent },
  { path: 'cadastro-de-lancamentos', component: CadastroDeLancamentosComponent },
  { path: 'home', component: HomeComponent },
  { path: 'cadastro-de-usuario', component: CadastroDeUsuarioComponent },
  { path: 'usuario', component: ListagemDeUsuarioComponent },
  { path: '**', redirectTo: '/' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
