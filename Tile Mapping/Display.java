package src;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private Boolean keys = true;
	
	private int w, h;
	public int ydS, sS;
	public int xdS = +1;
	
	Game g = new Game(w, h);
	
	public Display(int w, int h) {
		
		this.w = w;
		this.h = h;
		
		createDisplay();
	}
	
	private void createDisplay() {
		
		frame = new JFrame("SNAKE");
		frame.setSize(w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addKeyListener( new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				System.out.println(e.getKeyCode());
				
				switch(e.getKeyCode()) {
				
//					case 38:  break; // up
//					case 40:  break; // down 
//					case 39:  break; // right
//					case 37:  break; // left
					
				case 27: System.exit(0);  break; // escape
				}
			}
		});
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(w, h));
		canvas.setMaximumSize(new Dimension(w, h));
		canvas.setMinimumSize(new Dimension(w, h));
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		
		return canvas;
	}	
}
