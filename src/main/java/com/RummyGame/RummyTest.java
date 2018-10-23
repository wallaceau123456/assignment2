package com.rummyGame;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
public class RummyTest extends Applet 
{
	public static void main(String[] args)
	{
	System.out.println("Welcome to the Rummy Game");
	System.out.println();
	RummyDeck deck = new RummyDeck(true);
	Player player = new Player("Wallace");
	Table[] table = new Table[200];
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
	
    int tableIndex=0;
    int UIplayerInitial30=0;    
    while(player.getNumTiles()>0)
    {
    System.out.println("This show the tiles on player hand on ascending order with each same color");
    player.TilesAscendingOrderByColor();
    System.out.println();
    player.printTiles();
    System.out.println();
    System.out.println();
    System.out.println("This show the tiles on player hand on ascending order but with different color");
    System.out.println();
    player.TilesAscendingOrderByNumber();
    player.printTiles();
    System.out.println();
    System.out.println();
	Scanner scanner = new Scanner(System.in);
	System.out.println("Input your selection of tiles, (should type number and color), type D if you want to draw a tiles");
	System.out.println("If you want to put your tiles in the table already have meld, please type P");
	String userInput = scanner.nextLine();
	char[] input= userInput.toCharArray();
	if (userInput.equals("D"))
	{
		System.out.println("Table");
		System.out.println();
		if(tableIndex>0)
		{
		for(int i=0;i<(tableIndex);i++)
		{
		table[i].printTable();
		System.out.println("(Meld " + i + ")");
		System.out.println();
		}
		}
		player.draw(deck.myNextTiles());
	}
	if (userInput.equals("P"))
	{
		System.out.println("Type which tiles you want to put in the table, and what number of melds you want to put in.");
		System.out.println("Which tiles you want to put on the table?");
		Scanner theScan= new Scanner(System.in);
		String theInput= theScan.nextLine();
		char[] charInput= theInput.toCharArray();
		for(int i=3;i<charInput.length;i++)
		{
			String word=Character.toString(charInput[i]);
			String prevWord= Character.toString(charInput[i-1]);
			String thePrevWord= Character.toString(charInput[i-2]);
			String thePrevPrevWord= Character.toString(charInput[i-3]);
			String theWord=thePrevPrevWord+thePrevWord+prevWord+word;
			player.checkIsTilesCorrect(theWord,i);
		}	
	    System.out.println("Which meld number you want to put in?");
	    Scanner scanNumber= new Scanner(System.in);
	    String theScanNumber=scanNumber.nextLine();
	    int meldNumber=Integer.valueOf(theScanNumber);
	    if(player.checkPutTilesInTableWithSameColor(table[meldNumber])==true)
	    {
	    	table[meldNumber].copy(player.theCheckMeld()[0]);
	    	table[meldNumber].TilesAscendingOrderByNumber();
	    	player.removeTheTiles();
	    	System.out.println("Table");
			System.out.println();
			if(tableIndex>0)
			{
			for(int i=0;i<(tableIndex);i++)
			{
			table[i].printTable();
			System.out.println("(Meld " + i + ")");
			System.out.println();
			}
			}
			player.clearTestMeld();
	    }
	    
	}
	else
	{
		System.out.println("Table");
		System.out.println();
		if(tableIndex>0)
		{
		for(int i=0;i<(tableIndex);i++)
		{
		table[i].printTable();
		System.out.println("(Meld " + i + ")");
		System.out.println();
		}
		}
	for(int i=3;i<input.length;i++)
	{
		String word=Character.toString(input[i]);
		String prevWord= Character.toString(input[i-1]);
		String thePrevWord= Character.toString(input[i-2]);
		String thePrevPrevWord= Character.toString(input[i-3]);
		String theWord=thePrevPrevWord+thePrevWord+prevWord+word;
		player.checkIsTilesCorrect(theWord,i);

		
	}	
	player.MeldsAscendingOrderByColor();
	if((player.checkMeldWithDifferentColor()==true)||player.checkMeldWithSameColor()==true)
	{
		table[tableIndex]= new Table();

		for(int i=0;i<player.numberCheckMeld();i++)
		{
		 table[tableIndex].copy(player.theCheckMeld()[i]);
		}

	player.clearTestMeld();

	for(int i=0;i<table[tableIndex].numberMelds();i++)
	{
	player.removeTiles(table[tableIndex], i);
    }
	System.out.println();
	System.out.println("Table");
	System.out.println();
	for(int i=0;i<(tableIndex+1);i++)
	{
	table[i].printTable();
	System.out.println("(Meld " + i + ")");
	System.out.println();
	}
	tableIndex+=1;
	}

		
	player.MeldsAscendingOrderByNumber();
	if((player.checkMeldWithDifferentColor()==true)||player.checkMeldWithSameColor()==true)
	{
		table[tableIndex]= new Table();

		for(int i=0;i<player.numberCheckMeld();i++)
		{
			 table[tableIndex].copy(player.theCheckMeld()[i]);
		}

	player.clearTestMeld();
    
	for(int i=0;i<table[tableIndex].numberMelds();i++)
	{
	player.removeTiles(table[tableIndex], i);
    }
	System.out.println();
	System.out.println("Table");
	System.out.println();
	for(int i=0;i<(tableIndex+1);i++)
	{
	table[i].printTable();
	System.out.println("(Meld " + i + ")");
	System.out.println();
	}
	tableIndex+=1;
	}
	else
	{
		player.clearTestMeld();
		
	}

	
	System.out.println();
    }
    }
    if(player.getNumTiles()==0)
    {
    	System.out.println("You win the Rummy Game");
    }
	}
}


	
	
   
	
		
	
	

	
	
	

	
