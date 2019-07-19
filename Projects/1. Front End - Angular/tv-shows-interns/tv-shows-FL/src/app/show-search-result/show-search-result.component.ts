import { Component, OnInit, Input } from '@angular/core';
import { SearchResultShow } from '../models/SearchResultShow';

@Component({
  selector: 'app-show-search-result',
  templateUrl: './show-search-result.component.html',
  styleUrls: ['./show-search-result.component.css']
})
export class ShowSearchResultComponent implements OnInit {

  @Input() searchResult: Array<SearchResultShow> = [];

  constructor() { }

  ngOnInit() {
  }
}
