package com.RummyGame;

public class Tiles 
{
  private TilesColor theColor;
  private int NumberOfTiles;
  
  public Tiles(TilesColor color, int tiles)
  {
	  this.theColor=color;
	  
	  if(tiles<1 || tiles>13)
	   {
		  System.out.println("This " + tiles + " is error.");
		  System.exit(1);
	   }
	   else
	   {
	   this.NumberOfTiles= tiles;
	   }
  }
  
  public int theNumberOfTiles()
  {
	  return NumberOfTiles;
  }
  
  public String toString()
  {
	   String StringOfNumber = null;
	   if(this.NumberOfTiles==1)
	   {
		   StringOfNumber= "1";
	   }
	   
	   if(this.NumberOfTiles==2)
	   {
		   StringOfNumber= "2";
	   }
	   if(this.NumberOfTiles==3)
	   {
		   StringOfNumber= "3";
	   }
	   if(this.NumberOfTiles==4)
	   {
		   StringOfNumber= "4";

	   }
	   if(this.NumberOfTiles==5)
	   {
		   StringOfNumber= "5";

	   }
	   if(this.NumberOfTiles==6)
	   {
		   StringOfNumber= "6";

	   }
	   if(this.NumberOfTiles==7)
	   {
		   StringOfNumber= "7";

	   }
	   if(this.NumberOfTiles==8)
	   {
		   StringOfNumber= "8";		   

	   }
	   if(this.NumberOfTiles==9)
	   {
		   StringOfNumber= "9";

	   }
	   if(this.NumberOfTiles==10)
	   {
		   StringOfNumber= "10";
	   }
	   if(this.NumberOfTiles==11)
	   {
		   StringOfNumber= "11";
	   }
	   if(this.NumberOfTiles==12)
	   {
		   StringOfNumber= "12";
	   }
	   if(this.NumberOfTiles==13)
	   {
		   StringOfNumber= "13";
	   }
	  
	   return StringOfNumber + " " + theColor.toString();
	   
	   
  }
  
}
