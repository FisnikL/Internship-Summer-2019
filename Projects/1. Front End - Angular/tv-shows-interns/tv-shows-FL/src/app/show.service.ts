import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { SearchResultShow } from './models/SearchResultShow';
import { ShowDetails } from './models/ShowDetails';
import { Episode } from './models/Episode';
import { Actor } from './models/Actor';
import { ISearchResultShow } from './models/ISearchResultShow';
import { IShowDetails } from './models/IShowDetails';
import { IEpisode } from './models/IEpisode';
import { IActor } from './models/IActor';




const BASE_URL = 'http://api.tvmaze.com';

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  constructor(private http: HttpClient) { }

  searchShows(searchTerm: string): Observable<SearchResultShow[]> {
    if (!searchTerm.trim()) {
      return of([]);
    }
    return this.http.get<ISearchResultShow[]>(`${BASE_URL}/search/shows?q=${searchTerm}`)
      .pipe(
        map(array => array.map(
          ISearchedShowObj => new SearchResultShow(ISearchedShowObj)
        ))
      );
  }

  getShowDetails(id: number): Observable<ShowDetails> {
    return this.http.get<IShowDetails>(`${BASE_URL}/shows/${id}`)
        .pipe(
            map(IShowDetailsObj => new ShowDetails(IShowDetailsObj)),
        );
  }

  getShowEpisodes(id: number): Observable<Episode[]> {
    return this.http.get<IEpisode[]>(`${BASE_URL}/shows/${id}/episodes`)
        .pipe(
            map(IEpisodeArray => IEpisodeArray.map(
              IEpisodeObj => new Episode(IEpisodeObj)
            )),
        );
  }

  getShowCast(id: number): Observable<Actor[]> {
    return this.http.get<IActor[]>(`${BASE_URL}/shows/${id}/cast`)
        .pipe(
            map(ICastArray => ICastArray.map(
              IActorObj => new Actor(IActorObj)
            )),
        );
  }
}
