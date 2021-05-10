/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dlwin
 */
public class RecursionMaze extends JPanel{
    
    // Matrix to hold color squares.
    private final Square[][] mSquares = new Square[10][10];
 
    
    @Override
     public void paintComponent(Graphics g)
     {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //  to paint the background called when jpanel is created, resized, on
        // demand
        
         for(int i=0;i<10;i++){
             for(int j=0;j<10;j++){
                 mSquares[i][j].draw(g);
             }
         }
                
       }
    
   
     public void setUpWindow(){
         
      // add button and event listerner for button, need panel to attach button
       JPanel buttonPanel = new JPanel();  
       buttonPanel.setBounds(200,490,200,40);    
       JButton solveButton = new JButton("Solve Maze");     
       solveButton.setBounds(200,490,200,40);  
       buttonPanel.add(solveButton);

         
       JFrame window = new JFrame("Maze of Recursion");
       window.setSize(600,600);    
       window.setLayout(null);    
       window.setVisible(true);    
       window.setResizable(false);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       window.setLocationRelativeTo(null); // center 
       window.add(this); //add RecursionMaze panel
       window.add(buttonPanel); //add button panel
       setUpMaze(); // set maze to solve

     Solver solver = new Solver(mSquares, 10);
     solveButton.addActionListener((ActionEvent e) -> {
         solver.solveMaze(0, 0);
         window.repaint();
     });
        
             
  }
     
     private void setUpMaze(){
         // 0 is white, 1 is green, the maze to solve
           for(int i=0;i<10;i++){
             for(int j=0;j<10;j++){
                 int c = 0;
                 if(i==0 && j == 0)c=1;
                 if(i==0 && j == 1)c=1;
                 if(i==1 && j == 1)c=1;
                 if(i==1 && j == 2)c=1;
                 if(i==1 && j == 3)c=1;
                 if(i==1 && j == 4)c=1;
                 if(i==2 && j == 4)c=1;
                 if(i==3 && j == 2)c=1;
                 if(i==3 && j == 3)c=1;
                 if(i==3 && j == 4)c=1;
                 if(i==4 && j == 2)c=1;
                 if(i==5 && j == 2)c=1;
                 if(i==5 && j == 4)c=1;
                 if(i==5 && j == 5)c=1;
                 if(i==5 && j == 6)c=1;
                 if(i==5 && j == 7)c=1;
                 if(i==6 && j == 2)c=1;
                 if(i==6 && j == 3)c=1;
                 if(i==6 && j == 4)c=1;
                 if(i==6 && j == 7)c=1;
                 if(i==7 && j == 6)c=1;
                 if(i==7 && j == 7)c=1;
                 if(i==8 && j == 6)c=1;
                 if(i==9 && j == 6)c=1;
                 if(i==9 && j == 7)c=1;
                 if(i==9 && j == 8)c=1;
                 if(i==9 && j == 9)c=1;
                 mSquares[i][j] = new Square(i,j,c);
                   
             }
             
         }
         
     }
   
        
      
       public static void main(String[] args) {
        // instantiate panel to hold maze
        RecursionMaze panel = new RecursionMaze();
        Color myColor;
        myColor = new Color(255,255,255); // RGB values 
        panel.setBackground(myColor);  
        panel.setBounds(100,50,400,400);  // location on window  
        panel.setUpWindow(); // setup window to add panel(s)
       
    }
    
}
