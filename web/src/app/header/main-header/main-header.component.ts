import {Component, OnInit} from '@angular/core';
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.scss']
})
export class HeaderComponent implements OnInit {

  public username;

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
    this.username = this.loginService.getUsername();
  }

  isLogged() {
    return this.loginService.isLogged();
  }

  logout() {
    this.loginService.logout();

  }
}
