import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {User} from "./model/user.model";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  baseUrl: string = 'http://localhost:8080/';


  createUser(user: User){
    return this.http.post(this.baseUrl + 'users', user);
  }


  /*  getUsers() {
    return this.http.get(this.baseUrl + 'user?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }

  getUserById(id: number) {
    return this.http.get(this.baseUrl + 'user/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }



  updateUser(user: User): Observable {
    return this.http.put(this.baseUrl + 'user/' + user.id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, user);
  }

  deleteUser(id: number){
    return this.http.delete(this.baseUrl + 'user/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }*/
}
