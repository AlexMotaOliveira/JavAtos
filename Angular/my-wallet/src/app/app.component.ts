import { Component } from '@angular/core';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'my-wallet';

  constructor(private router:Router){

  }


  isRouteLogin(){
    return this.router.url !== '/login';
  }
}
