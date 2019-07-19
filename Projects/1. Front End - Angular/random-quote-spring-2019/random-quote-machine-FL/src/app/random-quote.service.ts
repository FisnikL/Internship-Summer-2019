import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quote } from './quote';
import { map, debounceTime, delay } from 'rxjs/operators';
import { RandomColorService } from './random-color.service';

@Injectable({
  providedIn: 'root'
})
export class RandomQuoteService {
  private api = 'https://thesimpsonsquoteapi.glitch.me/quotes';

  constructor(
    private http: HttpClient
    ) { }

  getRandomQuote(): Observable<Quote> {
    return this.http
              .get(this.api)
              .pipe(
                map(quoteList => quoteList[0]),
                map(quote => new Quote(quote.quote, quote.character))
              );
  }
}
