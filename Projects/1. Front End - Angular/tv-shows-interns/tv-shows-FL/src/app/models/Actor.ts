import { IActor } from './IActor';

export class Actor {
  imageURL: string;
  name: string;

  constructor(actor: IActor) {
    if (actor.person.image && actor.person.image.medium) {
      this.imageURL = actor.person.image.medium;
    } else {
      this.imageURL = 'assets/No_image_available.svg';
    }
    this.name =  actor.person.name;
  }
}

