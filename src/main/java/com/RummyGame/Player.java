package com.RummyGame;

public class Player 
{
	private String name;
	private Tiles[] tiles= new Tiles[100];
	private int numOfTiles;
	
	public Player(String theName)
	{
		this.name=theName;
		this.noTiles();
	}

	public void noTiles()
	{
		for(int t=0;t<100;t++)
		{
			this.tiles[t]=null;
		}
	this.numOfTiles=0;
	}
	
	public void draw(Tiles newTiles)
	{
		this.tiles[this.numOfTiles]=newTiles;
		this.numOfTiles=this.numOfTiles+1;
	}
	
	public void printTiles()
	{
		System.out.println(this.name);
		for (int i=0;i<this.numOfTiles;i++)
		{
		System.out.println(this.tiles[i].toString());
		}

	}
}
