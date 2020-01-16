//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  Game Object Class
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public abstract class GameObject {
    protected String jpgName;
    protected Image image;
    protected int x,y;
    protected int velX,velY;

    public GameObject(int x, int y, String jpgName){
        setImage(jpgName);
        this.x = x;
        this.y = y;
    }
    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
    }
    public Image getImage(){
        return image;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public boolean outOfBounds(){
        if(this.getVelY()>700){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean overlaps(GameObject s){
        if(s.getX()+100<this.getX()){
            return false;
        }
        else if(this.getX()+100<s.getX()){
            return false;
        }
        else if(this.getY()+100<s.getY()){
            return false;
        }
        else if(s.getY()+100<this.getY()){
            return false;
        }
        return true;
    }
}

