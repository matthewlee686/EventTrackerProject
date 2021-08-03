# EventTrackerProject

### Full-Stack Spring/REST/JPA Project for Skill Distillery

## Overview
### Description

This Application serves to represent a mock Game Store. Users of this App will be able to search for a game, add it to their cart or wishlist, and finally purchase it through the App's built-in transaction system.

While the User has limited permissions, the Employees of the Game Store are able to log in to create new games which will add to the App's virtual inventory. Employees will also be able to update existing game stock information (for example if there is a sale --> update the price), and remove games from the inventory.


## REST Endpoints

| Method | URI                | Request Body | Response Body |
|--------|--------------------|--------------|---------------|
| GET    | `/api/games`       |              | Collection that represents all inventory of games
| GET    | `/api/games/{id}`  | Game ID       | Single Game entity
| POST   | `/api/games`       | Game          | Game that was created
| PUT    | `/api/games/{id}`  | Game          | Updated Game Entity
| DELETE | `/api/games/{id}`  | Game ID       | True or False
