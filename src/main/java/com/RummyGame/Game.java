package com.rummyGame;

import java.util.Scanner;

public class Game {
	private Player player = new Player("Wallace");
	private Player AIplayer2 = new Player("AI player 1");
	private Player AIplayer3 = new Player("AI player 2");
	private Player AIplayer4 = new Player("AI player 3");

	private Table[] table = new Table[200];
	private int tableIndex;
	private int tableCountForHumanPlayer;
	private int tableCountForAIPlayer1;
	private int tableCountForAIPlayer2;
	private int tableCountForAIPlayer3;

	private RummyDeck deck = new RummyDeck(true);
	private int humanPlayer = 1;
	private int aiPlayer2 = 2;
	private int aiPlayer3 = 3;
	private int aiPlayer4 = 4;
	private int playerTurn;
	

	private int player2DoSomethingCount;
	private int AIplayer3IsDoSomething;
	private int player4DoSomething;

	private int player2Turn;
	private int player3Turn;
	private int player4Turn;
	private int player2TheClearTable = 0;
	private int player3TheClearTable = 0;
	private int player4TheClearTable = 0;

	public Game() {
		tableIndex = 0;
		tableCountForHumanPlayer = 0;
		tableCountForAIPlayer1 = 0;
		tableCountForAIPlayer2 = 0;
		tableCountForAIPlayer3 = 0;
		playerTurn = 1;
		

		player2DoSomethingCount = 0;
		AIplayer3IsDoSomething = 0;
		player4DoSomething = 0;

		player2Turn = 1;
		player3Turn = 1;
		player4Turn = 1;
	}

	public void init() {
		for (int i = 0; i < 14; i++) {
			player.draw(deck.myNextTiles());
			AIplayer2.draw(deck.myNextTiles());
			AIplayer3.draw(deck.myNextTiles());
			AIplayer4.draw(deck.myNextTiles());
		}
	}

	public Table[] getTable()
	{
		return table;
	}
	public Player getHumanPlayer() {
		return player;
	}

	public int thePlayerTurn() {
		return playerTurn;
	}

	public int add1thePlayerTurn() {
		return playerTurn += 1;
	}

	public Player getAIPlayer(int index) {
		switch (index) {
		case 1:
			return AIplayer2;
		case 2:
			return AIplayer3;
		case 3:
			return AIplayer4;
		default:
			throw new RuntimeException("No AI player wiht index: " + index);
		}
	}

	public int getEachPlayerTurn(int playerTurn) {
		switch (playerTurn) {
		case 1:
			return humanPlayer;
		case 2:
			return aiPlayer2;
		case 3:
			return aiPlayer3;
		case 4:
			return aiPlayer4;
		default:
			throw new RuntimeException("No current player wiht index: " + playerTurn);

		}
	}

