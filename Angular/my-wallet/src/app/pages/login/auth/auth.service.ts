import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Auth } from './Auth';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url:string = 'http://localhost:8080/auth/oauth/token';

  constructor(private http: HttpClient,
              private router:Router) { }




  login(usuario:string, senha:string){

    const headers = new HttpHeaders()
    .append('Authorization', 'Basic YW5ndWxhcjoxMjM0NTY=')
    .append('Content-Type' , 'application/x-www-form-urlencoded');

    const body = new HttpParams()
    .set('username', usuario)
    .set('password', senha)
    .set('grant_type', 'password');

    console.log(body);

    this.http.post<Auth>(this.url, body, {headers, withCredentials:true}).subscribe({
      next: (response) => {
        console.log(response)
        localStorage.setItem('token', response.access_token);
        sessionStorage.setItem('token', response.access_token);
        this.router.navigate([''])
      },
      error: (err) => console.log('Error', err)
    });
  }


  logout(){}

  newToken(){}


}
