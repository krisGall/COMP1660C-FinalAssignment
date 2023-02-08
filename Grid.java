/**
 * Grid creates the grid to play the Sheep Herder game on.
 * @author Kristopher.Gall
 * @version 1.0
 * @since 2022-04-17
 */

import java.lang.Math;
import java.util.Arrays;

public class Grid {

	private int[] sheepPos;
	private int[] wolfPos;
	private int[] dogPos;
	private Animal[][] playGrid;


	/**
	 * Constructor for the Grid Object
	 */
	public Grid() {
		sheepPos = new int[2];
		wolfPos = new int[2];
		dogPos = new int[2];
		playGrid = new Animal[5][5];

		for(int x = 0; x < playGrid.length; x++) {
			for(int y = 0; y < playGrid.length; y++) {
				playGrid[x][y] = new Animal();
			}
		}
		generateAnimals();
		placeAnimals();
	}

	/**
	 * Displays the grid's current state
	 */
	public void displayGrid() {
		getColumnHeaders();
		for(int x = 0; x < playGrid.length; x++) {
			getRowHeaders(x);
			for(int y = 0; y < playGrid.length; y++) {
				System.out.print(playGrid[x][y]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	/**
	 * Creates column headers for grid
	 */
	private void getColumnHeaders() {
		System.out.print("  ");
		for(int x = 1; x < playGrid.length + 1; x++) {
			System.out.print(x + " ");
		}
		System.out.print("\n");
	}

	/**
	 * Creates row headers for grid
	 * @param row is the row currently being printed
	 */
	private void getRowHeaders(int row) {
		System.out.print((row + 1) + " ");
	}

	/**
	 * Generates x,y coordinates
	 */
	public int[] generateCoordinates() {
		int x = ((int)(Math.random() * 5));
		int y = ((int)(Math.random() * 5));
		return new int[] {x, y};
	}

	/**
	 * Generates starting positions for the animals on the grid
	 */
	public void generateAnimals() {
		sheepPos = generateCoordinates();
		wolfPos = generateCoordinates();
		dogPos = generateCoordinates();

		while (Arrays.equals(wolfPos, sheepPos) || Arrays.equals(wolfPos, dogPos)) {
			wolfPos = generateCoordinates();
		}
		while (Arrays.equals(dogPos, sheepPos) || Arrays.equals(dogPos, wolfPos)) {
			dogPos = generateCoordinates();
		}
	}

	/**
	 * Places animals on the starting positions on the grid
	 */
	public void placeAnimals() {
		playGrid[sheepPos[0]][sheepPos[1]].setAnimal(1);
		System.out.println("Placing Sheep!");
		playGrid[wolfPos[0]][wolfPos[1]].setAnimal(2);
		System.out.println("Placing Wolf!");
		playGrid[dogPos[0]][dogPos[1]].setAnimal(3);
		System.out.println("Placing Dog!");
	}

	public Animal getAnimal(int x, int y) {
		Animal animalToGet = new Animal();
		animalToGet = playGrid[x][y];
		return animalToGet;
	}

	public void setAnimal(int x, int y, int type) {
		playGrid[x][y].setAnimal(type);
	}

	/**
	 * Setter for Sheep position
	 * @param newPos new position
	 */
	public void setSheepPos(int[] newPos) {
		sheepPos = newPos;
	}

	/**
	 * Getter for Sheep position
	 * @return Sheep position
	 */
	public int[] getSheepPos() {
		return sheepPos;
	}

	/**
	 * Setter for Wolf position
	 * @param newPos new position
	 */
	public void setWolfPos(int[] newPos) {
		wolfPos = newPos;
	}

	/**
	 * Getter for Wolf position
	 * @return wolf position
	 */
	public int[] getWolfPos() {
		return wolfPos;
	}

	/**
	 * Setter for Dog position
	 * @param newPos new position
	 */
	public void setDogPos(int[] newPos) {
		dogPos = newPos;
	}

	/**
	 * Getter for Dog position
	 * @return dog position
	 */
	public int[] getDogPos() {
		return dogPos;
	}
}
	