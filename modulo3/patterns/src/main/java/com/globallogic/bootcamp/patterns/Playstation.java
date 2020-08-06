package com.globallogic.bootcamp.patterns;

public class Playstation {

	Game videogame;
	
	public Playstation(String name) {videogame = new Game(name); }

	public String askMyGame() {
		if(videogame != null)
			return "El videojuego que estoy corriendo es: " + videogame.title;
		else
			return "Estoy vacío!";
	}

	public void setVideogame(Game videogame) {
		this.videogame = videogame;
	}
}
