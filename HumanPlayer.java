import java.util.Scanner;

public class HumanPlayer extends Player{
	private boolean run;
	private int count;
	Scanner turnChoice = new Scanner(System.in);
	Scanner moveChoice = new Scanner(System.in);
	
	public HumanPlayer(Pokemon myPokemon, Item potion) {
		super(myPokemon, potion);
	}

	public void playerTurn(Pokemon myPokemon, Pokemon other, Item potion, int maxHP) throws InvalidInputException {
		//Creates scanners to ask the player what they want to do and performs it based on their input.
		System.out.println("What would you like to do?");
		System.out.println("Attack");
		System.out.println("Item");
		System.out.println("Run");
		System.out.print("Enter 1 for Attack, 2 for Item, and 3 for run: ");
		int answerForTurnChoice = turnChoice.nextInt();
		
		//Attack
		if (answerForTurnChoice == 1) {
			
			System.out.println("Which attack do you want to use?");
			System.out.println(myPokemon.getAttacks());
			System.out.print("Enter 1, 2, 3, or 4: ");
			int answerForMoveChoice = moveChoice.nextInt();
			
			if (answerForMoveChoice == 1) {
				myPokemon.attack(other, 1);
			}
			else if (answerForMoveChoice == 2) {
				myPokemon.attack(other, 2);
			}
			else if (answerForMoveChoice == 3) {
				myPokemon.attack(other, 3);
			}
			else if (answerForMoveChoice == 4) {
				myPokemon.attack(other, 4);
			}
			else {
				//Throws an error if an invalid input is given.
				
				moveChoice.close();
				throw new InvalidInputException("Invalid input given. Please type either 1, 2, 3, or 4.");
			}
		}
		
		//Item
		else if (answerForTurnChoice == 2) {
			//Uses the item but then prevents it from being used again.
			potion.useItem(myPokemon, maxHP, count);
			setCount(1);
		}
		
		//Run
		else if (answerForTurnChoice == 3) {
			run();
		}
		
		else {
			//Throws an error if an invalid input is given.
			turnChoice.close();
			throw new InvalidInputException("Invalid input given. Please type either 1, 2, or 3.");
		}
		
	}
	
	//Function that allows the player to run if they choose.
	@Override
	public void run() {
		System.out.println("You got away from the battle safely!");
		System.out.println("Thanks for playing!");
		run = true;
		setRun(run);
	}

	//Mutators.
	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
}
