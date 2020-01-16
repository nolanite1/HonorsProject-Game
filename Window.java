//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  Window Class

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Window extends Canvas{
    public Window(int width, int height, String title, Game game)
    {	
    	JMenuBar jmb = new JMenuBar();
    	JMenu instructions = new JMenu("INSTRUCTIONS");
    	JMenu restart = new JMenu("RESTART");
    	jmb.add(instructions);
    	JMenuItem opened = new JMenuItem("You control the VSCO Girl to catch the straws in the oceans");
    	JMenuItem opened2 = new JMenuItem("Press left key to control VSCO Girl to left");
    	JMenuItem opened3 = new JMenuItem("Press right key to control VSCO Girl to right");
    	JMenuItem opened4 = new JMenuItem("If you miss a straw, you loose a life indicated by the hearts");
    	JMenuItem opened5 = new JMenuItem("If you loose all 3 lives, you loose");
    	JMenuItem opened6 = new JMenuItem("You may press the Play Again button if you lost");
	JMenuItem opened7 = new JMenuItem("Press Save to save current game and load to load previous game");
    	instructions.add(opened);
    	instructions.add(opened2);
    	instructions.add(opened3);
    	instructions.add(opened4);
    	instructions.add(opened5);
    	instructions.add(opened6);
	instructions.add(opened7);
    	//JMenuItem opened = new JMenuItem("Here are the instructions");
    	JMenuItem menuItem = new JMenuItem(new AbstractAction("PAUSE/RESUME") {
    	    public void actionPerformed(ActionEvent e) {
    	        //System.out.println("Button Pressed");
    	        game.paused = !game.paused;
    	    }
    	});
    	JMenuItem menuItem2 = new JMenuItem(new AbstractAction("RESTART") {
    	    public void actionPerformed(ActionEvent e) {
    	        //System.out.println("Button Pressed");
    	    	if(game.gameOver) {
    	    		HUD.lives = 3;
    	    		Straw.score =0;
    	    	}
    	    	
//    	        game.gameOver = !game.gameOver;
    	    }
    	});
    	JMenuItem menuItem3 = new JMenuItem(new AbstractAction("EXIT") {
    		public void actionPerformed(ActionEvent e) {
    			SaveData data = new SaveData();
    			data.hp = Straw.score;
    			data.girlPos = Game.vscoGirl.getX();
    			data.strawPos = Game.straw.getX();
    			data.strawPos2 = Game.straw.getY();
    			data.health = HUD.lives;
    			try {
    				ResourceManager.save(data, "1.save");
    			}catch(Exception e1) {
    				System.out.println("Couldn't save file" + e1.getMessage());
    			}
    			System.exit(0);
    		}
    	});
    	JMenuItem menuItem4 = new JMenuItem(new AbstractAction("SAVE") {
    		public void actionPerformed(ActionEvent e) {
    			SaveData data = new SaveData();
    			data.hp = Straw.score;
    			data.girlPos = Game.vscoGirl.getX();
    			data.strawPos = Game.straw.getX();
    			data.strawPos2 = Game.straw.getY();
    			data.health = HUD.lives;
    			try {
    				ResourceManager.save(data, "1.save");
    			}catch(Exception e1) {
    				System.out.println("Couldn't save file" + e1.getMessage());
    			}
    		}
    	});
    	JMenuItem menuItem5 = new JMenuItem(new AbstractAction("LOAD PREVIOUS GAME") {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				SaveData data = (SaveData) ResourceManager.load("1.save");
    				Straw.score = data.hp;
    				Game.vscoGirl.setX(data.girlPos);
    				Game.straw.setX(data.strawPos);
    				Game.straw.setY(data.strawPos2);
    				HUD.lives = data.health;
    			}catch(Exception e1) {
    				System.out.println("Couldn't load saved file");
    			}
    		}
    	});
    	JMenuItem pause = new JMenu("PAUSE");
    	JMenuItem help = new JMenu("INSTRUCTIONS");
    	jmb.add(menuItem);
    	jmb.add(menuItem2);
    	jmb.add(menuItem3);
    	jmb.add(menuItem4);
    	jmb.add(menuItem5);
//    	jmb.add(pause);
//    	jmb.add(help);
    	jmb.setVisible(true);
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setJMenuBar(jmb);
        frame.setVisible(true);
        game.start();
    }
}

