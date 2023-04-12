import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LancamentosComponent } from './pages/lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './pages/cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroDeUsuarioComponent } from './pages/usuario/cadastro-de-usuario/cadastro-de-usuario.component';
import { ListagemDeUsuarioComponent } from './pages/usuario/listagem-de-usuario/listagem-de-usuario.component';
import { LoginComponent } from './pages/login/login.component';
import {AuthGuard} from "./pages/login/auth/auth.guard";

const routes: Routes = [
  { path: 'login', component: LoginComponent },

  { path: '', component: HomeComponent, canActivate: [AuthGuard], data: {permissoes: ['ROLE_USER', 'ROLE_ADMIN'] } },
  { path: 'home', component: HomeComponent , canActivate: [AuthGuard], data: {permissoes: ['ROLE_USER', 'ROLE_ADMIN'] }},
  { path: 'lancamentos', component: LancamentosComponent, canActivate: [AuthGuard], data: {permissoes: ['ROLE_USER','ROLE_ADMIN'] } },
  { path: 'cadastro-de-lancamentos', component: CadastroDeLancamentosComponent, canActivate: [AuthGuard] , data: {permissoes: ['ROLE_USER','ROLE_ADMIN'] }},
  { path: 'usuario', component: ListagemDeUsuarioComponent, canActivate: [AuthGuard] , data: {permissoes: ['ROLE_USER','ROLE_ADMIN'] }},
  { path: 'cadastro-de-usuario', component: CadastroDeUsuarioComponent, canActivate: [AuthGuard] , data: {permissoes: ['ROLE_ADMIN'] }},
  { path: '**', redirectTo: '/' },
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
