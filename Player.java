
public abstract class Player{
	
	//Has the info for the player's Pokemon as well as what item they have.
	public Player(Pokemon myPokemon, Item potion) {
		super();
		myPokemon.getHitPoints();
		myPokemon.getAttacks();
		myPokemon.getAttackStat();
		myPokemon.getBattleCry();
		myPokemon.getDefenseStat();
		myPokemon.getPowerPoints();
		myPokemon.getType();
		myPokemon.getName();
	}
	
	public abstract void run();
	
}