	public void playGame() {

		System.out.println("Welcome to the Rummy Game");
		System.out.println();
		int UIplayerInitial30 = 0;


		while (player.getNumTiles() > 0 && AIplayer2.getNumTiles() > 0 && AIplayer3.getNumTiles() > 0
				&& AIplayer4.getNumTiles() > 0) {
			if (playerTurn == 1) {
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
				System.out.println("Type D if you want to draw a tiles");
				System.out.println("If you want to put your tiles in the table already have meld, please type P");
				System.out.println("Type Q if you want to build the melds.");
				String userInput = scanner.nextLine();
				if (userInput.equals("D")) {
					System.out.println("Table");
					System.out.println();
					if (tableIndex > 0) {
						for (int i = 0; i < (tableIndex); i++) {
							table[i].printTable();
							System.out.println("(Meld " + i + ")");
							System.out.println();
						}
					}
					player.draw(deck.myNextTiles());
					playerTurn = 2;
				}
				if (userInput.equals("P")) {
					System.out.println(
							"Type which tiles you want to put in the table, and what number of melds you want to put in.");
					System.out.println("Which tiles you want to put on the table?");
					Scanner theScan = new Scanner(System.in);
					String theInput = theScan.nextLine();
					char[] charInput = theInput.toCharArray();
					for (int i = 3; i < charInput.length; i++) {
						String word = Character.toString(charInput[i]);
						String prevWord = Character.toString(charInput[i - 1]);
						String thePrevWord = Character.toString(charInput[i - 2]);
						String thePrevPrevWord = Character.toString(charInput[i - 3]);
						String theWord = thePrevPrevWord + thePrevWord + prevWord + word;
						player.checkIsTilesCorrect(theWord, i);
					}
					System.out.println("Which meld number you want to put in?");
					Scanner scanNumber = new Scanner(System.in);
					String theScanNumber = scanNumber.nextLine();
					int meldNumber = Integer.valueOf(theScanNumber);
					if (player.checkPutTilesInTableWithSameColor(table[meldNumber]) == true) {
						table[meldNumber].copy(player.theCheckMeld()[0]);
						table[meldNumber].TilesAscendingOrderByNumber();
						player.removeTheTiles();
						System.out.println("Table");
						System.out.println();
						if (tableIndex > 0) {
							for (int i = 0; i < (tableIndex); i++) {
								table[i].printTable();
								System.out.println("(Meld " + i + ")");
								System.out.println();
							}
						}
						player.clearTestMeld();
					}

					System.out.println("Did you finish your turn? Type Y if Yes or type N if no");
					Scanner Finished = new Scanner(System.in);
					String finish = Finished.nextLine();
					if (finish.equals("Y")) {
						playerTurn = 2;
					} else if (finish.equals("N")) {
						playerTurn = 1;
					}
				}
				if (userInput.equals("Q")) {
					tableCountForHumanPlayer = 0;
					System.out.println("Input your selection of tiles, (should type number and color),");
					Scanner meldInput = new Scanner(System.in);
					String themeldInput = meldInput.nextLine();
					char[] input = themeldInput.toCharArray();
					System.out.println("Table");
					System.out.println();
					if (tableIndex > 0) {
						for (int i = 0; i < (tableIndex); i++) {
							table[i].printTable();
							System.out.println("(Meld " + i + ")");
							System.out.println();
						}
					}
					for (int i = 3; i < input.length; i++) {
						String word = Character.toString(input[i]);
						String prevWord = Character.toString(input[i - 1]);
						String thePrevWord = Character.toString(input[i - 2]);
						String thePrevPrevWord = Character.toString(input[i - 3]);
						String theWord = thePrevPrevWord + thePrevWord + prevWord + word;
						player.checkIsTilesCorrect(theWord, i);

					}
					HumanPlayerPlayRun();

					HumanPlayerPlaySet();
					
				

				System.out.println("Your score is " + player.getInitial30());
				System.out.println();
				System.out.println("Did you finish your turn? Type Y if Yes or type N if no");
				Scanner IsFinished = new Scanner(System.in);
				String finishInput = IsFinished.nextLine();
				if (finishInput.equals("Y")) {
					if (player.getInitial30() > 30) {
						playerTurn = 2;
					} else if (player.getInitial30() < 30) {
						for (int q = (tableIndex - tableCountForHumanPlayer); q < tableIndex; q++) {
							for (int c = 0; c < table[q].numberMelds(); c++) {
								player.draw(table[q].theMeld()[c]);
							}
							table[q] = null;
						}
						tableIndex = tableIndex - tableCountForHumanPlayer;
						player.draw(deck.myNextTiles());
						player.initial30ToZero();
						playerTurn = 2;
					}
				} else if (finishInput.equals("N")) {
					playerTurn = 1;
				}

			}
		}
		if (playerTurn == 2) {
			AIplayer1Play();
		}
		if (playerTurn == 3) {

			AIplayer2Play();
		}
		if (playerTurn == 4) {
		
			AIplayer3Play();

		}
		}

		if (player.getNumTiles() == 0) {
			System.out.println("You win the Rummy Game");
		}
		if (AIplayer2.getNumTiles() == 0) {
			System.out.println("AI player 1 win the Rummy Game");

		}
		if (AIplayer3.getNumTiles() == 0) {
			System.out.println("AI player 2 win the Rummy Game");

		}
		if (AIplayer4.getNumTiles() == 0) {
			System.out.println("AI player 3 win the Rummy Game");

		}

		System.out.println("The game is finished");
	}

