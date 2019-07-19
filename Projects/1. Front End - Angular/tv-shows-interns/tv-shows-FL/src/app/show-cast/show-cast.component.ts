import { Component, Input } from '@angular/core';
import { Actor } from '../models/Actor';

@Component({
  selector: 'app-show-cast',
  templateUrl: './show-cast.component.html',
  styleUrls: ['./show-cast.component.css']
})
export class ShowCastComponent {
  @Input() cast: Actor[];
  constructor() { }
}
