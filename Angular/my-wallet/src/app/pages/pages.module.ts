import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroDeLancamentosComponent } from './cadastro-de-lancamentos/cadastro-de-lancamentos.component';
import {  FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { DropdownModule } from 'primeng/dropdown';
import {TooltipModule} from 'primeng/tooltip';
import { HomeComponent } from './home/home.component';
import { SelectButtonModule } from 'primeng/selectbutton';
import { CalendarModule } from 'primeng/calendar';
import { InputNumberModule } from 'primeng/inputnumber';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { CadastroDeUsuarioComponent } from './usuario/cadastro-de-usuario/cadastro-de-usuario.component';
import { ListagemDeUsuarioComponent } from './usuario/listagem-de-usuario/listagem-de-usuario.component';
import { LoginComponent } from './login/login.component';
import {AuthinterceptorInterceptor} from "./login/auth/authinterceptor.interceptor";
import {JwtHelperService, JwtModule} from "@auth0/angular-jwt";

export function tokenGetter() {
  return localStorage.getItem("token");
}

@NgModule({
  declarations: [
    LancamentosComponent,
    CadastroDeLancamentosComponent,
    HomeComponent,
    CadastroDeUsuarioComponent,
    ListagemDeUsuarioComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    TableModule,
    DropdownModule,
    TooltipModule,
    SelectButtonModule,
    InputTextModule,
    CalendarModule,
    InputNumberModule,
    HttpClientModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        allowedDomains: ["example.com"],
        disallowedRoutes: ["http://example.com/examplebadroute/"],
      },
    }),
  ],
  exports:[
  ],
  providers:[
    JwtHelperService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthinterceptorInterceptor,
      multi: true
    }
  ]
})
export class PagesModule { }
