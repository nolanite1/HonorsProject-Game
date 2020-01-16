//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  Game Class
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable {
	public enum STATE {
		Menu, Game
	};
	Image background;
	public STATE gameState = STATE.Game;
	public static boolean gameOver;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	public static boolean paused = false;
	public static VSCOGirl vscoGirl = new VSCOGirl(0, 500, "VSCOGirl.png");
	public static Straw straw = new Straw(0,500,"straw2.png");
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Save The Turtles", this);
		hud = new HUD();
		// "/Users/sai2468/Downloads/VSCOGirl.jpg"
		handler.addObject(vscoGirl);
//        handler.addObject(new VSCOGirl(0,500,"/Users/sai2468/Downloads/VSCOGirl.jpg"));
		handler.addObject(straw);
//		handler.addObject(new Straw(0, 500, "/Users/sai2468/Downloads/straw2.png"));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		while (running) {
			tick();
			render();
		}
		stop();
	}

	private void tick() {
		if (gameState == STATE.Game) {
			if (HUD.lives == 0) {
				gameOver = true;
			}
			else {
				gameOver = false;
			}
			if (!paused && !gameOver) {
				handler.tick();
				hud.tick();
			}

		}

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if (paused) {
			g.setColor(Color.black);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g.drawString("PAUSED", 400, 100);
		}
		if (gameOver) {
//			Straw.score = 0;
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g.drawString("GAME OVER", 350, 350);
		}
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString("SCORE: " + Straw.score, 100, 100);
		handler.render(g);
//        hud.tick();
		if (gameState == STATE.Game) {
			hud.render(g);
		}
//        handler.tick();
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game();
	}
}

