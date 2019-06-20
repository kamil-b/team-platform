import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {BoardService} from "../../service/board.service";
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-create-board',
  templateUrl: './create-board.component.html',
  styleUrls: ['./create-board.component.scss']
})
export class CreateBoardComponent implements OnInit {

  public boardForm: FormGroup;
  public name: FormControl;
  public description: FormControl;

  constructor(private boardService: BoardService, private loginService: LoginService) {
  }

  ngOnInit() {
    this.name = new FormControl('');
    this.description = new FormControl('');

    this.boardForm = new FormGroup({
      name: this.name,
      description: this.description,
    });
  }

  onSubmit() {
    if (this.boardForm.valid) {
      console.log(this.loginService.getUsername());
      this.boardService.createBoard(
        {
          name: this.name.value,
          ownerName: this.loginService.getUsername(),
          members: []
        }
      ).subscribe(
        data => console.log(data)
      );
    }
  }
}
