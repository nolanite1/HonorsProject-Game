//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Honors Assignment
//  Name: Sailesh Sai Sirigineedi
//  Handler Class

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public void tick(){
        for(int i=0; i<object.size();i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i =0; i<object.size();i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject obj){
        this.object.remove(object);
        this.object.remove(object);
    }
}

