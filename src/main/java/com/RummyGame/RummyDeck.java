package com.rummyGame;

import java.util.Random;



public class RummyDeck 
{
   


private int TileNumber;
   
   private Tiles[] myTiles;
   
   public RummyDeck(boolean shuffle)
   {
	   this.TileNumber= 104;
	   this.myTiles= new Tiles[this.TileNumber];
	   
	   int tile=0;
		for (int d = 0; d < 2; d++) {

					for (int n = 13; n > 0; n--) {
						for (int s = 0; s < 4; s++) {

					this.myTiles[tile] = new Tiles(TilesColor.values()[s], n);
					tile= tile+1;
				}
			}
		}
	 
	if(shuffle==true)
	{
		this.shuffle();
	}

	   
   }
   
   public void shuffle()
   {
	   Random tiles= new Random();
	   
	   Tiles temp;
	   int k;
	   
	   for (int i = 0; i < this.TileNumber; i++) {
			k = tiles.nextInt(this.TileNumber);

			temp = this.myTiles[i];
			this.myTiles[i] = this.myTiles[k];
			this.myTiles[k] = temp;
		}
   }
   public Tiles myNextTiles() {
		Tiles firstCard = this.myTiles[0];

		for (int i = 1; i < this.TileNumber; i++) {
			this.myTiles[i - 1] = this.myTiles[i];
		}

		this.myTiles[this.TileNumber - 1] = null;
		this.TileNumber = this.TileNumber - 1;
		return firstCard;
	}
   
   public void print(int num) {
		for (int t = 0; t < num; t++) {
			System.out.println((t + 1) + " " + this.TileNumber + " " + this.myTiles[t].toString() + " "
					+ this.myTiles[t].theNumberOfTiles());
		}

		System.out.println(this.TileNumber - num);
}
}
