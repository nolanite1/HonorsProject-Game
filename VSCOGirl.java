
//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  VSCOGirl Class
import java.awt.*;

public class VSCOGirl extends GameObject {
    private int lOrR;
    public VSCOGirl(int x, int y, String jpgName){
        super(x,y,jpgName);
        setX(100);
    }
    public void tick(){

        if(getlOrR()==37 && getX()>0){
            velX = -5;
            x = x - 5;
        }
        else if(getlOrR()==39 && getX()<600){
            velX = 5;
            x = x + 5;
        }
        else if(getlOrR()==0){
            x = x;
        }
//        x = x + velX;
    }
    public void render(Graphics g){
        g.drawImage(getImage(),getX(),getY(),100,100,null);
    }
    public int getlOrR(){
        return lOrR;
    }
    public void setlOrR(int e){
        lOrR = e;
    }
}

