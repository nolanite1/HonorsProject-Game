//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  HUD(Heads Up Display) Class

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HUD {
    public static int lives = 3;
    public static int HEALTH = 100;
    public static void hit(){
        lives--;
    }
    public void tick(){
        HEALTH--;
    }
    public void render(Graphics g){
        Image image;
        try {
            image = ImageIO.read(new File("Heart.png"));
            for(int i=0;i<lives;i++){
                g.drawImage(image,15+i*32,15,32,32,null);
            }
//            g.drawImage(image,15,15,32,32,null);
//            g.drawImage(image,47,15,32,32,null);
//            g.drawImage(image,79,15,32,32,null);

        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
//        g.drawImage(image,15,15,32,32,null);
//        Image image = ImageIO.read(new File("/Users/sai2468/Downloads/Heart.png"));
//        g.drawImage(ImageIO.read(new File("/Users/sai2468/Downloads/Heart.png")));
//        g.setColor(Color.gray);
//        g.fillRect(15,15,200,32);
//        g.setColor(Color.green);
//        g.fillRect(15,15,HEALTH*2,32);
//        g.setColor(Color.red);
//        g.drawRect(15,15,200,32);
    }
}

