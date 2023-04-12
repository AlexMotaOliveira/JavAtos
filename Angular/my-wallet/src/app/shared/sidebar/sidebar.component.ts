import { Component } from '@angular/core';
import {AuthService} from "../../pages/login/auth/auth.service";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {

  constructor(private auth:AuthService) {
  }

  visibleSidebar1 = false;

  validaPermissao(permissao:string){
    return this.auth.validaPermissao(permissao);
  }

  logout(){
    this.auth.logout();
  }

}
