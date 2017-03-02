package packJuego;

public class Battleship {
	private static Battleship theBattleship;
	
	public static void main(String[] args) throws Exception {
		
		jugar();
	}

	private Battleship(){}
	
	public static Battleship getBattleship(){
		if (theBattleship == null){
			theBattleship = new Battleship();
		}
		return theBattleship;
	}
	
	private static void jugar() {
	
	}
}
