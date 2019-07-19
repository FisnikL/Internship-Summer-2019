import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SearchResultShow } from '../models/SearchResultShow';
import { distinctUntilChanged, debounceTime, switchMap, flatMap } from 'rxjs/operators';
import { ShowService } from '../show.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-show-search',
  templateUrl: './show-search.component.html',
  styleUrls: ['./show-search.component.css']
})
export class ShowSearchComponent implements OnInit {

  searchForm = new FormGroup({
    searchTerm: new FormControl('')
  });
  showSearchResult: Array<SearchResultShow> = [];

  search$ = new Subject();

  constructor(private showSearchService: ShowService) { }

  ngOnInit(): void {
    this.search$.pipe(
      flatMap(
        () => this.searchTerm.valueChanges.pipe(
          debounceTime(300),
          distinctUntilChanged(),
          switchMap((term: string) => this.showSearchService.searchShows(term))
        )
      )
    ).subscribe(
      result => {
        this.showSearchResult = result;
      }
    );
    this.search$.next();
  }

  get searchTerm(): FormControl {
    return (this.searchForm.get('searchTerm') as FormControl);
  }

  onSubmit() {
    this.search$.next();
  }
}
