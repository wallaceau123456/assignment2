package com.rummyGame;

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
	
	public void TilesAscendingOrderByNumber()
	{
		Tiles temp;
		
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if(this.tiles[i].theNumberOfTiles()>this.tiles[j].theNumberOfTiles())
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
	}
	
	public void TilesAscesndingOrderByColor()
	{
		Tiles temp;
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if(this.tiles[i].ColorNumber()>this.tiles[j].ColorNumber())
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
		
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if((this.tiles[i].theNumberOfTiles()>this.tiles[j].theNumberOfTiles())
						&& (this.tiles[i].ColorNumber()==this.tiles[j].ColorNumber()))
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
		
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
