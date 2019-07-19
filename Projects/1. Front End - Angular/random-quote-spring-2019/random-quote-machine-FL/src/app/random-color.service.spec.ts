import { TestBed } from '@angular/core/testing';

import { RandomColorService } from './random-color.service';

describe('RandomColorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RandomColorService = TestBed.get(RandomColorService);
    expect(service).toBeTruthy();
  });
});
