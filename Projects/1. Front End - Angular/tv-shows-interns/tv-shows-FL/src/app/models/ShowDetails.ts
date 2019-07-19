import { IShowDetails } from './IShowDetails';
import { NO_DATA } from './NO_DATA';

export class ShowDetails {
  id: number;
  name: string;
  showURL: string;
  imageURL: string;
  summary: string;
  language: string;
  genres: string;
  status: string;
  premiered: string;
  officialSite: string;

  constructor(showDetails: IShowDetails) {
    this.id = showDetails.id;
    this.name = showDetails.name;
    this.showURL = showDetails.url;
    this.summary = showDetails.summary;
    this.language = showDetails.language ? showDetails.language : NO_DATA;
    this.genres = showDetails.genres.length ? showDetails.genres.toString() : NO_DATA;
    this.status = showDetails.status ? showDetails.status : NO_DATA;
    this.premiered = showDetails.premiered ? showDetails.premiered : NO_DATA;
    this.officialSite = showDetails.officialSite ? showDetails.officialSite : null;
    if (showDetails.image && showDetails.image.medium) {
      this.imageURL = showDetails.image.medium;
    } else {
      this.imageURL = 'assets/No_image_available.svg';
    }
  }
}
