package dev.spaccabolle.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class CollectBall {
    
    private ArrayList<Ball> collectionBall;

    public CollectBall() {
        collectionBall = new ArrayList<>();
    }
    
    public void tick() {
        Iterator<Ball> ba = collectionBall.iterator();
        while(ba.hasNext()) {
            Ball b = ba.next();
            b.tick();
        }
    }
    
    public int numBolle() {
        return collectionBall.size();
    }
    
    public ArrayList<Ball> getBolle() {
        return collectionBall;
    }

    public void render(Graphics g) {
        for(Ball b : collectionBall) {
            b.render(g);
        }
    }
    
    public void addBall(Ball b) {
        collectionBall.add(b);
    }

}
