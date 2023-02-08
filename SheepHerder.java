/**
 * A game called Sheep Herder where you search for a sheep while trying to avoid a wolf.
 * @author Kristopher.Gall
 * @version 1.0
 * @since 2022-04-18
 */

import java.util.Scanner;

public class SheepHerder {

	Player player1;
	Grid playGrid;
	Event currentEvent;
    int playerDogStrength;
    int checkLoop;

	/**
	 * Constructor for Sheep Herder
	 */
	public SheepHerder() {
		
		player1 = new Player();
		player1.dialogAskName();
		startUpDisplay();
		playGrid = new Grid();
		checkLoop = 1;
		gameLoop();		
	}

	/**
	 * Displays the start up message
	 */
	public void startUpDisplay() {
		String startUp = "Hello " + player1.getPlayerName() + "!";
		System.out.println(startUp);
	}

	/**
	 * Displays the rules for the game
	 */
	public void rulesDisplay() {
		String rules = "----RULES----" + "\n"
					 + "Find the hidden sheep by guessing the column and row" + "\n"
					 + "A wolf is hunting the sheep. If the sheep is eaten, you lose" + "\n"
					 + "There is a dog that will give you an extra life when found" + "\n"
					 + "WARNING: If you find the wolf there will be fight. If you have" + "\n"
					 + "a dog, there will be a fight and you might lose him" + "\n"
					 + "Press Q to quit; Press I for instructions";

		System.out.println(rules);
	}

	/**
	 * Prompts players to Start Round, Quit or ask for Instructions
	 * Asks player to input coordinates to check for the sheep
	 * Stores coordinates in the player object
	 */
	public void chooseSpot() {
		System.out.println("(S) START ROUND / (Q) QUIT / (I) INSTRUCTION");
		boolean checkLoop = true;
		while(checkLoop == true){
			Scanner sc = new Scanner(System.in);
			String menuChoice = sc.nextLine();
			if(menuChoice.equals("S") ) {
				System.out.println("Choose column: ");
				int playerColumn = sc.nextInt();
				System.out.println("Choose row: ");
				int playerRow = sc.nextInt();
				checkLoop = false;

			}else if(menuChoice.equals("Q") ){
				System.exit(0);

			}else if(menuChoice.equals("I") ){
				rulesDisplay();
				checkLoop = false;

			}else{
				System.out.println("Error!");
			}
		}
	}
			
	public void checkSpot(int[] playerChoice) {
		Event currentEvent = new Event();

		//Sheep is found
		if (playerChoice == playGrid.getSheepPos()) {
			currentEvent.checkEvent(1, playerChoice);

		//Dog is found
		}else if (playerChoice == playGrid.getDogPos()) {
			currentEvent.checkEvent(2, playerChoice);

		//Wolf is found
		}else if (playerChoice == playGrid.getWolfPos()) {
			currentEvent.checkEvent(3, playerChoice);

		//Nothing is found
		}else {
			currentEvent.checkEvent(0, playerChoice);
		}

	}

	public void gameLoop() {
		while(checkLoop == 1) {
			playGrid.displayGrid();
			chooseSpot();
			checkSpot(player1.getPlayerChoice());
		}
	}

	public void setPlayerDogStrength (int dogStrength) {
		playerDogStrength = dogStrength;
	}

	public static void main(String[] args){
		new SheepHerder();


	} 
	


}