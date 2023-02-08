/**
 * Player creates a player object and stores its name and choice.
 * @author Kristopher.Gall
 * @version 1.0
 * @since 2022-04-17
 */

import javax.swing.*;
import java.util.Scanner;

public class Player {

	private String playerName;
	private int[] playerChoice;
	// private JFrame f;

	/**
	 * Constructor for Player
	 */
	public Player() {
	}

	public void dialogAskName(){
		// this.f = new JFrame();
		// String input = JOptionPane.showInputDialog(f, "Enter Name");
		// this.playerName = input;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name: ");
		playerName = sc.nextLine();
	}

	/**
	 * Getter for playerName
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Setter for playerName
	 * @param newName is new name
	 */
	public void setPlayerName(String newName) {
		playerName = newName;
	}

	/**
	 * Getter for playerChoice
	 * @return playerChoice
	 */
	public int[] getPlayerChoice() {
		return playerChoice;
	}

	/**
	 * Setter for playerChoice
	 * @param newChoice is new choice
	 */
	public void setPlayerChoice(int[] newChoice) {
		playerChoice = newChoice;
	}

}
