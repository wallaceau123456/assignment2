package com.rummyGame;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class RummyTest extends Applet 
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
	player.TilesAscendingOrderByNumber();
	player.printTiles();
	player.TilesAscesndingOrderByColor();
	System.out.println();
	player.printTiles();

	
	}
	
}
	
