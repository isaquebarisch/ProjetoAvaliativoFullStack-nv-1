import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CardGameComponent } from "./components/card-game/card-game.component";
import { AllGamesComponent } from "./pages/all-games/all-games.component";
import { HeaderComponent } from "./components/header/header.component";
import { FooterComponent } from "./components/footer/footer.component";
import { HomeComponent } from "./pages/home/home.component";
import { GameDetailComponent } from "./pages/game-details/game-details.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CardGameComponent, AllGamesComponent, HeaderComponent, FooterComponent, HomeComponent, GameDetailComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-games';
}
