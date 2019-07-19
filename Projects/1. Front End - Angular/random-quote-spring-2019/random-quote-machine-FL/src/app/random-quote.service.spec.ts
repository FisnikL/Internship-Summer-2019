import { TestBed } from '@angular/core/testing';

import { RandomQuoteService } from './random-quote.service';

describe('RandomQuoteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RandomQuoteService = TestBed.get(RandomQuoteService);
    expect(service).toBeTruthy();
  });
});
