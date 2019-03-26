import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {User} from "./model/user.model";

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/';

  login(loginPayload) {
    const headers = {
      'Authorization': 'Basic ' + btoa('kassad:kassad'),
      'Content-type': 'application/x-www-form-urlencoded',
      'accept': '*/*'
    };
    return this.http.post('http://localhost:8080/oauth/token', loginPayload, {headers});
  }

  isLogged(){
    return sessionStorage.getItem('token') !== null;
  }

  logout(){
    sessionStorage.removeItem('token');
  }


}
