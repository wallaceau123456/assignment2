package com.rummyGame;

import org.junit.Assert;
import org.junit.Test;


public class GameTest {

	@Test
	public void testInit() {
		Game game = new Game();
		game.init();

		Player humanPlayer = game.getHumanPlayer();
		Assert.assertEquals("Incorrect number of tiles for the human player", 14, humanPlayer.getNumTiles());

		for (int i = 1; i < 4; i++) {
			Player aiPlayer = game.getAIPlayer(i);
			Assert.assertEquals("Incorrect number of tiles for the AI player", 14, aiPlayer.getNumTiles());
		}
	}

	@Test
	public void checkPlayerTurn()
	{
		Game game= new Game();
		
		Assert.assertEquals("Incorrect number of turns of human player", game.getEachPlayerTurn(1), game.thePlayerTurn());
		
		game.add1thePlayerTurn();
		Assert.assertEquals("Incorrect number of turns of the AI player 1", game.getEachPlayerTurn(2), game.thePlayerTurn());
		
		game.add1thePlayerTurn();
		Assert.assertEquals("Incorrect number of turns of the AI player 2", game.getEachPlayerTurn(3), game.thePlayerTurn());
		
		game.add1thePlayerTurn();
		Assert.assertEquals("Incorrect number of turns of the AI player 3", game.getEachPlayerTurn(4), game.thePlayerTurn());
	}
	
