
public class PokerLauncher {	
	public static void main(String [] args){
		Poker game = new Poker(1400, 900);
		game.setCards();
		game.printCards();
		game.start();
		
	}
}
