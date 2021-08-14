import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Game } from '../models/game';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  baseUrl = 'http://localhost:8090/';
  url = this.baseUrl + 'api/games';

  constructor(
    private http : HttpClient
  ) { }

  index() : Observable<Game[]> {
    return this.http.get<Game[]>(this.url).pipe(
      catchError( (err:any) => {
        console.error('GameService.index(): error retrieving game list');
        return throwError(err);
      })
    );
  }

}
