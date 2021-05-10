/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author dlwin
 */
public class Square{
    
    // square's location on panel
    private final int xPos;
    private final int yPos;
    // square's color
    private int shapeColor;
    // squares width and height
    private final int sideLength = 40;
    // default color for square
    private final Color BGCOLOR = new Color(255,255,255);
   
    public Square (int x, int y, int color){
        xPos = x;
        yPos = y;
        shapeColor = color;
           
    }
    
    
  public void draw(Graphics g)
  {
    setColor(g);
    int x = yPos*sideLength;
    int y = xPos*sideLength;
    g.fillRect(x,y,x+sideLength,y+sideLength);                             
  }  
  
  private void setColor(Graphics g){
      
       // Graphics object, g, holds state...remembers color to use for rendering   
    Color sColor; // g requires a Color object   
    
    switch(shapeColor){  
        case 0:
            sColor  = BGCOLOR;
            break;
            
        case 1:
            sColor  = Color.GREEN;
            break;
            
        case 2:
            sColor  = Color.BLUE;
            break; 
            
        case 3:
            sColor = Color.ORANGE;
            break;
            
        default:
             sColor = Color.BLACK;
    } 
    
    g.setColor(sColor); // set the color for g
      
  }
  
  public void updateColor(int c){
      shapeColor = c;  
  }
  
  public int getColor(){
      return shapeColor;
  }

}
