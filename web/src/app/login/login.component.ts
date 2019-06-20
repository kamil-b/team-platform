import {FormControl, FormGroup} from "@angular/forms";
import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {HttpParams} from "@angular/common/http";
import {LoginService} from "../service/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  username: FormControl;
  password: FormControl;

  constructor(private loginService: LoginService,
              private router: Router) {
  }

  ngOnInit() {
    this.username = new FormControl('');
    this.password = new FormControl('');

    window.sessionStorage.removeItem('token');

    this.loginForm = new FormGroup({
      username: this.username,
      password: this.password,
    });
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const body = new HttpParams()
      .set('username', this.username.value)
      .set('password', this.password.value)
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('grant_type', 'password');

    console.log(body);

    this.loginService.login(body.toString()).subscribe(data => {
      this.loginService.setUserData(this.username.value, JSON.stringify(data));
      this.router.navigate(['home']);
    });
  }

  signUp() {
    this.router.navigate(['sign-up']);
  }
}
