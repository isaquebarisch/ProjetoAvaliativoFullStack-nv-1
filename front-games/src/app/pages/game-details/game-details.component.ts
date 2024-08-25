import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Game } from '../../models/game';

@Component({
  selector: 'app-game-details',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './game-details.component.html',
  styleUrl: './game-details.component.css'
})
export class GameDetailComponent implements OnInit {
  game!: Game;
  private apiUrl = "http://localhost:3000/games/";


  constructor(private http: HttpClient) { }


  ngOnInit(): void {
    const gameId = 1;
    this.http.get<Game>(`${this.apiUrl}${gameId}`)
    .subscribe({
      next: (data) => {
        console.log('Data received:', data);
        this.game = data;

      },
      error: (error) => {
        console.error('Error fetching game details', error);
      }
    });
  }



}
