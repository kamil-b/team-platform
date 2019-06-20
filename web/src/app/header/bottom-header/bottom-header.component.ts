import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-bottom-header',
  templateUrl: './bottom-header.component.html',
  styleUrls: ['./bottom-header.component.scss']
})
export class BottomHeaderComponent implements OnInit {

  public navBars: any[];

  constructor() {}

  ngOnInit() {
    this.navBars = [
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
    ];
  }

}
