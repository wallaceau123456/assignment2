package ai;

import java.util.ArrayList;
import java.util.List;

import ui.*;
/**
 * the class of the AI players
 * @author ted
 *
 */
public abstract class AIplayer {

	/**
	 * The name of the AI player
	 */
	String name;
	/**
	 * The list of the tiles in the hand of ai players
	 */
	List<Tiles> hand;
	/**
	 * the method of drawing a new tile from the pile
	 * @param tile is the tile drawn from the pile
	 */
	private void addTile(Tiles tile){
		hand.add(tile);
	}
	/**
	 * Places tiles on the board
	 * @param tile is the tile drawn from hands
	 */
	protected void playTile(Tiles tile) {

	}
	/**
	 * Plays meld on the board
	 * @param meld the meld to play
	 */
	private void playMeld(List<Tiles> meld) {
		for(Tiles tile : meld)
			playTile(tile);
	}
	/**
	 * to find the tiles that can form a meld
	 * @param currentBoard 
	 * @return list of melds to play
	 */
	abstract List<List<Tiles>> getPlay(Table currentBoard);

	/**
	 * Gathers the melds with numbers in order in same color, available in your hand
	 * @return the list of melds in flush form
	 */
	private List<List<Tiles>> getAvailableFlushs(){
		hand.sort(
				(t1,t2)-> (t1.theNumberOfTiles()>t2.theNumberOfTiles()) ? +1 : -1
				); //sort the list by number 
		List<Tiles> reds = new ArrayList<Tiles>();List<Tiles> oranges = new ArrayList<Tiles>();List<Tiles> greens = new ArrayList<Tiles>();List<Tiles> blues = new ArrayList<Tiles>();
		for(int i = 0;i<hand.size();i++) {
			switch (hand.get(i).theColor()) {
			case Red:
				reds.add(hand.get(i));
				break;
			case Orange:
				oranges.add(hand.get(i));
				break;
			case Blue:
				blues.add(hand.get(i));
				break;
			case Green:
				greens.add(hand.get(i));
				break;
			} //extract each color in a sublist
		}



		List<List<Tiles>> possibleMelds = new ArrayList<List<Tiles>>(); 

		List<List<Tiles>> colors = new ArrayList<List<Tiles>>();
		colors.add(reds);colors.add(oranges);colors.add(blues);colors.add(greens); //the list of all the 4 colors
		
		for(List<Tiles> color : colors) {
			for(int i = 0; i<color.size()-2; i++) {
				if(color.get(i).theNumberOfTiles()+1==color.get(i+1).theNumberOfTiles() 
						&& color.get(i+1).theNumberOfTiles()+1==color.get(i+2).theNumberOfTiles()) {
					List<Tiles> meld = new ArrayList<Tiles>();
					meld.add(color.get(i));
					meld.add(color.get(i+1));
					meld.add(color.get(i+2));
					possibleMelds.add(meld);
					if(i+3<color.size()) {
						for(int j=i+3;j<color.size();j++) {
							if(color.get(i).theNumberOfTiles()+(j-i) == color.get(j).theNumberOfTiles()) {
								meld.add(color.get(j));
								possibleMelds.add(meld);
							}
						}
					}

				}
			}
		}
		return possibleMelds;
	}

	private List<List<Tiles>> getAvailableCardsOfAKind(){

		hand.sort(
				(t1,t2)-> (t1.theNumberOfTiles()>t2.theNumberOfTiles()) ? +1 : -1
				);

		return null;

	}
}
