package com.RummyGame;

public class RummyTest 
{
	public static void main(String[] args)
	{
	RummyDeck deck = new RummyDeck(true);
	deck.print(104);
	Player player = new Player("Wallace");
	
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.draw(deck.myNextTiles());
	player.printTiles();
	
	
	}
}
	
