package com.rummyGame;

public class Table 
{
	
	private int numOfTableMelds;
	private Tiles[] meld= new Tiles[100];
	
	public Table()
	{
		this.noTiles();
	}
	public void noTiles()
	{
		for(int t=0;t<100;t++)
		{
			this.meld[t]=null;
		}
		this.numOfTableMelds=0;
	}
	public int numberMelds()
	{
		return numOfTableMelds;
	}
	public void copy(Tiles newTiles)
	{
		this.meld[this.numOfTableMelds]=newTiles;
		this.numOfTableMelds=this.numOfTableMelds+1;
	}
	
	public Tiles[] theMeld()
	{
		return meld;
	}
	public void TilesAscendingOrderByNumber()
	{
		Tiles temp;
		
		for(int i=0;i<this.numOfTableMelds;i++)
		{
			for(int j=i+1;j<this.numOfTableMelds;j++)
			{
				if(this.meld[i].theNumberOfTiles()>this.meld[j].theNumberOfTiles())
				{
					temp=this.meld[i];
					this.meld[i]=this.meld[j];
					this.meld[j]=temp;
				}
			}
		}
	}
	public void TilesAscendingOrderByColor()
	{
		Tiles temp;
		for(int i=0;i<this.numOfTableMelds;i++)
		{
			for(int j=i+1;j<this.numOfTableMelds;j++)
			{
				if(this.meld[i].ColorNumber()>this.meld[j].ColorNumber())
				{
					temp=this.meld[i];
					this.meld[i]=this.meld[j];
					this.meld[j]=temp;
				}
			}
		}
		
		for(int i=0;i<this.numOfTableMelds;i++)
		{
			for(int j=i+1;j<this.numOfTableMelds;j++)
			{
				if((this.meld[i].theNumberOfTiles()>this.meld[j].theNumberOfTiles())
						&& (this.meld[i].ColorNumber()==this.meld[j].ColorNumber()))
				{
					temp=this.meld[i];
					this.meld[i]=this.meld[j];
					this.meld[j]=temp;
				}
			}
		}
		
	}
	public void removeTiles(int index)
	{
		for(int i=(index+1);i<this.numOfTableMelds;i++)
		{   
			this.meld[i-1]=this.meld[i];
		}
		this.numOfTableMelds=this.numOfTableMelds-1;
	}

	public void printTable()
	{
		
		for (int i=0;i<this.numOfTableMelds;i++)
		{
		System.out.print(this.meld[i].toString() + " ");
		}

	}
	
	
	

	

}
