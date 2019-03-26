import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  quotes: [];

  constructor() { }

  ngOnInit() {
    this.quotes = [
      'Your limitation—it\'s only your imagination.',
      'Push yourself, because no one else is going to do it for you.',
      'Great things never come from comfort zones.'
    ];
  }

  /**
   * Returns a random number between min (inclusive) and max (exclusive)
   */
  getRandomQuote(){
    return this.quotes[HomeComponent.getRandomInt(0, this.quotes.length)]
  }

  static getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
}
