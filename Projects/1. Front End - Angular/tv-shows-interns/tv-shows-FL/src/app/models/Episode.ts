import { IEpisode } from './IEpisode';

export class Episode {
  season: number;
  number: number;
  name: string;

  constructor(episode: IEpisode) {
    this.season = episode.season;
    this.number = episode.number;
    this.name = episode.name ? episode.name : 'Unknown';
  }

  get episode() {
    return `S${this.season}E${this.number} ${this.name}`;
  }
}
