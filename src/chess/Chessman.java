/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author 55slaterbc30
 */
public abstract class Chessman {
    
    protected String color;
    
    public Chessman(String color) {
        this.color=color;
    }
    
    public abstract String getName();
    
    public abstract String getSymbol();
    
    public String getColor() {
        return color;
        
    }
    public abstract double getPoints();
    
    @Override
    public String toString() {
        return getColor() + " " + getName() + " valued at " + getPoints() + " points";
    }
    
}
