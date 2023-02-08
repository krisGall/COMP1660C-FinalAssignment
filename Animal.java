/**
 * Animal creates an animal with type None, Sheep, Wolf or Dog for use
 * in the Sheep Herder Game.
 * @author Kristopher.Gall
 * @version 1.0
 * @since 2022-04-17
 */

import java.lang.Math;

public class Animal {

	private String[] animalTypes = {"None", "Sheep", "Wolf", "Dog"};
	private char[] animalIcons = {'o','S','W','D'};
	private String animalType;
	private char animalIcon;
	private int animalStrength;

	/**
	 * Constructor to create a blank animal object
	 */
	public Animal() {
		this.animalType = animalTypes[0];
		this.animalIcon = animalIcons[0];
	}

	public String toString() {
		return Character.toString(this.animalIcon);
	}

	/**
	 * Sets the animal
	 * @param typeToCreate is the type of animal to set
	 */
	public void setAnimal(int typeToSet) {
		this.animalType = animalTypes[typeToSet];
		this.animalIcon = animalIcons[typeToSet];
		this.animalStrength = ((int)(Math.random() * 10));
	}

	/**
	 * Getter for animalType
	 * @return animalType
	 */
	public String getAnimalType() {
		return this.animalType;
	} 
	
	/**
	 * Setter for animalType
	 * @param newType is new type
	 */
	public void setAnimalType(String newType) {
		this.animalType = newType;
	}

	/**
	 * Getter for animalIcon
	 * @return animalIcon
	 */
	public char getAnimalIcon() {
		return this.animalIcon;
	}

	/**
	 * Setter for animalIcon
	 * @param newIcon is new icon
	 */
	public void setAnimalIcon(char newIcon) {
		this.animalIcon = newIcon;
	} 

	/**
	 * Getter for animalStrength
	 * @return animalStrength
	 */
	public int getAnimalStrength() {
		return this.animalStrength;
	}

	/**
	 * Setter for animalStrength
	 * @param newStrength is the animal's new strength
	 */
	public void setAnimalStrength(int newStrength) {
		this.animalStrength = newStrength;
	}
}