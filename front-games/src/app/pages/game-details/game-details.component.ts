import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Game } from '../../models/game';
import { GameService } from '../../services/game.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-game-details',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './game-details.component.html',
  styleUrl: './game-details.component.css'
})
export class GameDetailComponent implements OnInit {
  game?: Game;
  gameId : string | null = null;

  constructor(private gameService: GameService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.gameId = params.get('id')
    })
    this.getGame();
  }

  getGame(): void {
    this.gameService.getGameById(this.gameId).subscribe(
      (response) => {
        this.game = response;
      },
      (error) => {
        console.error('Erro ao carregar os dados: ', error);
      }
    );
  }
}
