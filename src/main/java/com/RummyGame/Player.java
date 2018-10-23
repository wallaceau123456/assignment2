package com.rummyGame;

public class Player 
{
	private String name;
	private Tiles[] tiles= new Tiles[100];
	private Tiles[] checkMeld= new Tiles[20];
	private int numOfTiles;
	private int numberCheckMeld;
	private int countInCheckTilesFunction=0;
	private int tableIndex=0;

	
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
		for(int t=0;t<20;t++)
		{
			this.checkMeld[t]=null;
		}
		
		
	this.numOfTiles=0;
	this.numberCheckMeld=0;
	this.countInCheckTilesFunction=0;
	}
	
	public int getNumTiles()
	{
		return numOfTiles;
	}
	public Tiles[] theTiles()
	{
		return tiles;
	}
	public Tiles[] theCheckMeld()
	{
		return checkMeld;
	}
	public int numberCheckMeld()
	{
		return numberCheckMeld;
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
	
	public void MeldsAscendingOrderByNumber()
	{
		Tiles temp;
		
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].theNumberOfTiles()>this.checkMeld[j].theNumberOfTiles())
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
	}
	public void TilesAscendingOrderByColor()
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
	public void MeldsAscendingOrderByColor()
	{
		Tiles temp;
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].ColorNumber()>this.checkMeld[j].ColorNumber())
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
		
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if((this.checkMeld[i].theNumberOfTiles()>this.checkMeld[j].theNumberOfTiles())
						&& (this.checkMeld[i].ColorNumber()==this.checkMeld[j].ColorNumber()))
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
		
	}
	
	public boolean checkIsTilesCorrect(String s,int index)
	{
		int theColor = 0;
		int tilesNumber=0;
		switch(s)
		{
		case "1 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			
			break;
		case "2 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Re":
			theColor=1;
			tilesNumber=4;
			break;
		case "5 Re":
			theColor=1;
			tilesNumber=5;
			break;
		case "6 Re":
			theColor=1;
			tilesNumber=6;
			break;
		case "7 Re":
			theColor=1;
			tilesNumber=7;
			break;
		case "8 Re":
			theColor=1;
			tilesNumber=8;
			break;
		case "9 Re":
			theColor=1;
			tilesNumber=9;
			break;
		case "10 R":
			theColor=1;
			tilesNumber=10;
			break;
		case "11 R":
			theColor=1;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 R":
			theColor=1;
			tilesNumber=12;			
			this.countInCheckTilesFunction+=1;
			break;
		case "13 R":
			theColor=1;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;

		case "3 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;

		case "4 Gr":
			theColor=2;
			tilesNumber=4;
			break;

		case "5 Gr":
			theColor=2;
			tilesNumber=5;
			break;

		case "6 Gr":
			theColor=2;
			tilesNumber=6;
			break;

		case "7 Gr":
			theColor=2;
			tilesNumber=7;
			break;

		case "8 Gr":
			theColor=2;
			tilesNumber=8;
			break;

		case "9 Gr":
			theColor=2;
			tilesNumber=9;
			break;

		case "10 G":
			theColor=2;
			tilesNumber=10;
			break;

		case "11 G":
			theColor=2;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;

		case "12 G":
			theColor=2;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;

		case "13 G":
			theColor=2;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Bl":
			theColor=3;
			tilesNumber=4;
			break;
		case "5 Bl":
			theColor=3;
			tilesNumber=5;
			break;
		case "6 Bl":
			theColor=3;
			tilesNumber=6;
			break;
		case "7 Bl":
			theColor=3;
			tilesNumber=7;
			break;
		case "8 Bl":
			theColor=3;
			tilesNumber=8;
			break;
		case "9 Bl":
			theColor=3;
			tilesNumber=9;
			break;
		case "10 B":
			theColor=3;
			tilesNumber=10;
			break;
		case "11 B":
			theColor=3;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 B":
			theColor=3;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;
		case "13 B":
			theColor=3;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Or":
			theColor=4;
			tilesNumber=4;
			break;
		case "5 Or":
			theColor=4;
			tilesNumber=5;
			break;
		case "6 Or":
			theColor=4;
			tilesNumber=6;
			break;
		case "7 Or":
			theColor=4;
			tilesNumber=7;
			break;
		case "8 Or":
			theColor=4;
			tilesNumber=8;
			break;
		case "9 Or":
			theColor=4;
			tilesNumber=9;
			break;
		case "10 O":
			theColor=4;
			tilesNumber=10;
			break;
		case "11 O":
			theColor=4;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 O":
			theColor=4;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;
		case "13 O":
			theColor=4;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		
		
		}
		for (int i=0;i<this.numOfTiles;i++)
		{		
			if((theColor==this.tiles[i].ColorNumber())&& (tilesNumber==this.tiles[i].theNumberOfTiles()))
			{
				this.checkMeld[numberCheckMeld]=this.tiles[i];
				this.numberCheckMeld+=1;
				return true;
		    }
			
		}
		return false;
		
		
	}
	public boolean checkInitial30()
	{
		int totalNumber=0;
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			totalNumber=totalNumber+this.checkMeld[i].theNumberOfTiles();
		}
		if(totalNumber>=30)
		{
			return true;
		}
		return false;
	}
	public boolean checkMeldWithSameColor()
	{
		if(this.numberCheckMeld<3)
		{
			return false;
		}
		if(this.numberCheckMeld>=3)
		{
			for(int i=1;i<numberCheckMeld;i++)
			{
				if((this.checkMeld[i].theNumberOfTiles()==this.checkMeld[i-1].theNumberOfTiles()+1)
						&& (this.checkMeld[i-1].ColorNumber()== this.checkMeld[i].ColorNumber()))
				{		
				}
				else
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkMeldWithDifferentColor()
	{
		if(this.numberCheckMeld<3)
		{
			return false;
		}
		if(this.numberCheckMeld>=3)
		{
			for(int i=1;i<numberCheckMeld;i++)
			{
				if(this.checkMeld[i].ColorNumber()==this.checkMeld[i-1].ColorNumber())
				{
					return false;
				}
				else
				{
					if((this.checkMeld[i].theNumberOfTiles()==this.checkMeld[i-1].theNumberOfTiles()))
				
					{		
				
					}
					else
				
					{
					return false;
				
					}
				}
			}
		}
		return true;
	}
	
	public boolean checkPutTilesInTableWithSameColor(Table t)
	{
		for(int i=0;i<t.numberMelds();i++)
		{
			if((this.checkMeld[0].theNumberOfTiles()==t.theMeld()[i].theNumberOfTiles()-1)
					&& this.checkMeld[0].ColorNumber()==t.theMeld()[i].ColorNumber())
			{
				return true;
			}
			
		}
		if((this.checkMeld[0].theNumberOfTiles()==t.theMeld()[t.numberMelds()].theNumberOfTiles()+1)
				&& this.checkMeld[0].ColorNumber()==t.theMeld()[t.numberMelds()].ColorNumber())
		{
			return true;
		}
		return false;
	}
	public void removeTiles(Table t,int tableIndex)
	{
		int currentIndex=0;
		while(currentIndex<this.numOfTiles)
		{
			if(this.tiles[currentIndex].toString().equals(t.theMeld()[tableIndex].toString()))
			{
				break;
				
			}
			currentIndex+=1;
		}
		for(int i=currentIndex+1;i<this.numOfTiles;i++)
		{
			this.tiles[i-1]=this.tiles[i];
			if(i==this.numOfTiles-1)
			{
				this.tiles[i]=null;
				this.numOfTiles-=1;
			}
		}
	}
	public void removeTheTiles()
	{
		int currentIndex=0;
		while(currentIndex<this.numOfTiles)
		{
			if(this.tiles[currentIndex].toString().equals(this.checkMeld[0].toString()))
			{
				break;
				
			}
			currentIndex+=1;
		}
		for(int i=currentIndex+1;i<this.numOfTiles;i++)
		{
			this.tiles[i-1]=this.tiles[i];
			if(i==this.numOfTiles-1)
			{
				this.tiles[i]=null;
				this.numOfTiles-=1;
			}
		}
	}
	public void clearTestMeld()
	{
		for(int i=1;i<this.numberCheckMeld;i++)
		{
			this.checkMeld[i]=null;
		}
		this.numberCheckMeld=0;
	}
	public void printTiles()
	{
		System.out.println(this.name);
		for (int i=0;i<this.numOfTiles;i++)
		{
		System.out.print("(" + this.tiles[i].toString()+ ")" +" ");
		}

	}
	public void printCheckMeldTiles()
	{
		for (int i=0;i<this.numberCheckMeld;i++)
		{
		System.out.println(this.checkMeld[i].toString());
		}

	}
	
	
}
