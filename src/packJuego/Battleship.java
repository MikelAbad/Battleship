package packJuego;

public class Battleship {
	private static Battleship theBattleship;
	
	public static void main(String[] args) throws Exception {
		
	}

	private Battleship(){}
	
	public static Battleship getBattleship(){
		if (theBattleship == null){
			theBattleship = new Battleship();
		}
		return theBattleship;
	}
}
