import { Component, OnInit, Input } from '@angular/core';
import { Episode } from '../models/Episode';

@Component({
  selector: 'app-show-episodes',
  templateUrl: './show-episodes.component.html',
  styleUrls: ['./show-episodes.component.css']
})
export class ShowEpisodesComponent implements OnInit {

  @Input() episodes: Episode[];

  constructor() { }

  ngOnInit() {
  }

}
