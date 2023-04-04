import java.util.ArrayList;
import java.util.List;

public class Blastoise extends Pokemon{
	//Extra variable.
	private String info;
	
	public Blastoise() {
		setInfo("How did you find this?");
	}
	
	//Takes info from the abstract Pokemon class to define Blastois;
	public Blastoise(int hp, int pp, String name, String Type, List<String> attacks, String bc, double atk, double def, String info) {
		super(hp, pp, name, Type, attacks, bc, atk, def);
		setInfo(info);
	}
	
	//Performs the attack on the opposing Pokemon based on the index.
	@Override
	public void attack(Pokemon other, int attackIndex) {
		String battleCry1, PokemonInfo1;
		List<String> moves1 = new ArrayList<>();
		List<String> attackTypes1 = new ArrayList<>();
		List<Integer> basePowers1 = new ArrayList<>();
		List<String> moveDescriptions1 = new ArrayList<>();
		
		//Creates attacks for this Pokemon to use.
		moves1.add("Surf");
		attackTypes1.add("Water");
		basePowers1.add(90);
		moveDescriptions1.add("Blastoise Unleashes a giant wave to attack the opposing Pokemon!");
		Attack Surf = new Attack(moveDescriptions1.get(0), 0, attackTypes1.get(0), basePowers1.get(0));
		
		moves1.add("Ice Beam");
		attackTypes1.add("Ice");
		basePowers1.add(90);
		moveDescriptions1.add("Blastoise fires a freezing beam of ice at the opposing Pokemon!");
		Attack IceBeam = new Attack(moveDescriptions1.get(1), 0, attackTypes1.get(1), basePowers1.get(1));
		
		moves1.add("Earthquake");
		attackTypes1.add("Ground");
		basePowers1.add(100);
		moveDescriptions1.add("Blastoise causes a massive earthquake to damage the opposing Pokemon!");
		Attack Earthquake = new Attack(moveDescriptions1.get(2), 0, attackTypes1.get(2), basePowers1.get(2));
		
		moves1.add("Rock Slide");
		attackTypes1.add("Rock");
		basePowers1.add(75);
		moveDescriptions1.add("Blastoise hurls Large boulders at the opposing Pokemon!");
		Attack RockSlide = new Attack(moveDescriptions1.get(3), 0, attackTypes1.get(3), basePowers1.get(3));
		
		PokemonInfo1 = "A brutal Pokémon with pressurized water jets on its shell. They are used for high speed tackles.";
		battleCry1 = "Blastoooise!";
		
		Blastoise Bl = new Blastoise(186, 45, "Blastoise", "Water", moves1, battleCry1, 148, 172, PokemonInfo1);
		
		int damageDealt;
		int remainingHP;
		
		if (attackIndex == 1) {
			System.out.println(moveDescriptions1.get(0));
			damageDealt = Surf.getDamage(Surf, Bl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (Surf.getDamageMultiplier(attackTypes1.get(0), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (Surf.getDamageMultiplier(attackTypes1.get(0), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (Surf.getDamageMultiplier(attackTypes1.get(0), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 2) {
			System.out.println(moveDescriptions1.get(1));
			damageDealt = IceBeam.getDamage(IceBeam, Bl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (IceBeam.getDamageMultiplier(attackTypes1.get(1), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (IceBeam.getDamageMultiplier(attackTypes1.get(1), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (IceBeam.getDamageMultiplier(attackTypes1.get(1), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 3) {
			System.out.println(moveDescriptions1.get(2));
			damageDealt = Earthquake.getDamage(Earthquake, Bl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (Earthquake.getDamageMultiplier(attackTypes1.get(2), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (Earthquake.getDamageMultiplier(attackTypes1.get(2), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (Earthquake.getDamageMultiplier(attackTypes1.get(2), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 4) {
			System.out.println(moveDescriptions1.get(3));
			damageDealt = RockSlide.getDamage(RockSlide, Bl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (RockSlide.getDamageMultiplier(attackTypes1.get(3), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (RockSlide.getDamageMultiplier(attackTypes1.get(3), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (RockSlide.getDamageMultiplier(attackTypes1.get(3), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
	}

	//Creates the speak function from the abstract class.
	@Override
	public void speak() {
		System.out.println(getBattleCry());
	}
	
	@Override
	public int compareTo(Pokemon o) {
		return 0;
	}

	//Mutators.
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	//Prints Jolteon's info.
	@Override
	public String toString() {
		String s = "";
		s+= "Name: " + getName() + "\n";
		s+= "Type: " + getType() + "\n";
		s+= "HP: " + getHitPoints() + "\n";
		s+= "PP: " + getPowerPoints() + "\n";
		s+= "Attack stat: " + getAttackStat() + "\n";
		s+= "Defense stat: " + getDefenseStat() + "\n";
		s+= "Known moves: " + getAttacks() + "\n";
		s+= "Info: " + info + "\n";
		return s;
	}

}