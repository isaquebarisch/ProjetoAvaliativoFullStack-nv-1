import { Routes } from '@angular/router';
import { AllGamesComponent } from './pages/all-games/all-games.component';
import { GameDetailComponent } from './pages/game-details/game-details.component';
import { HomeComponent } from './pages/home/home.component';
import { GameModalComponent } from './components/game-modal/game-modal.component';

export const routes: Routes = [

  //faca as rotas com path e component
 { path: 'home', component: HomeComponent },
 { path: 'allGames', component: AllGamesComponent },
 { path: 'gameDetails/:id', component: GameDetailComponent  },
 { path: 'createGame', component: GameModalComponent },
 { path: '', redirectTo: 'home', pathMatch: 'full' }






];
