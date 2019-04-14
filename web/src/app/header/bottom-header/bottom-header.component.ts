import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-bottom-header',
  templateUrl: './bottom-header.component.html',
  styleUrls: ['./bottom-header.component.scss']
})
export class BottomHeaderComponent implements OnInit {

  @Input() navBars: any[] = [];

  constructor() { }

  ngOnInit() {
  }

}
