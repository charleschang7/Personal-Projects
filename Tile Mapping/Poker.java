import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;



public class Poker implements Runnable{
	
	private Thread thread;
	private boolean running;
	private boolean key1, key2, key3, key4, key5;
	public boolean first = true, enter;
	private BufferStrategy bs;
	private Graphics g;
	private int w, h, y1, y2, y3, y4, y5, card1, card2, card3, card4, card5;
	private final int x1 = 400, x2 = 510, x3 = 620, x4 = 730, x5 = 840;
	private PokerDisplay pokerDisplay;
	public ArrayList<String> deck = new ArrayList<String>();
	public ArrayList<String> hand = new ArrayList<String>(); //Use this!!!!
	private String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private String[] suit = {"♥", "♠", "♦", "♣"};
//	private String[] suit = {"H", "S", "D", "C"};
	private BufferedImage test, test2, test3, test4, test5;
	Color[] color = {Color.BLACK, Color.white, Color.RED};
	
	
	
	public Poker(int w, int h){
		
		this.w = w;
		this.h = h;
		
	}
	
	private void init() {
			
			shuffle();
			
			pokerDisplay = new PokerDisplay(w, h);
			color[0] = new Color(4, 79, 9);
			key1 = pokerDisplay.key1;
			key2 = pokerDisplay.key2;
			key3 = pokerDisplay.key3;
			key4 = pokerDisplay.key4;
			key5 = pokerDisplay.key5;
			y1 = pokerDisplay.y1;
			y2 = pokerDisplay.y2;
			y3 = pokerDisplay.y3;
			y4 = pokerDisplay.y4;
			y5 = pokerDisplay.y5;
			card1 = pokerDisplay.card1;
			card2 = pokerDisplay.card2;
			card3 = pokerDisplay.card3;
			card4 = pokerDisplay.card4;
			card5 = pokerDisplay.card5;
			enter = pokerDisplay.enter;
			first = pokerDisplay.first;
			
			hand.add(deck.get(0));
			hand.add(deck.get(1));
			hand.add(deck.get(2));
			hand.add(deck.get(3));
			hand.add(deck.get(4));

			deck.remove(0);
			deck.remove(1);
			deck.remove(2);
			deck.remove(3);
			deck.remove(4);
	
		}
		
	public void run() {
		
		init();
		
		while(running) {
			
			render();
			tick();
			
			
		}
		
		stop();
	}
private void tick() {
	
	y1 = pokerDisplay.y1;
	y2 = pokerDisplay.y2;
	y3 = pokerDisplay.y3;
	y4 = pokerDisplay.y4;
	y5 = pokerDisplay.y5;
	card1 = pokerDisplay.card1;
	card2 = pokerDisplay.card2;
	card3 = pokerDisplay.card3;
	card4 = pokerDisplay.card4;
	card5 = pokerDisplay.card5;
	enter = pokerDisplay.enter;
	first = pokerDisplay.first;
	
	try {
		
		test = ImageIO.read(new File(hand.get(card1) + ".png"));
		test2 = ImageIO.read(new File(hand.get(card2) + ".png"));
		test3 = ImageIO.read(new File(hand.get(card3) + ".png"));
		test4 = ImageIO.read(new File(hand.get(card4) + ".png"));
		test5 = ImageIO.read(new File(hand.get(card5) + ".png"));
		
	}
	catch (IOException e) {
		
	}
	
		delay(0);
		
		
	}
	
	
	private void render() {
		
		bs = pokerDisplay.getCanvas().getBufferStrategy();
		if(bs == null){
			
			pokerDisplay.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		
		
		Graphics2D g2 = (Graphics2D) g;
		
		if(first){
		g2.setColor(color[0]);
		g.fillRect(0, 0, w, h);
		first = false;
		}
		
		
		
		g2.drawImage(test, x1, y1, 100, 145, null);
		g2.drawImage(test2, x2, y2, 100, 145, null);
		g2.drawImage(test3, x3, y3, 100, 145, null);
		g2.drawImage(test4, x4, y4, 100, 145, null);
		g2.drawImage(test5, x5, y5, 100, 145, null);

		
		bs.show();
		g.dispose();
		
		}
	
	public synchronized void start() {
			
		if(running) { return; }
			
		running = true;
		thread = new Thread(this);
		thread.start();
		}
	
	public synchronized void stop() {
		
		if(!running) { return; }
		
		running = false;
			
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void setCards(){
		for(int i = 0; i < suit.length; i++){
		for(int j = 0; j < number.length; j++){
			deck.add(number[j] + "" + suit[i]);
		}}
	}
	
	public void printCards(){
		System.out.println(deck);
	}
	
	public String getSuit(int i){
		return suit[i];
	}
	
	public String getNumber(int i){
		return number[i];
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	public void enter(){
		if (key1 == true){
			y1 += 30;
			key1 = false;
			first = false;
		}
		if (key2 == true){
			y2 += 30;
			key2 = false;
			first = false;
		}
		if (key3 == true){
			y3 += 30;
			key3 = false;
			first = false;
		}
		if (key4 == true){
			y4 += 30;
			key4 = false;
			first = false;
		}
		if (key5 == true){
			y5 += 30;
			key5 = false;
			first = false;
		}
	}
	
	public void delay(long d) {
			
			try {
				Thread.sleep(d);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
	}
	
}