	@Test
	public void testUIPlayerPlayTilesOnTable()
	{
		Tiles tiles1= new Tiles(TilesColor.Blue,1);
		Tiles tiles2= new Tiles(TilesColor.Blue,2);
		Tiles tiles3= new Tiles(TilesColor.Blue,3);
		
		Table table= new Table();
		table.copy(tiles1);
		table.copy(tiles2);
		table.copy(tiles3);
		
		Assert.assertEquals("Incorrect tiles on the table", tiles1, table.theMeld()[0]);
		Assert.assertEquals("Incorrect tiles on the table", tiles2, table.theMeld()[1]);
		Assert.assertEquals("Incorrect tiles on the table", tiles3, table.theMeld()[2]);

	}
    
	
	@Test
	public void UIPlayerPlaysRuns()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,1);
		Tiles tiles2= new Tiles(TilesColor.Blue,2);
		Tiles tiles3= new Tiles(TilesColor.Blue,3);
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Red,3);
		game.getHumanPlayer().draw(tiles1);
		game.getHumanPlayer().draw(tiles2);
		game.getHumanPlayer().draw(tiles3);
		game.getHumanPlayer().draw(tiles4);
		game.getHumanPlayer().draw(tiles5);
		game.getHumanPlayer().draw(tiles6);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("3 Bl", 1);

        game.HumanPlayerPlayRun();
		Assert.assertEquals("Incorrect run on the table", tiles1, game.getTable()[0].theMeld()[0]);
		Assert.assertEquals("Incorrect run on the table", tiles2, game.getTable()[0].theMeld()[1]);
		Assert.assertEquals("Incorrect run on the table", tiles3, game.getTable()[0].theMeld()[2]);

	
		//human player plays serveral runs
		game.getHumanPlayer().checkIsTilesCorrect("1 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("3 Re", 1);
		
		game.HumanPlayerPlayRun();
		Assert.assertEquals("Incorrect run on the table", tiles4, game.getTable()[1].theMeld()[0]);
		Assert.assertEquals("Incorrect run on the table", tiles5, game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect run on the table", tiles6, game.getTable()[1].theMeld()[2]);
		

	}
	
	@Test
	public void UIPlayerPlaysSets()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,1);
		Tiles tiles2= new Tiles(TilesColor.Red,1);
		Tiles tiles3= new Tiles(TilesColor.Green,1);
		
		Tiles tiles4= new Tiles(TilesColor.Blue,2);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Green,2);
		
		game.getHumanPlayer().draw(tiles1);
		game.getHumanPlayer().draw(tiles2);
		game.getHumanPlayer().draw(tiles3);
		
		game.getHumanPlayer().draw(tiles4);
		game.getHumanPlayer().draw(tiles5);
		game.getHumanPlayer().draw(tiles6);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("1 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("1 Gr", 1);

        game.HumanPlayerPlaySet();
		Assert.assertEquals("Incorrect set on the table", tiles1, game.getTable()[0].theMeld()[0]);
		Assert.assertEquals("Incorrect set on the table", tiles2, game.getTable()[0].theMeld()[1]);
		Assert.assertEquals("Incorrect set on the table", tiles3, game.getTable()[0].theMeld()[2]);
		
		game.getHumanPlayer().checkIsTilesCorrect("2 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Gr", 1);
		
		game.HumanPlayerPlaySet();
		Assert.assertEquals("Incorrect set on the table", tiles4, game.getTable()[1].theMeld()[0]);
		Assert.assertEquals("Incorrect set on the table", tiles5, game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect set on the table", tiles6, game.getTable()[1].theMeld()[2]);
	}
	@Test
	public void HumanPlayerPlayMixRunAndSet()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,1);
		Tiles tiles2= new Tiles(TilesColor.Red,1);
		Tiles tiles3= new Tiles(TilesColor.Green,1);
		
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Red,3);
		
		game.getHumanPlayer().draw(tiles1);
		game.getHumanPlayer().draw(tiles2);
		game.getHumanPlayer().draw(tiles3);
		game.getHumanPlayer().draw(tiles4);
		game.getHumanPlayer().draw(tiles5);
		game.getHumanPlayer().draw(tiles6);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("1 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("1 Gr", 1);
        game.HumanPlayerPlaySet();
        Assert.assertEquals("Incorrect set on the table", tiles1, game.getTable()[0].theMeld()[0]);
		Assert.assertEquals("Incorrect set on the table", tiles2, game.getTable()[0].theMeld()[1]);
		Assert.assertEquals("Incorrect set on the table", tiles3, game.getTable()[0].theMeld()[2]);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Re", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Re", 2);
		game.getHumanPlayer().checkIsTilesCorrect("3 Re", 3);
		game.HumanPlayerPlayRun();
		Assert.assertEquals("Incorrect set on the table", tiles4, game.getTable()[1].theMeld()[0]);
		Assert.assertEquals("Incorrect set on the table", tiles5, game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect set on the table", tiles6, game.getTable()[1].theMeld()[2]);

	}
	
	
	@Test
	public void testEachAIPlayerPlayMixSetAndRun()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Red,3);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(1).draw(tiles4);
		game.getAIPlayer(1).draw(tiles5);
		game.getAIPlayer(1).draw(tiles6);
		
		
       game.AIplayer1Play();
       Assert.assertEquals("Incorrect set and run on the table", tiles4, game.getTable()[0].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles5, game.getTable()[0].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles6, game.getTable()[0].theMeld()[2]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[1].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[1].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[1].theMeld()[2]);
	   
	   game.getAIPlayer(2).draw(tiles1);
		game.getAIPlayer(2).draw(tiles2);
		game.getAIPlayer(2).draw(tiles3);
		game.getAIPlayer(2).draw(tiles4);
		game.getAIPlayer(2).draw(tiles5);
		game.getAIPlayer(2).draw(tiles6);
		
		
      game.AIplayer2Play();
      Assert.assertEquals("Incorrect set and run on the table", tiles4, game.getTable()[2].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles5, game.getTable()[2].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles6, game.getTable()[2].theMeld()[2]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[3].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[3].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[3].theMeld()[2]);
	   
	   game.getAIPlayer(3).draw(tiles1);
		game.getAIPlayer(3).draw(tiles2);
		game.getAIPlayer(3).draw(tiles3);
		game.getAIPlayer(3).draw(tiles4);
		game.getAIPlayer(3).draw(tiles5);
		game.getAIPlayer(3).draw(tiles6);
		
		
      game.AIplayer3Play();
      Assert.assertEquals("Incorrect set and run on the table", tiles4, game.getTable()[4].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles5, game.getTable()[4].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles6, game.getTable()[4].theMeld()[2]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[5].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[5].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[5].theMeld()[2]);
	   
	   
	}
	
	@Test
	public void testAIPlayer1PlaysOneMeld()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Red,4);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(1).draw(tiles4);
		game.getAIPlayer(1).draw(tiles5);
		game.getAIPlayer(1).draw(tiles6);
		
		//P1 play one meld.
		game.AIplayer1Play();
		Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[0].theMeld()[0]);
		Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[0].theMeld()[1]);
		Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[0].theMeld()[2]);
		
		

	}
	
	@Test
	public void testP1PlaysServeralMeld()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		
		Tiles tiles4= new Tiles(TilesColor.Red,1);
		Tiles tiles5= new Tiles(TilesColor.Red,2);
		Tiles tiles6= new Tiles(TilesColor.Red,3);
		
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(1).draw(tiles4);
		game.getAIPlayer(1).draw(tiles5);
		game.getAIPlayer(1).draw(tiles6);
		
		
       game.AIplayer1Play();
       Assert.assertEquals("Incorrect set and run on the table", tiles4, game.getTable()[0].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles5, game.getTable()[0].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles6, game.getTable()[0].theMeld()[2]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[1].theMeld()[0]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[1].theMeld()[1]);
	   Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[1].theMeld()[2]);
	}
	
	@Test
	public void P1PlayMeldsInSubquentTurn()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		
	
		
		Tiles tiles7= new Tiles(TilesColor.Blue,1);
		Tiles tiles8= new Tiles(TilesColor.Blue,2);
		Tiles tiles9= new Tiles(TilesColor.Blue,3);
		Tiles tiles10= new Tiles(TilesColor.Red,1);
		Tiles tiles11= new Tiles(TilesColor.Red,2);
		Tiles tiles12= new Tiles(TilesColor.Red,3);
		game.getHumanPlayer().draw(tiles7);
		game.getHumanPlayer().draw(tiles8);
		game.getHumanPlayer().draw(tiles9);
		game.getHumanPlayer().draw(tiles10);
		game.getHumanPlayer().draw(tiles11);
		game.getHumanPlayer().draw(tiles12);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("3 Bl", 1);

        game.HumanPlayerPlayRun();
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		
		
		game.AIplayer1Play();
		Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[1].theMeld()[0]);
	    Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[1].theMeld()[2]);
		
		
	}

	@Test
	public void P1PlayServeralMeldsInSubquentTurn()
	{
		Game game= new Game();
		Tiles tiles1= new Tiles(TilesColor.Blue,10);
		Tiles tiles2= new Tiles(TilesColor.Red,10);
		Tiles tiles3= new Tiles(TilesColor.Green,10);
		
	
		
		Tiles tiles7= new Tiles(TilesColor.Blue,1);
		Tiles tiles8= new Tiles(TilesColor.Blue,2);
		Tiles tiles9= new Tiles(TilesColor.Blue,3);
		Tiles tiles10= new Tiles(TilesColor.Red,1);
		Tiles tiles11= new Tiles(TilesColor.Red,2);
		Tiles tiles12= new Tiles(TilesColor.Red,3);
		game.getHumanPlayer().draw(tiles7);
		game.getHumanPlayer().draw(tiles8);
		game.getHumanPlayer().draw(tiles9);
		game.getHumanPlayer().draw(tiles10);
		game.getHumanPlayer().draw(tiles11);
		game.getHumanPlayer().draw(tiles12);
		
		game.getHumanPlayer().checkIsTilesCorrect("1 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("2 Bl", 1);
		game.getHumanPlayer().checkIsTilesCorrect("3 Bl", 1);

        game.HumanPlayerPlayRun();
		game.getAIPlayer(1).draw(tiles1);
		game.getAIPlayer(1).draw(tiles2);
		game.getAIPlayer(1).draw(tiles3);
		game.getAIPlayer(1).draw(tiles10);
		game.getAIPlayer(1).draw(tiles11);
		game.getAIPlayer(1).draw(tiles12);
		
		
		
		game.AIplayer1Play();
		Assert.assertEquals("Incorrect set and run on the table", tiles2, game.getTable()[2].theMeld()[0]);
	    Assert.assertEquals("Incorrect set and run on the table", tiles3, game.getTable()[2].theMeld()[1]);
		Assert.assertEquals("Incorrect set and run on the table", tiles1, game.getTable()[2].theMeld()[2]);
		Assert.assertEquals("Incorrect set and run on the table", tiles10, game.getTable()[1].theMeld()[0]);
	    Assert.assertEquals("Incorrect set and run on the table", tiles11, game.getTable()[1].theMeld()[1]);
		Assert.assertEquals("Incorrect set and run on the table", tiles12, game.getTable()[1].theMeld()[2]);
		
	}
	
	

}
