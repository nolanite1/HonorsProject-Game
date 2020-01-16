//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  KeyInput Class

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyInput extends KeyAdapter {
    private Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key==37){
            Game.vscoGirl.setlOrR(37);
        }
        else if(key==39){
            Game.vscoGirl.setlOrR(39);
        }
        else if(key==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(key == KeyEvent.VK_P) {
        	Game.paused = !Game.paused;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        Game.vscoGirl.setlOrR(0);
//        Game.vscoGirl.setX(Game.vscoGirl.getX());
    }
}

