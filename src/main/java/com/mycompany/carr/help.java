/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carr;

/**
 *
 * @author hp
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//for user guidence
public class help extends JPanel{
    
    private final Rectangle BackButton = new Rectangle(tire.WIDTH/2-27,400,80,50);
    private final Rectangle car1;
    private final Image backGroundimage;
    public JButton start;
    public help(){
        
        ImageIcon BI = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\back.png");
        backGroundimage = BI.getImage();
        car1 = new Rectangle(0, 0, 500, 770);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backGroundimage, car1.x, car1.y, this);
        Font font = new Font("ariel",Font.BOLD,14);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Q - To Move the Left car LEFT",tire.WIDTH/2-220, 100);
        g.drawString("E - To Move the Right car RIGHT",tire.WIDTH/2-220, 150);
        g.drawString("Left arrow key - To Move the Left car LEFT",tire.WIDTH/2-220, 200);
        g.drawString("Right arrow key - To Move the right car RIGHT",tire.WIDTH/2-220, 250);
        Font fon = new Font("ariel",Font.BOLD,22);
        g.setColor(Color.white);
        g.setFont(fon);
        g.drawString("BACK", BackButton.x+8, BackButton.y+35);
        g2d.draw(BackButton);
}
}
