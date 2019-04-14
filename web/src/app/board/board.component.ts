import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {

  navs: any[];

  constructor() { }

  ngOnInit() {
    this.navs = [
      {
        name: 'Create',
        link: 'create-board'
      },
      {
        name: 'Search',
        link: 'search-board'
      },
      {
        name: 'Summary',
        link: 'summary-board'
      }
    ]
  }

}
