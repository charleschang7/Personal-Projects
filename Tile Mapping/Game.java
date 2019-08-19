package src;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game implements Runnable {
	
	private Display display;
	private Boolean first = true;
	private Boolean running = false;
	static  Boolean keys = true;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	int w, h;
	int r = 30, dr = 1;
	
	int b = 100;
	
	int[]  rgb = {30, 130, 230};
	int[] drgb = {-1, 1, 1};
	
	int[][] map = { {0,0,0,0,0,0,0,0,0,0,0,0},
					{0,1,0,0,0,1,0,1,1,1,0,0},
					{0,0,1,0,1,0,0,1,0,0,1,0},
					{0,0,0,1,0,0,0,1,0,0,1,0},
					{0,0,1,0,1,0,0,1,0,0,1,0},
					{0,1,0,0,0,1,0,1,1,1,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0,0,0} };
	
	Color[] color = {Color.BLACK, Color.white, Color.RED};
	
	
	public Game(int w, int h) {
		
		this.w = w;
		this.h = h;
	}
	
	private void init() {
		
		display = new Display(w, h);
		

	}
	
	private void tick() {
		
		delay(5);
		
		// color cycle
		for(int i = 0; i < rgb.length; i++) {
			
			rgb[i] += drgb[i];
			
			if(rgb[i] >= 255) drgb[i] *= -1;
			if(rgb[i] <= 0)   drgb[i] *= -1;
		}
		
		// change color[1]
		color[1] = new Color(rgb[0], rgb[1], rgb[2]);
		color[0] = new Color(255-rgb[0], 255-rgb[1], 255-rgb[2]);
		
		
		
		
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		if(first) {
			first = false;
			
		}
		
		// DRAW HERE
		
//		g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
//		g.fillRect(0, 0, w, h);
		
		// tile map
		for(int i = 0; i < map.length; i++) {
		for(int j = 0; j < map[i].length; j++) {
			
			delay(10);
			
			g.setColor(color[map[i][j]]);	// changes color		
			g.fillRect(j*b, i*b, b, b);		// draws tile
			
			bs.show();
		}}
		
		
		
		
		

		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		while(running) {
			
			tick();
			render();
		}
		
		stop();
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
	
	public int rand(int min, int max) {
		
		Random random = new Random();
		int rn = random.nextInt(max) + min;
		
		return rn;
	}
	
	public void delay(long d) {
		
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	
	
	// RANDOM METHOD
}