	public void HumanPlayerPlayRun() {
		player.MeldsAscendingOrderByColor();
		if ((player.checkMeldWithDifferentColor() == true) || player.checkMeldWithSameColor() == true) {
			table[tableIndex] = new Table();

			tableCountForHumanPlayer += 1;
			for (int i = 0; i < player.numberCheckMeld(); i++) {
				player.addTilesOnInitial30(player.theCheckMeld()[i].theNumberOfTiles());
				table[tableIndex].copy(player.theCheckMeld()[i]);
			}

			player.clearTestMeld();

		}
		for (int i = 0; i < table[tableIndex].numberMelds(); i++) {
			player.removeTiles(table[tableIndex], i);
		}
		System.out.println();
		System.out.println("Table");
		System.out.println();
		for (int i = 0; i < (tableIndex + 1); i++) {
			table[i].printTable();
			System.out.println("(Meld " + i + ")");
			System.out.println();
		}
		tableIndex += 1;
	}
	
	public void HumanPlayerPlaySet()
	{
		player.MeldsAscendingOrderByNumber();
		if ((player.checkMeldWithDifferentColor() == true) || player.checkMeldWithSameColor() == true) {
			table[tableIndex] = new Table();
			tableCountForHumanPlayer += 1;

			for (int i = 0; i < player.numberCheckMeld(); i++) {
				player.addTilesOnInitial30(player.theCheckMeld()[i].theNumberOfTiles());
				table[tableIndex].copy(player.theCheckMeld()[i]);
			}

			player.clearTestMeld();

			for (int i = 0; i < table[tableIndex].numberMelds(); i++) {
				player.removeTiles(table[tableIndex], i);
			}
			System.out.println();
			System.out.println("Table");
			System.out.println();
			for (int i = 0; i < (tableIndex + 1); i++) {
				table[i].printTable();
				System.out.println("(Meld " + i + ")");
				System.out.println();
			}
			tableIndex += 1;
		} else {
			player.clearTestMeld();

		}
	}
	
