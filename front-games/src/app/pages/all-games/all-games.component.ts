import { Component, Input } from '@angular/core';
import { Game } from '../../models/game';
import { CardGameComponent } from '../../components/card-game/card-game.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-all-games',
  standalone: true,
  imports: [CardGameComponent, CommonModule],
  templateUrl: './all-games.component.html',
  styleUrl: './all-games.component.css'
})
export class AllGamesComponent {
  @Input() games : Game[] = [
    {
      id: 0,
    name: 'The Last of Us',
    image: ["https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/0kRqUeSBIbQzz7cen3c989c6.jpg"],
    category: 'Survival',
    description:'',
    platform: '',
    price: 0,
    ageRating: 0,
    releaseYear: 0,
    developer: '',
    publisher: '',
    rating:  0
    },
    {
      id: 0,
    name: 'The Last of Us',
    image: ["https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/0kRqUeSBIbQzz7cen3c989c6.jpg"],
    category: 'Survival',
    description:'',
    platform: '',
    price: 0,
    ageRating: 0,
    releaseYear: 0,
    developer: '',
    publisher: '',
    rating:  0
    },
    {
      id: 0,
    name: 'The Last of Us',
    image: ["https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/0kRqUeSBIbQzz7cen3c989c6.jpg"],
    category: 'Survival',
    description:'',
    platform: '',
    price: 0,
    ageRating: 0,
    releaseYear: 0,
    developer: '',
    publisher: '',
    rating:  0
    }
  ];
}
