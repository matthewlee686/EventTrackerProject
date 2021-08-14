import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';
import { GameService } from 'src/app/services/game.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  games : Game[] = [];

  constructor(
    private gameService : GameService
  ) { }

  ngOnInit(): void {

    //Will Load List of Games upon Initialization
    this.loadGames();

  }

  loadGames() {
    this.gameService.index().subscribe(
      games => {
        this.games = games;
      },
      fail => {
        console.error('GameListComponent.loadGames(): error loading games');
      });
  }

}//Component Class
