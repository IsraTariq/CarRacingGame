

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carr;

/**
 *
 * @author hp
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NewGame implements MouseListener,newGameMethods{
  
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play
        if(mx >= tire.WIDTH/2-50 && mx <= 280){
            if(my >= 200 && my<=250){
                if(tire.State == tire.STATE.MENU){
                    tire.time.start();
                    tire.State = tire.STATE.GAME;
                }
            }
        }
        //help
        if(mx >= tire.WIDTH/2-50 && mx <= 280){
            if(my >= 300 && my <= 350){
                if(tire.State == tire.STATE.MENU){
                    tire.time.start();
                    tire.State = tire.STATE.HELP;
                }
            }
        }
        //exit
        if(mx >= tire.WIDTH/2-50 && mx <= 280){
            if(my >= 400 && my <= 450){
                if(tire.State == tire.STATE.MENU){
                    System.exit(0);
                }
            }
        }
        //back
        if(mx >= tire.WIDTH/2-27 && mx <= 303){
            if(my >= 400 && my <= 450){
                if(tire.State == tire.STATE.HELP){
                    tire.time.start();
                    tire.State = tire.STATE.MENU;
                }
            }
        }
        //retry
        if(mx >= tire.WIDTH/2-100 && mx <= tire.WIDTH/2-40){
            if(my >= 300 && my <= 335){
                  //s.repaint();
                tire.time.restart();
                tire.State = tire.STATE.GAME;
            }
        }
        //menu
        if(mx >= tire.WIDTH/2+50 && mx <= tire.WIDTH/2+110){
            if(my >= 300 && my <= 335){
                tire.time.start();
                tire.State = tire.STATE.MENU;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
      
}