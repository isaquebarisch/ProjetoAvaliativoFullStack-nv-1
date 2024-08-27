import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CardGameComponent } from '../../components/card-game/card-game.component';
import { Game } from '../../models/game';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, CardGameComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  games: Game[] = [];

  constructor(private gameService: GameService) {}


  ngOnInit() {
    this.getGames();
  }

  getGames() {
    this.gameService.getGame().subscribe((games: Game[]) => {
      this.games = games.slice(0, 9);
    });
  }
}
