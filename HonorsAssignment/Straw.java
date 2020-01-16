//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  Straw Class
import java.awt.*;
public class Straw extends GameObject{
    private int startingPoint;
    public static int score;
    public Straw(int x, int y, String jpgName){
        super(x,y,jpgName);
        startingPoint = (int) (Math.random()*600);
//        System.out.println(startingPoint);
        this.setX(startingPoint);
        this.setY(0);
        velY= 4;
    }
    public void tick(){
        y+=velY;
            if(getY()>700){
//                System.out.println("Out of bounds");
                HUD.hit();
                this.setX((int)(Math.random()*600));
                this.setY(0);
            }
            if(this.overlaps(Game.vscoGirl)){
                  this.setX((int)(Math.random()*600));
                  this.setY(0);
                  score+=10;
//                System.out.println("Straw was caught");
            }
//        if(this.outOfBounds()){
//            System.out.println("Out of screen");
//            this.setX((int)(Math.random()*700));
//            this.setY(0);
//        }
//        System.out.println(getY());
    }
    public void render(Graphics g){
        g.drawImage(getImage(),getX(),getY(),100,130,null);
    }
}

