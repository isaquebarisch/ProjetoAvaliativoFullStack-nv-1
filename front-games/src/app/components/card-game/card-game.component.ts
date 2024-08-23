import { Component, Input } from '@angular/core';
import { Game } from '../../models/game';

@Component({
  selector: 'app-card-game',
  standalone: true,
  imports: [],
  templateUrl: './card-game.component.html',
  styleUrl: './card-game.component.css'
})
export class CardGameComponent {
  @Input() game: Game = {
    id: 0,
    name: '',
    image: ["https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/0kRqUeSBIbQzz7cen3c989c6.jpg","https://upload.wikimedia.org/wikipedia/pt/b/be/The_Last_of_Us_capa.png","https://super.abril.com.br/wp-content/uploads/2023/03/lastofus-1.jpg?crop=1&resize=1212,909"],
    category: '',
    description:'',
    platform: '',
    price: 0,
    ageRating: 0,
    releaseYear: 0,
    developer: '',
    publisher: '',
    rating:  0
  }
}
