import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LancamentosComponent } from './pages/lancamentos/lancamentos.component';
// import { HomeComponent } from './teste/home/home.component';
import { FormularioComponent } from './teste/formulario/formulario.component';
import { CadastroDeLancamentosComponent } from './pages/cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'lancamentos', component: LancamentosComponent },
  {
    path: 'cadastro-de-lancamentos',
    component: CadastroDeLancamentosComponent,
  },
  // {path:'formulario', component: FormularioComponent},
  { path: 'home', component: HomeComponent },
  { path: '**', redirectTo: '/' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
