import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "../service/login.service";
import {User} from "../service/model/user.model";
import {Router} from "@angular/router";
import {take} from "rxjs/internal/operators";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  registerForm: FormGroup;
  username: FormControl;
  password: FormControl;
  repeatPassword: FormControl;

  constructor(private fb: FormBuilder,
              private userService: UserService,
              private router: Router) {
  }

  ngOnInit() {

    this.username = new FormControl('');
    this.password = new FormControl('');
    this.repeatPassword = new FormControl('');

    this.registerForm = this.fb.group({
      username: [this.username.value, Validators.minLength(6)],
      password: [this.password.value, Validators.minLength(6)],
      repeatPassword: [this.repeatPassword.value, Validators.minLength(6)]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      this.userService.createUser(new User(
        this.registerForm.controls['username'].value,
        this.registerForm.controls['password'].value
      )).pipe(take(1)).subscribe(
        data => {
          console.log('user created: ', data);
          this.router.navigate(['home']);
        }
      )
    }
  }

  passwordsMatch() {
    if (this.registerForm.controls['password'].dirty && this.registerForm.controls['repeatPassword'].dirty) {
      return this.registerForm.controls['password'].value === this.registerForm.controls['repeatPassword'].value
    }
    return true;
  }
}
