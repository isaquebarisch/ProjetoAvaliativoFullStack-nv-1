import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Game } from '../models/game';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  private url = 'http://localhost:8080/games';

  constructor(private http:HttpClient) { }

  getGamesPageable(qnt: number): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.url}?size=${qnt}`)
  }

  getGame():Observable<Game[]>{
    return this.http.get<Game[]>(this.url);
  }

  getGameById(id:string|null): Observable<Game>{
    return this.http.get<Game>(`${this.url}/${id}`);
  }


  deleteGame(id:number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}
