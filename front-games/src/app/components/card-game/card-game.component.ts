import { Component, Input } from '@angular/core';
import { Game } from '../../models/game';
import { RouterLink } from '@angular/router';
import { GameService } from '../../services/game.service';
import { AllGamesComponent } from '../../pages/all-games/all-games.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-game',
  standalone: true,
  imports: [RouterLink, AllGamesComponent, CommonModule],
  templateUrl: './card-game.component.html',
  styleUrl: './card-game.component.css'
})
export class CardGameComponent {
  @Input() game: Game = {
    id: 0,
    name: '',
    image: [] = [""],
    category: [],
    description:'',
    platform: [] = [""],
    price: 0,
    ageRating: 0,
    releaseYear: 0,
    developer: '',
    publisher: '',
    rating:  0
  }

  constructor(private gameService: GameService) {}

  deleteGame(id: number) {
    if (confirm('Você tem certeza que deseja excluir este jogo?')) {
      this.gameService.deleteGame(id).subscribe(response => {
        if (response.status === 'Ok') {
          console.log("delete ok")
        }
      });
    }
  }
}
