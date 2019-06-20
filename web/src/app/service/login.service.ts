import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class LoginService {

  private static username: string;

  constructor(private http: HttpClient) {
  }


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

  getUsername() {
    return localStorage.getItem('username');
  }

  getToken() {
    if (this.isLogged()) {
      return JSON.parse(localStorage.getItem('token')).access_token;
    }
  }

  setUserData(username: string, token) {
    localStorage.setItem('token', token);
    localStorage.setItem('username', username);
  }
}
