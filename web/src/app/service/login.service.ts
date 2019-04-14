import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class LoginService {

  private username;

  constructor(private http: HttpClient) {
  }

  baseUrl: string = 'http://localhost:8080/';

  login(loginPayload) {
    const headers = {
      'Authorization': 'Basic ' + btoa('kassad:kassad'),
      'Content-type': 'application/x-www-form-urlencoded',
      'accept': '*/*'
    };
    return this.http.post('http://localhost:8080/oauth/token', loginPayload, {headers});
  }

  isLogged() {
    return localStorage.getItem('token') !== null;
  }

  logout() {
    localStorage.removeItem('token');
  }

  getUsername(){
    return this.username;
  }

  setUserData(username, token) {
    localStorage.setItem('token', token);
    this.username = username;
  }
}