	public void AIplayer1Play()
	{
		System.out.println();
		System.out.println("AI Player 1 play tiles");
		System.out.println();

		tableCountForAIPlayer1 = 0;
		AIplayer2.TilesAscendingOrderByColor();
		AIplayer2.putSameNumberSameColorTilesInTheBack();
		AIplayer2.printTiles();
		System.out.println();
		int numberCount = 1;
		for (int i = 1; i < AIplayer2.getNumTiles(); i++) {
			if ((AIplayer2.theTiles()[i - 1].ColorNumber() == AIplayer2.theTiles()[i].ColorNumber())) {
				if (AIplayer2.theTiles()[i - 1].theNumberOfTiles() == AIplayer2.theTiles()[i].theNumberOfTiles()
						- 1)

				{
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer2.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i];
							AIplayer2.numberCheckMeldPlus1();
							table[tableIndex] = new Table();
							player2DoSomethingCount += 1;
							tableCountForAIPlayer1 += 1;
							for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
								AIplayer2.removeTiles(table[tableIndex], j);
								AIplayer2.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

							}
							tableIndex += 1;

							AIplayer2.clearTestMeld();
						}
						AIplayer2.clearTestMeld();
						numberCount = 1;
					}

				}

				else {
					if (numberCount >= 3) {
						AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
						AIplayer2.numberCheckMeldPlus1();
						table[tableIndex] = new Table();
						player2DoSomethingCount += 1;
						tableCountForAIPlayer1 += 1;
						for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
							AIplayer2.removeTiles(table[tableIndex], j);
							AIplayer2.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

						}
						tableIndex += 1;

						AIplayer2.clearTestMeld();
					}
					AIplayer2.clearTestMeld();
					numberCount = 1;
				}
			} else {
				if (numberCount >= 3) {
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					table[tableIndex] = new Table();
					player2DoSomethingCount += 1;
					tableCountForAIPlayer1 += 1;
					for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
						AIplayer2.removeTiles(table[tableIndex], j);
						AIplayer2.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

					}
					tableIndex += 1;

					AIplayer2.clearTestMeld();
				}
				AIplayer2.clearTestMeld();
				numberCount = 1;
			}
		}
		AIplayer2.TilesAscendingOrderByNumber();
		AIplayer2.printTiles();
		numberCount = 1;
		for (int i = 1; i < AIplayer2.getNumTiles(); i++) {
			if ((AIplayer2.theTiles()[i - 1].theNumberOfTiles() == AIplayer2.theTiles()[i].theNumberOfTiles())) {

				AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
				AIplayer2.numberCheckMeldPlus1();
				numberCount += 1;

				if (i == AIplayer2.getNumTiles() - 1) {
					if (numberCount >= 3) {
						AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i];
						AIplayer2.numberCheckMeldPlus1();
						AIplayer2.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Table();
						player2DoSomethingCount += 1;
						tableCountForAIPlayer1 += 1;
						for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
							AIplayer2.removeTiles(table[tableIndex], j);
							AIplayer2.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());
						}
						for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
							for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
								if (table[tableIndex].theMeld()[e].ColorNumber() == table[tableIndex].theMeld()[f]
										.ColorNumber()) {
									AIplayer2.draw(table[tableIndex].theMeld()[e]);
									table[tableIndex].removeTiles(e);
									AIplayer2.subtractTilesOnInitial30(
											table[tableIndex].theMeld()[e].theNumberOfTiles());
								}
							}
						}
						if (table[tableIndex].numberMelds() < 3) {
							for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
								AIplayer2.draw(table[tableIndex].theMeld()[c]);
								AIplayer2.subtractTilesOnInitial30(
										table[tableIndex].theMeld()[c].theNumberOfTiles());
							}
							table[tableIndex] = null;
							tableCountForAIPlayer1 -= 1;

						} else if (table[tableIndex].numberMelds() >= 3) {
							tableIndex += 1;
						}
						AIplayer2.clearTestMeld();
					}
					AIplayer2.clearTestMeld();
					numberCount = 1;
				}

			}

			else {

				if (numberCount >= 3) {
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					AIplayer2.MeldsAscendingSortColorNumber();

					table[tableIndex] = new Table();
					player2DoSomethingCount += 1;
					tableCountForAIPlayer1 += 1;
					for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
						AIplayer2.removeTiles(table[tableIndex], j);
						AIplayer2.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());
					}
					for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
						for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
							if (table[tableIndex].theMeld()[e].ColorNumber() == table[tableIndex].theMeld()[f]
									.ColorNumber()) {
								AIplayer2.draw(table[tableIndex].theMeld()[e]);
								table[tableIndex].removeTiles(e);
								AIplayer2.subtractTilesOnInitial30(
										table[tableIndex].theMeld()[e].theNumberOfTiles());
							}
						}
					}
					if (table[tableIndex].numberMelds() < 3) {
						for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
							AIplayer2.draw(table[tableIndex].theMeld()[c]);
							AIplayer2.subtractTilesOnInitial30(table[tableIndex].theMeld()[c].theNumberOfTiles());
						}
						table[tableIndex] = null;
						tableCountForAIPlayer1 -= 1;

					} else if (table[tableIndex].numberMelds() >= 3) {
						tableIndex += 1;
					}
					AIplayer2.clearTestMeld();
				}
				AIplayer2.clearTestMeld();
				numberCount = 1;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Player1 score is " + AIplayer2.getInitial30());

		if (player2Turn == 1) {
			if (AIplayer2.getInitial30() >= 30) {
				player2Turn += 1;
				AIplayer2.initial30ToZero();
			} else if (AIplayer2.getInitial30() < 30) {
				for (int q = (tableIndex - tableCountForAIPlayer1); q < tableIndex; q++) {
					for (int c = 0; c < table[q].numberMelds(); c++) {
						AIplayer2.draw(table[q].theMeld()[c]);
					}
					table[q] = null;
				}
				tableIndex = tableIndex - tableCountForAIPlayer1;
				AIplayer2.initial30ToZero();
				player2DoSomethingCount = 0;
			}
		}
		if (player2Turn >= 2) {
			for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
				for (int b = 0; b < tableIndex; b++) {

					if ((table[b].theMeld()[1].theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() + 1)
							&& (AIplayer2.theTiles()[a].ColorNumber() == table[b].theMeld()[0].ColorNumber()
									&& AIplayer2.theTiles()[a]
											.theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() - 1))

					{
						table[b].copy(AIplayer2.theTiles()[a]);
						AIplayer2.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player2DoSomethingCount += 1;
					}

				}
			}
			for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
				for (int b = 0; b < tableIndex; b++) {

					if ((table[b].theMeld()[1].theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() + 1)
							&& (AIplayer2.theTiles()[a].ColorNumber() == table[b].theMeld()[0].ColorNumber()
									&& AIplayer2.theTiles()[a]
											.theNumberOfTiles() == table[b].theMeld()[table[b].numberMelds() - 1]
													.theNumberOfTiles() + 1))

					{
						table[b].copy(AIplayer2.theTiles()[a]);
						AIplayer2.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player2DoSomethingCount += 1;
					}

				}
			}
			for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
				for (int b = 0; b < tableIndex; b++) {

					if ((table[b].theMeld()[0].theNumberOfTiles() == table[b].theMeld()[1].theNumberOfTiles())
							&& (table[b].theMeld()[0].theNumberOfTiles() == AIplayer2.theTiles()[a]
									.theNumberOfTiles())) {
						if (AIplayer2.checkTheSameColor(AIplayer2.theTiles()[a], table[b]) == true) {
							table[b].copy(AIplayer2.theTiles()[a]);
							AIplayer2.removeItselfTiles(a);
							table[b].TilesAscendingOrderByNumber();
							player2DoSomethingCount += 1;
						}
					}
				}
			}
		}
		AIplayer2.printTiles();
		if (player2DoSomethingCount == 0) {
			System.out.println();
			AIplayer2.draw(deck.myNextTiles());
			AIplayer2.printTiles();
		}

		System.out.println();
		System.out.println();
		System.out.println("Table");
		System.out.println();
		for (int i = 0; i < (tableIndex); i++) {
			table[i].printTable();
			System.out.println("(Meld " + i + ")");
			System.out.println();
		}
		System.out.println();
		System.out.println("AI player 1 have " + AIplayer2.getNumTiles() + " left");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");

		player2DoSomethingCount = 0;
		playerTurn = 3;
	}
	public void AIplayer2Play()
	{
		if (tableIndex >= 1) {
			System.out.println();
			System.out.println("AI Player 2 play tiles");
			System.out.println();

			tableCountForAIPlayer2 = 0;
			AIplayer3.TilesAscendingOrderByColor();
			AIplayer3.putSameNumberSameColorTilesInTheBack();
			AIplayer3.printTiles();
			System.out.println();
			int numberCount = 1;
			for (int i = 1; i < AIplayer3.getNumTiles(); i++) {
				if ((AIplayer3.theTiles()[i - 1].ColorNumber() == AIplayer3.theTiles()[i].ColorNumber())) {
					if (AIplayer3.theTiles()[i - 1].theNumberOfTiles() == AIplayer3.theTiles()[i].theNumberOfTiles()
							- 1)

					{
						AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
						AIplayer3.numberCheckMeldPlus1();
						numberCount += 1;
						if (i == AIplayer3.getNumTiles() - 1) {
							if (numberCount >= 3) {
								AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i];
								AIplayer3.numberCheckMeldPlus1();
								table[tableIndex] = new Table();
								AIplayer3IsDoSomething += 1;
								tableCountForAIPlayer2 += 1;
								for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
									table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
									AIplayer3.removeTiles(table[tableIndex], j);
									AIplayer3
											.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

								}
								tableIndex += 1;

								AIplayer3.clearTestMeld();
							}
							AIplayer3.clearTestMeld();
							numberCount = 1;
						}

					} else {
						if (numberCount >= 3) {
							AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
							AIplayer3.numberCheckMeldPlus1();
							table[tableIndex] = new Table();
							AIplayer3IsDoSomething += 1;
							tableCountForAIPlayer2 += 1;
							for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
								AIplayer3.removeTiles(table[tableIndex], j);
								AIplayer3.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

							}
							tableIndex += 1;
							AIplayer3.clearTestMeld();
						}
						AIplayer3.clearTestMeld();
						numberCount = 1;
					}

				} else {
					if (numberCount >= 3) {
						AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
						AIplayer3.numberCheckMeldPlus1();
						table[tableIndex] = new Table();
						AIplayer3IsDoSomething += 1;
						tableCountForAIPlayer2 += 1;
						for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
							AIplayer3.removeTiles(table[tableIndex], j);
							AIplayer3.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

						}
						tableIndex += 1;
						AIplayer3.clearTestMeld();
					}
					AIplayer3.clearTestMeld();
					numberCount = 1;
				}
			}
			AIplayer3.TilesAscendingOrderByNumber();
			AIplayer3.printTiles();
			numberCount = 1;
			for (int i = 1; i < AIplayer3.getNumTiles(); i++) {
				if ((AIplayer3.theTiles()[i - 1].theNumberOfTiles() == AIplayer3.theTiles()[i]
						.theNumberOfTiles())) {

					AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
					AIplayer3.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer3.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i];
							AIplayer3.numberCheckMeldPlus1();
							AIplayer3.MeldsAscendingSortColorNumber();

							table[tableIndex] = new Table();
							AIplayer3IsDoSomething += 1;
							tableCountForAIPlayer2 += 1;
							for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
								AIplayer3.removeTiles(table[tableIndex], j);
								AIplayer3.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());
							}
							for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
								for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
									if (table[tableIndex].theMeld()[e]
											.ColorNumber() == table[tableIndex].theMeld()[f].ColorNumber()) {
										AIplayer3.draw(table[tableIndex].theMeld()[e]);
										table[tableIndex].removeTiles(e);
										AIplayer3.subtractTilesOnInitial30(
												table[tableIndex].theMeld()[e].theNumberOfTiles());
									}
								}
							}
							if (table[tableIndex].numberMelds() < 3) {
								for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
									AIplayer3.draw(table[tableIndex].theMeld()[c]);
									AIplayer3.subtractTilesOnInitial30(
											table[tableIndex].theMeld()[c].theNumberOfTiles());

								}
								table[tableIndex] = null;
								tableCountForAIPlayer2 -= 1;
							} else if (table[tableIndex].numberMelds() >= 3) {
								tableIndex += 1;
							}
							AIplayer3.clearTestMeld();
						}
						AIplayer3.clearTestMeld();
						numberCount = 1;
					}

				}

				else {

					if (numberCount >= 3) {
						AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
						AIplayer3.numberCheckMeldPlus1();
						AIplayer3.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Table();
						AIplayer3IsDoSomething += 1;
						tableCountForAIPlayer2 += 1;
						for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
							AIplayer3.removeTiles(table[tableIndex], j);
							AIplayer3.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());
						}
						for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
							for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
								if (table[tableIndex].theMeld()[e].ColorNumber() == table[tableIndex].theMeld()[f]
										.ColorNumber()) {
									AIplayer3.draw(table[tableIndex].theMeld()[e]);
									table[tableIndex].removeTiles(e);
									AIplayer3.subtractTilesOnInitial30(
											table[tableIndex].theMeld()[e].theNumberOfTiles());
								}
							}
						}
						if (table[tableIndex].numberMelds() < 3) {
							for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
								AIplayer3.draw(table[tableIndex].theMeld()[c]);
								AIplayer3.subtractTilesOnInitial30(
										table[tableIndex].theMeld()[c].theNumberOfTiles());

							}
							table[tableIndex] = null;
							tableCountForAIPlayer2 -= 1;
						} else if (table[tableIndex].numberMelds() >= 3) {
							tableIndex += 1;
						}
						AIplayer3.clearTestMeld();
					}
					AIplayer3.clearTestMeld();
					numberCount = 1;
				}
			}
			System.out.println();
			System.out.println();
			System.out.println("Player2 score is " + AIplayer3.getInitial30());
			if (player3Turn == 1) {
				if (AIplayer3.getInitial30() >= 30) {
					player3Turn += 1;
					AIplayer3.initial30ToZero();
				} else if (AIplayer3.getInitial30() < 30) {
					for (int q = (tableIndex - tableCountForAIPlayer2); q < tableIndex; q++) {
						for (int c = 0; c < table[q].numberMelds(); c++) {
							AIplayer3.draw(table[q].theMeld()[c]);
						}
						table[q] = null;
					}
					tableIndex = tableIndex - tableCountForAIPlayer2;
					AIplayer3.initial30ToZero();
					AIplayer3IsDoSomething = 0;
				}
			}
			if (AIplayer3IsDoSomething == 0) {
				System.out.println();
				AIplayer3.draw(deck.myNextTiles());
				AIplayer3.printTiles();
			}
			System.out.println();
			System.out.println();
			System.out.println("Table");
			System.out.println();
			for (int i = 0; i < (tableIndex); i++) {
				table[i].printTable();
				System.out.println("(Meld " + i + ")");
				System.out.println();
			}
			System.out.println();
			System.out.println("AI player 2 have " + AIplayer3.getNumTiles() + " left");
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");

			AIplayer3IsDoSomething = 0;
			playerTurn = 4;
		} else if (tableIndex == 0) {
			AIplayer3.draw(deck.myNextTiles());
			playerTurn = 4;
		}
	}
	
	public void AIplayer3Play()
	{
		System.out.println();
		System.out.println("AI Player 3 play tiles");
		System.out.println();

		tableCountForAIPlayer3 = 0;
		AIplayer4.TilesAscendingOrderByColor();
		AIplayer4.putSameNumberSameColorTilesInTheBack();
		AIplayer4.printTiles();
		System.out.println();
		int numberCount = 1;
		for (int i = 1; i < AIplayer4.getNumTiles(); i++) {
			if ((AIplayer4.theTiles()[i - 1].ColorNumber() == AIplayer4.theTiles()[i].ColorNumber())) {
				if (AIplayer4.theTiles()[i - 1].theNumberOfTiles() == AIplayer4.theTiles()[i].theNumberOfTiles()
						- 1)

				{
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer4.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i];
							AIplayer4.numberCheckMeldPlus1();
							table[tableIndex] = new Table();
							player4DoSomething += 1;
							tableCountForAIPlayer3 += 1;
							for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
								AIplayer4.removeTiles(table[tableIndex], j);
								AIplayer4.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

							}
							tableIndex += 1;

							AIplayer4.clearTestMeld();
						}
						AIplayer4.clearTestMeld();
						numberCount = 1;
					}

				}

				else {
					if (numberCount >= 3) {
						AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
						AIplayer4.numberCheckMeldPlus1();
						table[tableIndex] = new Table();
						player4DoSomething += 1;
						tableCountForAIPlayer3 += 1;
						for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
							AIplayer4.removeTiles(table[tableIndex], j);
							AIplayer4.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

						}

						tableIndex += 1;
						AIplayer4.clearTestMeld();
					}
					AIplayer4.clearTestMeld();
					numberCount = 1;
				}
			} else {
				if (numberCount >= 3) {
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					table[tableIndex] = new Table();
					player4DoSomething += 1;
					tableCountForAIPlayer3 += 1;
					for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
						AIplayer4.removeTiles(table[tableIndex], j);
						AIplayer4.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

					}
					tableIndex += 1;
					AIplayer4.clearTestMeld();
				}
				AIplayer4.clearTestMeld();
				numberCount = 1;
			}
		}
		AIplayer4.TilesAscendingOrderByNumber();
		AIplayer4.printTiles();
		numberCount = 1;
		for (int i = 1; i < AIplayer4.getNumTiles(); i++) {
			if ((AIplayer4.theTiles()[i - 1].theNumberOfTiles() == AIplayer4.theTiles()[i].theNumberOfTiles())) {

				AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
				AIplayer4.numberCheckMeldPlus1();
				numberCount += 1;
				if (i == AIplayer4.getNumTiles() - 1) {
					if (numberCount >= 3) {
						AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i];
						AIplayer4.numberCheckMeldPlus1();
						AIplayer4.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Table();
						player4DoSomething += 1;
						tableCountForAIPlayer3 += 1;
						for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
							AIplayer4.removeTiles(table[tableIndex], j);
							AIplayer4.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

						}
						for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
							for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
								if (table[tableIndex].theMeld()[e].ColorNumber() == table[tableIndex].theMeld()[f]
										.ColorNumber()) {
									AIplayer4.draw(table[tableIndex].theMeld()[e]);
									table[tableIndex].removeTiles(e);
									AIplayer4.subtractTilesOnInitial30(
											table[tableIndex].theMeld()[e].theNumberOfTiles());

								}
							}
						}

						if (table[tableIndex].numberMelds() < 3) {
							for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
								AIplayer4.draw(table[tableIndex].theMeld()[c]);
								AIplayer4.subtractTilesOnInitial30(
										table[tableIndex].theMeld()[c].theNumberOfTiles());
							}
							table[tableIndex] = null;
							tableCountForAIPlayer3 -= 1;

						} else if (table[tableIndex].numberMelds() >= 3) {
							tableIndex += 1;
						}

						AIplayer4.clearTestMeld();
					}
					AIplayer4.clearTestMeld();
					numberCount = 1;
				}

			}

			else {

				if (numberCount >= 3) {
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					AIplayer4.MeldsAscendingSortColorNumber();

					table[tableIndex] = new Table();
					player4DoSomething += 1;
					tableCountForAIPlayer3 += 1;
					for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
						AIplayer4.removeTiles(table[tableIndex], j);
						AIplayer4.addTilesOnInitial30(table[tableIndex].theMeld()[j].theNumberOfTiles());

					}
					for (int e = 0; e < table[tableIndex].numberMelds(); e++) {
						for (int f = (e + 1); f < table[tableIndex].numberMelds(); f++) {
							if (table[tableIndex].theMeld()[e].ColorNumber() == table[tableIndex].theMeld()[f]
									.ColorNumber()) {
								AIplayer4.draw(table[tableIndex].theMeld()[e]);
								table[tableIndex].removeTiles(e);
								AIplayer4.subtractTilesOnInitial30(
										table[tableIndex].theMeld()[e].theNumberOfTiles());

							}
						}
					}

					if (table[tableIndex].numberMelds() < 3) {
						for (int c = 0; c < table[tableIndex].numberMelds(); c++) {
							AIplayer4.draw(table[tableIndex].theMeld()[c]);
							AIplayer4.subtractTilesOnInitial30(table[tableIndex].theMeld()[c].theNumberOfTiles());
						}
						table[tableIndex] = null;
						tableCountForAIPlayer3 -= 1;

					} else if (table[tableIndex].numberMelds() >= 3) {
						tableIndex += 1;
					}

					AIplayer4.clearTestMeld();
				}
				AIplayer4.clearTestMeld();
				numberCount = 1;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Player3 score is " + AIplayer4.getInitial30());
		if (player4Turn == 1) {
			if (AIplayer4.getInitial30() >= 30) {
				player4Turn += 1;
			} else if (AIplayer4.getInitial30() < 30) {
				for (int q = (tableIndex - tableCountForAIPlayer3); q < tableIndex; q++) {
					for (int c = 0; c < table[q].numberMelds(); c++) {
						AIplayer4.draw(table[q].theMeld()[c]);
					}
					table[q] = null;
				}
				tableIndex = tableIndex - tableCountForAIPlayer3;
				AIplayer4.initial30ToZero();
				player4DoSomething = 0;
			}
		}
		if (player.getNumTiles() <= 3 || AIplayer2.getNumTiles() <= 3 || AIplayer3.getNumTiles() <= 3) {
			for (int a = 0; a < AIplayer4.getNumTiles(); a++) {
				for (int b = 0; b < tableIndex; b++) {
					if ((table[b].theMeld()[1].theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() + 1)
							&& (AIplayer4.theTiles()[a].ColorNumber() == table[b].theMeld()[0].ColorNumber()
									&& AIplayer4.theTiles()[a]
											.theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() - 1))

					{
						table[b].copy(AIplayer4.theTiles()[a]);
						AIplayer4.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player4DoSomething += 1;
					}
				}
			}
			for (int a = 0; a < AIplayer4.getNumTiles(); a++) {
				for (int b = 0; b < tableIndex; b++) {
					if ((table[b].theMeld()[1].theNumberOfTiles() == table[b].theMeld()[0].theNumberOfTiles() + 1)
							&& (AIplayer4.theTiles()[a].ColorNumber() == table[b].theMeld()[0].ColorNumber()
									&& AIplayer4.theTiles()[a]
											.theNumberOfTiles() == table[b].theMeld()[table[b].numberMelds() - 1]
													.theNumberOfTiles() + 1))

					{
						table[b].copy(AIplayer4.theTiles()[a]);
						AIplayer4.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player4DoSomething += 1;
					}
				}
			}
		}
		AIplayer4.printTiles();

		if (player4DoSomething == 0) {
			System.out.println();
			AIplayer4.draw(deck.myNextTiles());
			AIplayer4.printTiles();
		}
		System.out.println();
		System.out.println();
		System.out.println("Table");
		System.out.println();
		for (int i = 0; i < (tableIndex); i++) {
			table[i].printTable();
			System.out.println("(Meld " + i + ")");
			System.out.println();
		}
		System.out.println();
		System.out.println("AI player 3 have " + AIplayer4.getNumTiles() + " left");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		player4DoSomething = 0;
		playerTurn = 1;
	}
}
