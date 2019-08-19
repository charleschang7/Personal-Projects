package src;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game(1200, 800);
		game.start();
	}
}
