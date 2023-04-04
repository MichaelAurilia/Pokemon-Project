import java.util.Random;

public class ComputerPlayer extends Player{
	private boolean run;
	private int count;
	
	public ComputerPlayer(Pokemon myPokemon, Item potion) {
		super(myPokemon, potion);
	}
	
	public void computerTurn(Pokemon myPokemon, Pokemon other, Item potion, int maxHP) {
		//Using a random number generator, the computer chooses what actions it will take
		Random rand = new Random();
		int int_random = rand.nextInt(3);
		
		//Attack.
		if (int_random == 0) {
			int attack_random = rand.nextInt(4);
			
			if (attack_random == 0) {
				myPokemon.attack(other, 1);
			}
			else if (attack_random == 1) {
				myPokemon.attack(other, 2);
			}
			else if (attack_random == 2) {
				myPokemon.attack(other, 3);
			}
			else if (attack_random == 3) {
				myPokemon.attack(other, 4);
			}
		}
		
		//Item.
		else if (int_random == 1) {
			//Uses item but prevents further use by the computer.
			potion.useItem(myPokemon, maxHP, count);
			setCount(1);
		}
		
		//Run.
		else if (int_random == 2) {
			int run_random = rand.nextInt(2);
			if (run_random == 0) {
				run();
			}
			else {
				System.out.println("Blue tried to run away but failed!");
			}
		}
		
		
	}

	//Function that allows the computer to run if the random number is selected, but it also has a 50% chance of failing.
	@Override
	public void run() {
		System.out.println("Blue ran away!");
		System.out.println("You win by Default! Thanks for playing!");
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
