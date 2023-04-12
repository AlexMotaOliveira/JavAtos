import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Auth} from './Auth';
import {Router} from '@angular/router';
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private jwtPayload: any;

  private url: string = 'http://localhost:8080/auth/oauth/token';

  constructor(private http: HttpClient,
              private router: Router,
              private jwtConvert: JwtHelperService) {
    this.recuperarjwtPayload();
  }


  login(usuario: string, senha: string) {

    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YW5ndWxhcjoxMjM0NTY=') //TODO mudar para variavel de ambiente
      .append('Content-Type', 'application/x-www-form-urlencoded');

    const body = new HttpParams()
      .set('username', usuario)
      .set('password', senha)
      .set('grant_type', 'password');

    console.log(body);

    this.http.post<Auth>(this.url, body, {headers, withCredentials: true}).subscribe({
      next: (response) => {
        console.log(response)
        let jwt = response.access_token;
        localStorage.setItem('token', jwt);
        this.addJwtPayload(jwt);
        // sessionStorage.setItem('token', response.access_token);
        this.router.navigate([''])
      },
      error: (err) => console.log('Error', err)
    });
  }

  validaPermissao(permisao: string) {
    console.log(this.jwtPayload.authorities)
     return this.jwtPayload.authorities.includes(permisao)
  }

  validaPermissoes(permissoes: string[]) {
    for (const permissao of permissoes) {
      if (this.validaPermissao(permissao)){
        return true;
      }
    }
    return false;
  }



  addJwtPayload(jwt: string) {
    this.jwtPayload = this.jwtConvert.decodeToken(jwt);
    console.log(this.jwtPayload);
  }

  recuperarjwtPayload(){
    const token = localStorage.getItem('token')!;
    if (this.addJwtPayload === null){
      this.addJwtPayload(token);
    }
  }

  logout() {
    localStorage.clear()
    console.log("saiiiiir")
    //TODO excluir o token no backend
  }

  refreshToken() {
  }


}
