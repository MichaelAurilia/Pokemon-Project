import java.util.Scanner;
import java.io.File;

/* 
 * Legend:
 * 0: Bug
 * 1: Dragon
 * 2: Electric
 * 3: Fighting
 * 4: Fire
 * 5: Flying
 * 6: Ghost
 * 7: Grass
 * 8: Ground
 * 9: Ice
 * 10: Normal
 * 11: Poison
 * 12: Psychic
 * 13: Rock
 * 14: Water
 * 15: Null
*/

public class Attack {
	private String attackDescription;
	private int powerPointsCost;
	private String attackType;
	private int baseDamage;
	
	Scanner input;
	static String[][] grid = new String[16][16];
	
	
	public Attack() {
		attackDescription = "The user Has no moves left and struggles!";
		powerPointsCost = 0;
		attackType = "Null";
		baseDamage = 50;
	}
	
	public Attack(String ad, int ppCost, String at, int bd) {
		setAttackDescription(ad);
		setAttackType(at);
		setPowerPointsCost(ppCost);
		setBaseDamage(bd);
	}
	
	public double getDamageMultiplier(String at, Pokemon other) {
		//Reads in the type flowchart from a file
		try {
			input = new Scanner(new File("C:\\Users\\miro1\\eclipse-workspace\\PokemonLab\\src\\TypeInfo.txt"));
		} catch(Exception e) {
			//code to deal with this exception
			e.printStackTrace();
			System.out.println("Error opening the file!");
			input = new Scanner(System.in);
		}
		
		for(int r = 0; r < grid.length; r++) {
			   for(int c = 0; c < grid[r].length; c++) {
			      grid[r][c] = input.next().trim();
			   }
			}
		input.close();
		
		//Sets values based on the type of the attack. The 15 is a default case which has all its interactions as no multiplier
		int attackType = 15;
		int oppType = 15;
		
		//Turns the attacks type into an int.
		if(at == "Bug") {
			attackType = 0;
		}
		else if (at == "Dragon"){
			attackType = 1;
		}
		else if (at == "Electric"){
			attackType = 2;
		}
		else if (at == "Fighting"){
			attackType = 3;
		}
		else if (at == "Fire"){
			attackType = 4;
		}
		else if (at == "Flying"){
			attackType = 5;
		}
		else if (at == "Ghost"){
			attackType = 6;
		}
		else if (at == "Grass"){
			attackType = 7;
		}
		else if (at == "Ground"){
			attackType = 8;
		}
		else if (at == "Ice"){
			attackType = 9;
		}
		else if (at == "Normal"){
			attackType = 10;
		}
		else if (at == "Poison"){
			attackType = 11;
		}
		else if (at == "Psychic"){
			attackType = 12;
		}
		else if (at == "Rock"){
			attackType = 13;
		}
		else if (at == "Water"){
			attackType = 14;
		}
		else if (at == "Null") {
			attackType = 15;
		}
		
		//Turns the opposing Pokemon's type to an int.
		if (other.getType() == "Bug") {
			oppType = 0;
		}
		else if (other.getType() == "Dragon"){
			oppType = 1;
		}
		else if (other.getType() == "Electric"){
			oppType = 2;
		}
		else if (other.getType() == "Fighting"){
			oppType = 3;
		}
		else if (other.getType() == "Fire"){
			oppType = 4;
		}
		else if (other.getType() == "Flying"){
			oppType = 5;
		}
		else if (other.getType() == "Ghost"){
			oppType = 6;
		}
		else if (other.getType() == "Grass"){
			oppType = 7;
		}
		else if (other.getType() == "Ground"){
			oppType = 8;
		}
		else if (other.getType() == "Ice"){
			oppType = 9;
		}
		else if (other.getType() == "Normal"){
			oppType = 10;
		}
		else if (other.getType() == "Poison"){
			oppType = 11;
		}
		else if (other.getType() == "Psychic"){
			oppType = 12;
		}
		else if (other.getType() == "Rock"){
			oppType = 13;
		}
		else if (other.getType() == "Water"){
			oppType = 14;
		}
		else if (other.getType() == "Null") {
			oppType = 15;
		}
		
		//Reads the data from the array to determine the effectiveness of the move against the opposing Pokemon.
		String effect = grid[oppType][attackType];
		
		//Return the multiplier of the attack based on the type effectiveness.
		if (effect.equals("s")) {
			return 2;
		}
		else if (effect.equals("n")) {
			return 0;
		}
		else if (effect.equals("r")) {
			return 0.5;
		}	
		else {
			return 1;
		}
	}
	
	public int getDamage(Attack move, Pokemon myPokemon, Pokemon other) {
		//Calculates the damage each attack does
		double STAB; //This stands for Same-Type-Attack-Bonus
		if (attackType == myPokemon.getType()) {
			STAB = 1.5;
		}
		else {
			STAB = 1;
		}
		
		double damageMultiplier = move.getDamageMultiplier(attackType, other);
		double AOverD = myPokemon.getAttackStat() / other .getDefenseStat();
		
		//This is the actual way Pokemon damage is calculated I looked up the formula.
		double totalDamage = (((22 * move.getBaseDamage() * AOverD) / 50) + 2) * STAB * damageMultiplier;
		
		//Casts the damage to an int to better relate to the HP which is also an int.
		int roundedDamage = (int)totalDamage;
		return roundedDamage;
	}
	
	//Mutators.
	public String getAttackDescription() {
		return attackDescription;
	}

	public void setAttackDescription(String attackDescription) {
		this.attackDescription = attackDescription;
	}

	public String getAttackType() {
		return attackType;
	}

	public void setAttackType(String attackType) {
		this.attackType = attackType;
	}

	public int getPowerPointsCost() {
		return powerPointsCost;
	}

	public void setPowerPointsCost(int powerPointsCost) {
		this.powerPointsCost = powerPointsCost;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
}