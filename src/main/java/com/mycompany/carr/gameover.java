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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class gameover extends JPanel {
    private final String restart = "Press space to Restart",menu = "Press Enter to Back",message = "Game Over",score = "Your Score: ";
    private final Rectangle retry = new Rectangle(tire.WIDTH/2-100,300,60,35);
    private final Rectangle back = new Rectangle(tire.WIDTH/2+50,300,60,35);
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        
        setBackground(Color.BLACK);
        Font font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics metr = this.getFontMetrics(font);

        Font fon = new Font("Verdana",Font.BOLD,30);
        g2d.setFont(fon);
        g2d.setColor(Color.YELLOW);
        g2d.drawString(message,
                (tire.WIDTH - metr.stringWidth(message)) / 2,
                tire.WIDTH / 2);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(score + tire.score, (tire.WIDTH - metr.stringWidth(score))/2, tire.WIDTH /2 + 25);
        g2d.drawString(restart,
                (tire.WIDTH - metr.stringWidth(restart)) / 2,
                tire.WIDTH / 2+75);
        g2d.drawString(menu,
                (tire.WIDTH - metr.stringWidth(menu)) / 2,
                tire.WIDTH / 2+100);   
        
    }
}