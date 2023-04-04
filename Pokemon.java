import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon implements Comparable<Pokemon>{
	//Variables.
	private int hitPoints;
	private int powerPoints;
	private double attackStat;
	private double defenseStat;
	private String name;
	private String type;
	private List<String> attacks = new ArrayList<>();
	private String battleCry;
	
	public abstract void attack(Pokemon other, int attackIndex);
	public abstract void speak();
	
	public Pokemon() {
		name = "Missingno";
		type = "Normal";
		hitPoints = 139;
		powerPoints = 999;
		attackStat = 187;
		defenseStat = 0;
		battleCry = "............";
	}
	
	//This constructor gives each Pokemon it's stats.
	public Pokemon(int hp, int pp, String name, String Type, List<String> attacks, String bc, double atk, double def) {
		super();
		setHitPoints(hp);
		setPowerPoints(pp);
		setName(name);
		setType(Type);
		setAttacks(attacks);
		setAttackStat(atk);
		setDefenseStat(def);
		setBattleCry(bc);
	}
	
	//Mutators.
	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getPowerPoints() {
		return powerPoints;
	}

	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<String> attacks) {
		this.attacks = attacks;
	}

	public String getBattleCry() {
		return battleCry;
	}

	public void setBattleCry(String battleCry) {
		this.battleCry = battleCry;
	}
	
	public double getAttackStat() {
		return attackStat;
	}
	
	public void setAttackStat(double attackStat) {
		this.attackStat = attackStat;
	}
	
	public double getDefenseStat() {
		return defenseStat;
	}
	
	public void setDefenseStat(double defenseStat) {
		this.defenseStat = defenseStat;
	}
	
	//Method to print out Pokemon.
	public String toString() {
		String s = "";
		s+= "Name: " + name + "\n";
		s+= "Type: " + type + "\n";
		s+= "HP: " + hitPoints + "\n";
		s+= "PP: " + powerPoints + "\n";
		s+= "Attack stat: " + attackStat + "\n";
		s+= "Defense stat: " + defenseStat + "\n";
		s+= "Known moves: " + attacks + "\n";
		return s;
	}
}
