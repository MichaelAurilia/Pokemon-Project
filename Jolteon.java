import java.util.ArrayList;
import java.util.List;

public class Jolteon extends Pokemon{
	//Extra variable.
	private String info;
	
	public Jolteon() {
		setInfo("How did you find this?");
	}
	
	//Takes info from the abstract Pokemon class to define Jolteon;
	public Jolteon(int hp, int pp, String name, String Type, List<String> attacks, String bc, double atk, double def, String info) {
		super(hp, pp, name, Type, attacks, bc, atk, def);
		setInfo(info);
	}
	
	//Performs the attack on the opposing Pokemon based on the index.
	@Override
	public void attack(Pokemon other, int attackIndex) {
		String battleCry2, PokemonInfo2;
		List<String> moves2 = new ArrayList<>();
		List<String> attackTypes2 = new ArrayList<>();
		List<Integer> basePowers2 = new ArrayList<>();
		List<String> moveDescriptions2 = new ArrayList<>();
		
		//Creates attacks for this Pokemon to use.
		moves2.add("Thunderbolt");
		attackTypes2.add("Electric");
		basePowers2.add(90);
		moveDescriptions2.add("Jolteon unleahes a strong electric blast to crash down on the opposing Pokemon!");
		Attack Thunderbolt = new Attack(moveDescriptions2.get(0), 0, attackTypes2.get(0), basePowers2.get(0));
		
		moves2.add("Quick Attack");
		attackTypes2.add("Normal");
		basePowers2.add(40);
		moveDescriptions2.add("Jolteon lunges at the opposing Pokemon at a speed that makes it almost invisible!");
		Attack QuickAttack = new Attack(moveDescriptions2.get(1), 0, attackTypes2.get(1), basePowers2.get(1));
		
		moves2.add("Shadow Ball");
		attackTypes2.add("Ghost");
		basePowers2.add(80);
		moveDescriptions2.add("Jolteon hurls a shadowy blob at the opposing Pokemon!");
		Attack ShadowBall = new Attack(moveDescriptions2.get(2), 0, attackTypes2.get(2), basePowers2.get(2));
		
		moves2.add("Double Kick");
		attackTypes2.add("Fighting");
		basePowers2.add(60);
		moveDescriptions2.add("The opposing Pokemon is quickly kicked twice in succession by Jolteon!");
		Attack DoubleKick = new Attack(moveDescriptions2.get(3), 0, attackTypes2.get(3), basePowers2.get(3));
		
		PokemonInfo2 = "It accumulates negative ions in the atmosphere to blast out 10000-volt lightning bolts.";
		battleCry2 = "Jolteeee!";
		
		//Creates a seperate jolteon object that really is only needed for the attack stat and type of Jolteon.
		Jolteon Jl = new Jolteon(145, 50, "Jolteon", "Electric", moves2, battleCry2, 172, 152, PokemonInfo2);
		
		int damageDealt;
		int remainingHP;
		
		if (attackIndex == 1) {
			System.out.println(moveDescriptions2.get(0));
			damageDealt = Thunderbolt.getDamage(Thunderbolt, Jl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (Thunderbolt.getDamageMultiplier(attackTypes2.get(0), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (Thunderbolt.getDamageMultiplier(attackTypes2.get(0), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (Thunderbolt.getDamageMultiplier(attackTypes2.get(0), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 2) {
			System.out.println(moveDescriptions2.get(1));
			damageDealt = QuickAttack.getDamage(QuickAttack, Jl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (QuickAttack.getDamageMultiplier(attackTypes2.get(1), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (QuickAttack.getDamageMultiplier(attackTypes2.get(1), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (QuickAttack.getDamageMultiplier(attackTypes2.get(1), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 3) {
			System.out.println(moveDescriptions2.get(2));
			damageDealt = ShadowBall.getDamage(ShadowBall, Jl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (ShadowBall.getDamageMultiplier(attackTypes2.get(2), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (ShadowBall.getDamageMultiplier(attackTypes2.get(2), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (ShadowBall.getDamageMultiplier(attackTypes2.get(2), other) == 0) {
				System.out.println("The move had no effect.");
			}
			System.out.println(other.getName() + " takes " + damageDealt + " damage!");
		}
		else if (attackIndex == 4) {
			System.out.println(moveDescriptions2.get(3));
			damageDealt = DoubleKick.getDamage(DoubleKick, Jl, other);
			remainingHP = other.getHitPoints() - damageDealt;
			other.setHitPoints(remainingHP);
			if (DoubleKick.getDamageMultiplier(attackTypes2.get(3), other) == 2) {
				System.out.println("It's super effective!");
			}
			else if (DoubleKick.getDamageMultiplier(attackTypes2.get(3), other) == 0.5) {
				System.out.println("It's not very effective...");
			}
			else if (DoubleKick.getDamageMultiplier(attackTypes2.get(3), other) == 0) {
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

	//Mutators.
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public int compareTo(Pokemon o) {
		return 0;
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