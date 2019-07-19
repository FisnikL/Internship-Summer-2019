import { Injectable } from '@angular/core';
import { ThrowStmt } from '@angular/compiler';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RandomColorService {
  colors = [
    '#16a085', '#27ae60', '#2c3e50',
    '#f39c12', '#e74c3c', '#9b59b6',
    '#FB6964', '#342224', '#472E32',
    '#BDBB99', '#77B1A9', '#73A857'
  ];
  used = [];

  constructor() { }

  getRandomColor(): Observable<string> {
    return of(this.generateRandomColor());
  }

  generateRandomColor() {
    if (this.colors.length === 0) {
      this.colors = this.used;
      this.used = [];
    }
    const index = Math.floor(Math.random() * this.colors.length);
    const color = this.colors[index];
    this.used.push(this.colors[index]);
    this.colors.splice(index, 1);

    return color;
  }
}
