import { ISearchResultShow } from './ISearchResultShow';

export class SearchResultShow {
  id: number;
  score: number;
  name: string;
  summary: string;
  genres: string;
  imageURL: string;

  constructor(obj: ISearchResultShow) {
    this.score =  obj.score;
    if (obj.show) {
      this.id =  obj.show.id;
      this.name = obj.show.name;
      this.summary =  obj.show.summary;
      this.genres =  obj.show.genres.join(' | ');
      if (obj.show.image && obj.show.image.medium) {
        this.imageURL = obj.show.image.medium;
      } else {
        this.imageURL = 'assets/No_image_available.svg';
      }
    }
  }
}
