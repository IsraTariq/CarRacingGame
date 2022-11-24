/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carr;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

public class menu extends JPanel{
    
    private final Rectangle playButton = new Rectangle(tire.WIDTH/2-50,200,80,50);
    private final Rectangle helpButton = new Rectangle(tire.WIDTH/2-50,280,80,50);
    private final Rectangle quitButton = new Rectangle(tire.WIDTH/2-50,360,80,50);
    tire game;
    private JFrame frame;
    private final Rectangle car1;
    private final Image backGroundimage;
    public JButton start;
    public menu(){
        
        ImageIcon BI = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\dd.jpg");
        backGroundimage = BI.getImage();
        car1 = new Rectangle(0, 0, 500, 770);
    }
    
    public void f(){
        frame = new JFrame();
        frame.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backGroundimage, car1.x, car1.y, this);
        Font font = new Font("acme",Font.ITALIC,30);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("CAR RACING GAME ",tire.WIDTH/44, 100);
        Font f=new Font("acme",font.BOLD,20);
        g.setFont(f);
        g.drawString("High Score : "+tire.HIGHscore, tire.WIDTH/2-65, 150);
        Font fon = new Font("ariel",font.BOLD,16);
        g.setFont(fon);
        g.drawString("PLAY",playButton.x + 19,playButton.y+27);
        g2d.draw(playButton);
        g.drawString("HELP",helpButton.x + 19,helpButton.y+27);
        g2d.draw(helpButton);
        g.drawString("QUIT",quitButton.x + 19,quitButton.y+27);
        g2d.draw(quitButton);
} 
}
