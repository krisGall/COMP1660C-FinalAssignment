public class Event extends SheepHerder{

	int dogStrength;
	boolean playerHasDog;

	public Event(){
	}

	public void checkEvent(int eventID, int[] checkPos) {
		
		switch (eventID) {
		case 0:
			//No find event
			System.out.println("Found nothing...");

		case 1:
			//Sheep find event
			System.out.println("Found sheep!");
			System.out.println("You win!");
			checkLoop = 0;

		case 2:
			//Dog find event
			System.out.println("Found dog!");
			Animal dog = playGrid.getAnimal(checkPos[0], checkPos[1]);
			dogStrength = dog.getAnimalStrength();
			System.out.println("His strength is " + dogStrength + "!");
			playerHasDog = true;
			System.out.println("He joins you!");
			playerHasDog = true;
			setPlayerDogStrength(dogStrength);
			playGrid.setAnimal(checkPos[0], checkPos[1], 0);

		case 3:
			//Wolf find event
			System.out.println("Found wolf!");

			//if dog has not been found
			if(playerHasDog == false) {
				System.out.println("You are eaten!");
				checkLoop = 0;

			//if dog has been found 
			}else{
				//gets wolf animal
				Animal wolf = playGrid.getAnimal(checkPos[0], checkPos[1]);
				if(dogStrength >= wolf.getAnimalStrength()) {
					dogStrength = dogStrength - wolf.getAnimalStrength();
					System.out.println("The dog defends you but is wounded.");
					//Dog loses all strength
					if(dogStrength <= 0) {
						System.out.println("The dog succumbs to its wounds...");
					//Dog loses some strength
					}else{
						System.out.println("The dog lives, but is weakened");
						System.out.println("His strength is now " + dogStrength + "...");
					}
				//Dog strength was lower then wolf
				}else{
					System.out.println("The dog has been eaten!");
					playerHasDog = false;
					System.out.println("You escape!");
				}
			}
		}
	}
}

		
	

