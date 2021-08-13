window.addEventListener('load', function(e){
	console.log('script.js loaded');
	init();
});

function init() {
	//TODO
	loadGames();

	//Add a new Event Listener for the New Game Form
	document.newGameForm.addGame.addEventListener('click', function(e){
		e.preventDefault(); 
			
		//Create new JS Object
		let gm = document.newGameForm; //From the HTML Form for New Game
			
		let newGame = {
			title: gm.title.value,
			description: gm.description.value,
			platform: gm.platform.value,
			releaseYear: gm.releaseYear.value,
			price: gm.price.value,
			conditionGame: gm.conditionGame.value
		};
		newGame.length = gm.length.value;
		createGame(newGame);
			
	});


}

function loadGames() {
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/games');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4) {
			if(xhr.status === 201 || xhr.status === 200) {
				let games = JSON.parse(xhr.responseText);
				displayGames(games); 
			}
		}
	}

	xhr.send();
}//Load Games

function displayGames(games){
	let table = document.getElementById('gameTable');

	let tr = document.createElement('tr');

	//Title
	let th = document.createElement('th');
	th.textContent = "Title";
	tr.appendChild(th);

	//Description
	th = document.createElement('th');
	th.textContent = "Description";
	tr.appendChild(th);

	//Platform
	th = document.createElement('th');
	th.textContent = "Platform";
	tr.appendChild(th);

	//Release Year
	th = document.createElement('th');
	th.textContent = "Release Year";
	tr.appendChild(th);

	//Price
	th = document.createElement('th');
	th.textContent = "Price";
	tr.appendChild(th);

	//Condition
	th = document.createElement('th');
	th.textContent = "Condition";
	tr.appendChild(th);

	table.appendChild(tr);

	for (const game of games) {
		let tr = document.createElement('tr');

		//Title
		let td = document.createElement('td');
		td.textContent = game.title;
		tr.appendChild(td);

		//Description
		td = document.createElement('td');
		td.textContent = game.description;
		tr.appendChild(td);

		//Platform
		td = document.createElement('td');
		td.textContent = game.platform;
		tr.appendChild(td);

		//Release Year
		td = document.createElement('td');
		td.textContent = game.releaseYear;
		tr.appendChild(td);

		//Price
		td = document.createElement('td');
		td.textContent = "$" + game.price;
		tr.appendChild(td);

		//Condition
		td = document.createElement('td');
		td.textContent = game.conditionGame;
		tr.appendChild(td);

		table.appendChild(tr); 
	}

}//Display Games

//Create a New Game
function createGame(game) {
	
	let xhr = new XMLHttpRequest(); 
	
	xhr.open('POST', 'api/games');
	
	
	xhr.onreadystatechange = function(){
	
		 if(xhr.readyState === 4) {
		  if (xhr.status === 201 || xhr.status === 200) {
			console.log("New Game Added");
				let newGame = JSON.parse(xhr.responseText); //Parse JSON to JS Object
				displayGame(newGame); 
			}
				} else {
					console.error('Error creating game: ' + xhr.status);
						}
			
		}
		xhr.setRequestHeader("Content-type", "application/json");
		let gameJson = JSON.stringify(game);
		xhr.send(gameJson);
		
 }//Create Game