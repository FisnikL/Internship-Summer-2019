import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ShowService } from '../show.service';
import { ShowDetails } from '../models/ShowDetails';
import { Episode } from '../models/Episode';
import { Actor } from '../models/Actor';
import { NO_DATA } from '../models/NO_DATA';

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {
  show: ShowDetails;
  cast: Actor[] = [];
  episodes: Episode[] = [];

  constructor(
    private route: ActivatedRoute,
    private showService: ShowService) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.showService
      .getShowDetails(id)
      .subscribe(
        show => this.show = show
      );

    this.showService
      .getShowCast(id)
      .subscribe(
        cast => this.cast = cast
      );

    this.showService
      .getShowEpisodes(id)
      .subscribe(
        episodes => this.episodes = episodes
      );
  }


  get NO_DATA() {
    return NO_DATA;
  }
}
