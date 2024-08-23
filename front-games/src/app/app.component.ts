import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CardGameComponent } from "./components/card-game/card-game.component";
import { AllGamesComponent } from "./pages/all-games/all-games.component";
import { HeaderComponent } from "./components/header/header.component";
import { FooterComponent } from "./components/footer/footer.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CardGameComponent, AllGamesComponent, HeaderComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-games';
}
