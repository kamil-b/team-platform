import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Board} from "../shared/model/board.model";
import {LoginService} from "./login.service";

@Injectable()
export class BoardService {

  constructor(private http: HttpClient, private loginService: LoginService) {
  }

  baseUrl: string = 'http://localhost:8080/api/';

  createBoard(board: Board) {
    return this.http.post(this.baseUrl + 'boards', board);
  }

  getBoards() {
    const token = this.loginService.getToken();
    console.log(token);
    return this.http.get(this.baseUrl + 'boards' + '?access_token=' + token);
  }

  addMemberToBoard(boardName: string) {
    return this.http.put(
      this.baseUrl + 'boards/addMember', {board: boardName, username: this.loginService.getUsername()}
    );
  }
}
