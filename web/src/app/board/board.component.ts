import {Component, OnDestroy, OnInit} from '@angular/core';
import {BoardService} from "../service/board.service";
import {Board} from "../shared/model/board.model";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit, OnDestroy {

  private boardsSubscription: Subscription;

  public boards: Board[];

  constructor(private boardService: BoardService) {
    this.boards = [];
  }

  ngOnInit() {
    this.boardsSubscription = this.boardService.getBoards().subscribe(
      (boards: Board[]) => this.boards = boards
    );
  }

  ngOnDestroy(): void {
    this.boardsSubscription.unsubscribe();
  }

  joinTeam(board: string) {
    this.boardService.addMemberToBoard(board).subscribe(data => console.log(data));
  }
}
