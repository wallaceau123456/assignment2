package com.rummyGame;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testOrderByColor() {
		Player player = new Player("player");
		player.draw(new Tiles(TilesColor.Blue, 1));
		player.draw(new Tiles(TilesColor.Red, 1));
		player.draw(new Tiles(TilesColor.Green, 1));
		player.draw(new Tiles(TilesColor.Orange, 1));
		player.draw(new Tiles(TilesColor.Red, 2));
		player.TilesAscendingOrderByColor();

		Assert.assertEquals("Incorrect tile color", TilesColor.Red, player.theTiles()[0].theColor());
		Assert.assertEquals("Incorrect tile color", TilesColor.Red, player.theTiles()[1].theColor());
		Assert.assertEquals("Incorrect tile color", TilesColor.Green, player.theTiles()[2].theColor());
		Assert.assertEquals("Incorrect tile color", TilesColor.Blue, player.theTiles()[3].theColor());
		Assert.assertEquals("Incorrect tile color", TilesColor.Orange, player.theTiles()[4].theColor());
	}
	/*
	@Test
	public void testOrderByvalue(){
		Player player = new Player("player");
		Tiles tiles1= new Tiles(TilesColor.Blue, 1);
		Tiles tiles2=new Tiles(TilesColor.Red, 1);
		Tiles tiles3=new Tiles(TilesColor.Red, 3);
		Tiles tiles4= new Tiles(TilesColor.Green, 1);
		Tiles tiles5= new Tiles(TilesColor.Orange, 1);
		Tiles tiles6= new Tiles(TilesColor.Red, 5);
		Tiles tiles7= new Tiles(TilesColor.Green, 4);
		player.draw(tiles1);
		player.draw(tiles2);
		player.draw(tiles3);
		player.draw(tiles4);
		player.draw(tiles5);
		player.draw(tiles6);
		player.draw(tiles7);
		player.TilesAscendingOrderByNumber();
		Assert.assertEquals("incorrect tile number", tiles2.theNumberOfTiles(),player.theTiles()[0].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles3.theNumberOfTiles(),player.theTiles()[1].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles6.theNumberOfTiles(),player.theTiles()[2].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles4.theNumberOfTiles(),player.theTiles()[3].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles7.theNumberOfTiles(),player.theTiles()[4].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles1.theNumberOfTiles(),player.theTiles()[5].theNumberOfTiles());
		Assert.assertEquals("incorrect tile number", tiles5.theNumberOfTiles(),player.theTiles()[6].theNumberOfTiles());
	}*/
	
	@Test
	public void testdrawTiles()
	{
		Player player= new Player("player");
		Tiles tiles= new Tiles(TilesColor.Blue,1);
		
		player.draw(tiles);
		Assert.assertEquals("Incorrect draw tiles", tiles,player.theTiles()[0]);

		
	}
	
	@Test
	public void testInitial30()
	{
		Player humanPlayer=new Player("Player");
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green, 10);
		Tiles tiles4= new Tiles(TilesColor.Red,11);
		Tiles tiles5= new Tiles(TilesColor.Red,1);
		Tiles tiles6= new Tiles(TilesColor.Red,2);
		Tiles tiles7= new Tiles(TilesColor.Red,3);
		Tiles tiles8= new Tiles(TilesColor.Green,8);
		Tiles tiles9= new Tiles(TilesColor.Green,8);
		Tiles tiles10= new Tiles(TilesColor.Green, 8);
		
		Tiles tiles11= new Tiles(TilesColor.Red,1);
		
		Tiles tiles12= new Tiles(TilesColor.Red,3);
		Tiles tiles13= new Tiles(TilesColor.Red,4);
		Tiles tiles14= new Tiles(TilesColor.Red,5);
		Tiles tiles15= new Tiles(TilesColor.Red,6);
		Tiles tiles16= new Tiles(TilesColor.Red,7);
		Tiles tiles17= new Tiles(TilesColor.Red,8);
		Tiles tiles18= new Tiles(TilesColor.Red,9);
		Tiles tiles19= new Tiles(TilesColor.Red,10);
		Tiles tiles20= new Tiles(TilesColor.Red,11);
		Tiles tiles21= new Tiles(TilesColor.Red,2);

		
		humanPlayer.addTilesOnInitial30(tiles1.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles2.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles3.theNumberOfTiles());
		Assert.assertEquals("Incorrect number Of Initial30 for exactly 30 points", humanPlayer.getInitial30(),30);
		humanPlayer.initial30ToZero();
		humanPlayer.addTilesOnInitial30(tiles1.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles2.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles3.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles4.theNumberOfTiles());
		Assert.assertEquals("Incorrect number Of Initial30 for more than 30 points", humanPlayer.getInitial30(),41);
		
		//player then plays another melds
		humanPlayer.addTilesOnInitial30(tiles5.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles6.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles7.theNumberOfTiles());
		Assert.assertEquals("Incorrect number Of Initial30 for more than 30 points with serveral melds", humanPlayer.getInitial30(),47);
		
		//player plays serveral melds with exactly 30 points
		humanPlayer.initial30ToZero();

		humanPlayer.addTilesOnInitial30(tiles5.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles6.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles7.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles8.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles9.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles10.theNumberOfTiles());

		Assert.assertEquals("Incorrect number Of Initial30 for exactly 30 points with serveral melds", humanPlayer.getInitial30(),30);
		
		//player plays serveral melds with winning the game
		humanPlayer.initial30ToZero();

		humanPlayer.addTilesOnInitial30(tiles8.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles9.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles10.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles11.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles12.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles13.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles14.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles15.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles16.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles17.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles18.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles19.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles20.theNumberOfTiles());
		humanPlayer.addTilesOnInitial30(tiles21.theNumberOfTiles());

		
		Assert.assertEquals("Incorrect number Of Initial30 for more than 30 points with winning the game", humanPlayer.getInitial30(),90);
	}
	@Test
	public void P1Draw()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,1);
		game.getAIPlayer(1).draw(tiles1);
		
		Assert.assertEquals("Incorrect tiles after draw the tiles", tiles1,game.getAIPlayer(1).theTiles()[0]);

	}
	@Test
	public void P3Initial30()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,11);
		Tiles tiles2= new Tiles(TilesColor.Red,11);
		Tiles tiles3= new Tiles(TilesColor.Green,11);
		
		game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);

		game.AIplayer3Play();
		
		Assert.assertEquals("Incorrect 30+ points", game.getAIPlayer(3).getInitial30(),33);

	}
	
	@Test
	public void P3WinTheGameNotUsingTable()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,11);
		Tiles tiles2= new Tiles(TilesColor.Red,11);
		Tiles tiles3= new Tiles(TilesColor.Green,11);

		game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);
		game.AIplayer3Play();
		
		Assert.assertEquals("Player 3 wins the game not using by table is incorrect", game.getAIPlayer(3).getNumTiles(),0);
	}

	@Test
	public void P3ThreeCardsNotMeet()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Blue,11);
		Tiles tiles2= new Tiles(TilesColor.Red,11);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Green,5);
		Tiles tiles7= new Tiles(TilesColor.Green,6);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(1).draw(tiles4);
		game.getAIPlayer(1).draw(tiles5);
		game.AIplayer1Play();
		
		game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);
		game.getAIPlayer(3).draw(tiles4);
		game.getAIPlayer(3).draw(tiles5);
		game.AIplayer3Play();


		Assert.assertEquals("Player 3 incorrect tiles on hand after draw", game.getAIPlayer(3).getNumTiles(),6);

		
	}
	
	@Test
	public void AIPlayerAddTileToRun()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Red,10);
		Tiles tiles2= new Tiles(TilesColor.Red,11);
		Tiles tiles3= new Tiles(TilesColor.Red,12);
		Tiles tiles4= new Tiles(TilesColor.Red,9);
		
		game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		
		game.AIplayer1Play();

		game.AIplayer3Play();
		game.getAIPlayer(1).draw(tiles4);
		game.AIplayer1Play();
		
		Assert.assertEquals("Player 1 incorrect put tiles in the table Run", tiles4,game.getTable()[0].theMeld()[0]);

		

		
	}
	
	@Test
	public void AIPlayerAddTileToSet()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Red,10);
		Tiles tiles2= new Tiles(TilesColor.Green,10);
		Tiles tiles3= new Tiles(TilesColor.Blue,10);
		Tiles tiles4= new Tiles(TilesColor.Orange,10);
		
		game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		
		game.AIplayer1Play();

		game.AIplayer3Play();
		game.getAIPlayer(1).draw(tiles4);
		game.AIplayer1Play();
		
		Assert.assertEquals("Player 1 incorrect put tiles in the table Set", tiles4,game.getTable()[0].theMeld()[3]);

	}
	
	@Test
	public void P2PlaysInitial30()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Red,10);
		Tiles tiles2= new Tiles(TilesColor.Green,10);
		Tiles tiles3= new Tiles(TilesColor.Blue,10);
		Tiles tiles4= new Tiles(TilesColor.Orange,10);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(2).draw(tiles1);
		game.getAIPlayer(2).draw(tiles2);
		game.getAIPlayer(2).draw(tiles3);
		
		game.AIplayer1Play();

		game.AIplayer2Play();
		Assert.assertEquals("Incorrect to play Initial 30 for P2", tiles1,game.getTable()[1].theMeld()[0]);
		Assert.assertEquals("Incorrect to play Initial 30 for P2", tiles2,game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect to play Initial 30 for P2", tiles3,game.getTable()[1].theMeld()[2]);

	}
	
	@Test
	public void P2Draw()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Red,10);
		Tiles tiles2= new Tiles(TilesColor.Green,10);
		Tiles tiles3= new Tiles(TilesColor.Blue,10);
		Tiles tiles4= new Tiles(TilesColor.Orange,11);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(2).draw(tiles1);
		game.getAIPlayer(2).draw(tiles2);
		game.getAIPlayer(2).draw(tiles4);
		
		game.AIplayer1Play();

		game.AIplayer2Play();
		Assert.assertEquals("Incorrect number tiles on p2 hand", game.getAIPlayer(2).getNumTiles(),4);
		
	}
	
	@Test
	public void P2WinsNotUsingTable()
	{
		Game game= new Game();

		Tiles tiles1= new Tiles(TilesColor.Red,10);
		Tiles tiles2= new Tiles(TilesColor.Green,10);
		Tiles tiles3= new Tiles(TilesColor.Blue,10);
		Tiles tiles4= new Tiles(TilesColor.Orange,10);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(2).draw(tiles1);
		game.getAIPlayer(2).draw(tiles2);
		game.getAIPlayer(2).draw(tiles3);
		
		game.AIplayer1Play();

		game.AIplayer2Play();
		Assert.assertEquals("Incorrect to play Initial 30 for P2", game.getAIPlayer(2).getNumTiles(),0);
		

	}
}
