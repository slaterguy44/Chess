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
public class Rook extends Chessman{
    public Rook(String color) {
        super(color);
    }
    
    @Override
    public String getName(){
        return "rook";
    }
    
    @Override
    public String getSymbol(){
        return color.equals("white") ? "r" : "R";
    }
    @Override
    public double getPoints(){
        return 5;
    }
    
    
    
    
    
    
    
    
    
}
