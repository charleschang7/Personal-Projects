	import java.awt.Canvas;
	import java.awt.Dimension;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;

	import javax.swing.JFrame;

public class PokerDisplay {

		private JFrame frame;
		private Canvas canvas;
		public boolean key1 = false, key2 = false, key3 = false, key4 = false, key5 = false;
		public int card1 = 0, card2 = 1, card3 = 2, card4 = 3, card5 = 4;
		private int w, h;
		public int y1 = 700, y2 = 700, y3 = 700, y4 = 700, y5 = 700;
		public boolean enter = false, first = true;
		
		Poker g = new Poker(w, h);
		
		public PokerDisplay(int w, int h) {
			
			this.w = w;
			this.h = h;
			
			createDisplay();
		}
		
		private void createDisplay() {
			
			frame = new JFrame("Poker");
			frame.setSize(w, h);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setUndecorated(true);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.addKeyListener( new KeyAdapter() {
				
				public void keyPressed(KeyEvent e) {
					
					System.out.println(e.getKeyCode());
					
					first = false;
					
					switch(e.getKeyCode()) {
					
						case 49: one();  break; // 1
						case 50: two();  break; // 2 
						case 51: three(); break; // 3
						case 52: four(); break; // 4
						case 53: five(); break; // 5
						case 10: enter(); break; // Enter
						
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
		
		public void one(){
			 
			 if(key1 == false){
				 y1 -= 30;
				 key1 = true;
			 }
			 else{
				 y1 += 30;
				 key1 = false;
			 }
		}
		
		public void two(){
			 
			 if(key2 == false){
				 y2 -= 30;
				 key2 = true;
			 }
			 else{
				 y2 += 30;
				 key2 = false;
			 }
		}
		
		public void three(){
			 
			 if(key3 == false){
				 y3 -= 30;
				 key3 = true;
			 }
			 else{
				 y3 += 30;
				 key3 = false;
			 }
		}
		public void four(){
			 
			 if(key4 == false){
				 y4 -= 30;
				 key4 = true;
			 }
			 else{
				 y4 += 30;
				 key4 = false;
			 }
		}
		public void five(){
			 
			 if(key5 == false){
				 y5 -= 30;
				 key5 = true;
			 }
			 else{
				 y5 += 30;
				 key5 = false;
			 }
		}
		
		public void enter(){
			enter = true;
		}
	
}
