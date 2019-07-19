import { Component, OnInit } from '@angular/core';

import { RandomQuoteService} from '../random-quote.service';
import {flatMap} from 'rxjs/operators';
import { Quote } from '../quote';
import { RandomColorService } from '../random-color.service';
import { Subject, forkJoin } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-quote-box',
  templateUrl: './quote-box.component.html',
  styleUrls: ['./quote-box.component.css']
})
export class QuoteBoxComponent implements OnInit {

  quote: Quote;
  color: string;
  newQuote$ = new Subject();

  constructor(
    private randomQuoteService: RandomQuoteService,
    private randomColorService: RandomColorService,
    private spinner: NgxSpinnerService
  ) {}

  ngOnInit(): void {
    this.spinner.show();
    this.newQuote$.pipe(
      flatMap(
        () => forkJoin(
                this.randomQuoteService.getRandomQuote(),
                this.randomColorService.getRandomColor())
              )
      ).subscribe(
          response => {
            this.quote = response[0];
            this.color = response[1];
          }
      );
    this.newQuote$.next();
  }

  getNewQuote() {
    this.quote = null;
    this.newQuote$.next();
  }
}
