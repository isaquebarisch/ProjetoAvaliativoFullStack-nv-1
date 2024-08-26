import { Component, Input } from '@angular/core';
import { Game } from '../../models/game';
import { CardGameComponent } from '../../components/card-game/card-game.component';
import { CommonModule } from '@angular/common';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-all-games',
  standalone: true,
  imports: [CardGameComponent, CommonModule],
  templateUrl: './all-games.component.html',
  styleUrl: './all-games.component.css'
})
export class AllGamesComponent {
  games: Game[] = [];

  constructor(private gameService: GameService) {}
  ngOnInit(): void {
    this.getGames();
  }

  getGames(): void {
    this.gameService.getGame().subscribe(
      (response) => {
        this.games = response;
        console.log(response);
      },
      (error) => {
        console.error('Erro ao carregar os dados: ', error);
      }
    );
  }
}
