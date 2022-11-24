 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carr;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author hp
 */
public class tire extends JPanel implements ActionListener,KeyListener{
    private int space;
    private FileWriter write;
    private String HIGH;
    public Dialog parent;
    public static int score =0;
    public static int HIGHscore = 0;
    private boolean game=true,menu = true,restart = false;
    public boolean menuu;
    private Font font;
    private Image playercar13,backgroundimage,oponentcarleft,oponentcarright,playercar1,playercar2,backGroundimage;
    private double speed=30,speed1;
    private int width = 50;
    private int height = 92;
    Graphics ss;
    private String line;
    private int existed=0;
    private Graphics2D d;
    private int widthline = 198;
    private int heightline = 700;
    public final static int WIDTH = 500;
    public final static int HEIGHT = 770;
    private int move=50;
    private int movee = 30;
    private int count=1;
    BufferedReader read;
      BufferedReader read2;
    private Rectangle car1,car2,car3;
    private ArrayList <Rectangle> leftcars,backgroundimages,rightcars;
    private Random rand;
    public static Timer time;
    private BufferedImage explosion;
    private int[] pscores;
    
    menu Menu;
    help Help;
    gameover Gameover;
    NewGame gama;
    tire tt;

    
    
    public static enum STATE{
        MENU,
        GAME,
        HELP
    };
    public static STATE State = STATE.MENU;
    public tire() throws IOException{
          
        BufferedImage playercar = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\carr\\carracer.png"));
        
        explosion = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\carr\\explosion.png"));
        
        try{
            read = new BufferedReader(new FileReader("C:\\Users\\hp\\Desktop\\Scoreofplayer1.txt"));
            line = read.readLine();
            HIGHscore = Integer.parseInt(line);
           
        }catch(IOException | NumberFormatException ex){System.out.println("Not");}
          try{
            read2 = new BufferedReader(new FileReader("C:\\Users\\hp\\Desktop\\Scoreofplayer2.txt"));
            line = read2.readLine();
            HIGHscore = Integer.parseInt(line);
            
        }catch(IOException | NumberFormatException ex){System.out.println("Not");}
          

         ImageIcon ii = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\carracer.png");
        playercar1 = ii.getImage();
        ImageIcon iii = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\carracer3.png");
        playercar13 = iii.getImage();
        ImageIcon o = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\carracer2.png");
        playercar2 = o.getImage();
        ImageIcon i = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\carborder.png");
        oponentcarright = i.getImage();
        ImageIcon le = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\caroponent.png");
        oponentcarleft = le.getImage();
        ImageIcon BI = new ImageIcon("C:\\Users\\hp\\Desktop\\carr\\Background3.png");
        backGroundimage = BI.getImage();
        time = new Timer(50, this);
        rand = new Random();
        Menu = new menu();
        Help = new help();
        Gameover = new gameover();
        leftcars = new ArrayList<Rectangle>();
        rightcars = new ArrayList<Rectangle>();
        backgroundimages = new ArrayList<Rectangle>();
        car1 = new Rectangle(WIDTH/2-85, HEIGHT-150, width, height);
        car2 = new Rectangle(WIDTH/2+36, HEIGHT-150, width, height);
        car3 = new Rectangle(WIDTH/2-126,HEIGHT-150, 77, height);
        space = 300;
        speed1 = 6;
       
        addKeyListener(this);
        addMouseListener(new NewGame());
        setFocusable(true);
        addleftcars(true);
        addrightcars(true);
        addleftcars(true);
        addrightcars(true);
        addleftcars(true);
        addrightcars(true);
        addbackground(true);
        time.start();
        
    }
     public  void addleftcars(boolean first){
        int positionx = rand.nextInt()%2;
        int p = rand.nextInt()%2;
        int x = 0;
        int y = 0;
        int z;
        if(positionx == 0){
            x = WIDTH/2+36;
        }else{
            x = WIDTH/2+136;
        }
        if(first){
            leftcars.add(new Rectangle(x, y-100-(leftcars.size()*space), width, height));
        }else{
            leftcars.add(new Rectangle(x, leftcars.get(leftcars.size()-1).y-space, width, height));
        }
    }
    
    public void addrightcars(boolean is){
        int p = rand.nextInt()%2;
        int z = 0;
        int y = 0;
        if(p == 0){
            z = WIDTH/2-185;
        }else{
            z = WIDTH/2-85;
        }
        if(is){
            rightcars.add(new Rectangle(z, y-100-(rightcars.size()*space)-100, width, height));
        }else{
            rightcars.add(new Rectangle(z, rightcars.get(rightcars.size()-1).y-space, width, height));
        }
    }
    public void addbackground(boolean first){
        int y = 0;
        if(first){
            backgroundimages.add(new Rectangle(0, 0, widthline, heightline));
        }else{
            backgroundimages.add(new Rectangle(0, backgroundimages.get(backgroundimages.size()-1).y-600, widthline, heightline));
        }
    }
 
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D) g;
        if(null != State)switch (State) {
            case GAME:
                game = true;
                menu = true;
                g.clearRect(0, 0,WIDTH, HEIGHT);
                drawimages(g2d);
                break;
            case MENU:
                time.stop();
                speed=10;
                g.clearRect(0, 0, WIDTH, HEIGHT);
                Menu.paintComponent(g);
                break;
            case HELP:
                time.stop();
                Help.paintComponent(g);
                break;
            default:
                break;
        }
        if(game==false&&restart ==false && menu ==true){
            Font f=new Font("ariel",Font.BOLD,30);
            FontMetrics metrics = this.getFontMetrics(f);
            g.setColor(Color.red);
            g.setFont(f);
            if(score < HIGHscore){
            g2d.drawString("High Score" + ": "+HIGHscore, (tire.WIDTH - metrics.stringWidth("High Score"))/2, tire.WIDTH /2 + 50);
            }else{
                g2d.drawString("New High Score" + ": "+HIGHscore, (tire.WIDTH - metrics.stringWidth("High Score"))/2, tire.WIDTH /2 + 50);
            }
            Gameover.paintComponent(g);
        }
        
} 
    public void drawimages(Graphics2D g2d){
        for(Rectangle re:backgroundimages){
            g2d.drawImage(backGroundimage,re.x,re.y,this);
        }
        
        g2d.drawImage(playercar1,car1.x,car1.y,this);
        
        g2d.drawImage(playercar2, car2.x, car2.y, this);
        for(Rectangle rect:leftcars){
            g2d.drawImage(oponentcarleft,rect.x,rect.y,this);
        }
        for(Rectangle rect:rightcars){
            g2d.drawImage(oponentcarright,rect.x,rect.y,this);
        }
        font = new Font("ariel",Font.BOLD,25);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Score: " + score, 10, 20);
        for(Rectangle rec:rightcars){
            if(rec.intersects(car1)){
                  g2d.drawImage(explosion,car1.x,car1.y,this);
                  time.stop();
                  game = false;
                  restart = false;   
               
try{
                           if(score > HIGHscore){
                            write = new FileWriter("C:\\\\Users\\\\hp\\\\Desktop\\\\Scoreofplayer1.txt",true);
                            write.write(String.valueOf(score));
                            write.append('\n');
                            HIGHscore = score;
                            write.close();
                        }
                    } catch(IOException ex){}
            }
        }
        for(Rectangle re:leftcars){
            if(re.intersects(car2)){ 
                  g2d.drawImage(explosion,car2.x,car2.y,this);
                  time.stop();
                  game= false;
                  restart = false;
                  try{
      
                        if(score >HIGHscore){
                            write = new FileWriter("C:\\\\Users\\\\hp\\\\Desktop\\\\Scoreofplayer2.txt",true);
                            write.write(String.valueOf(score));
                            write.append('\n');
                            HIGHscore = score;
                            write.close();
                        }
                    } catch(IOException ex){}
            }
        }
    }
   
    
    public void drawitalicimage(Graphics2D g2d){
        g2d.drawImage(playercar13,car3.x,car3.y,this);
        
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Rectangle rect;
        count++;
                System.out.println(count);
                System.out.println(speed);
        if(count%10==0){
           
            score++;
        }if(count%1000==0){
            speed+=0.5;
        }
        for(int i=0 ; i<leftcars.size(); i++){
            rect = leftcars.get(i);
            rect.y+=speed;
        }
        for(int i=0 ; i<rightcars.size(); i++){
            rect = rightcars.get(i);
            rect.y+=speed;
        }
        
        for(int i=0 ; i<leftcars.size() ; i++){
            rect = leftcars.get(i);
            if(rect.y >HEIGHT){
                leftcars.remove(rect);
                addleftcars(false); 
            }
        }
        for(int i=0 ; i<rightcars.size() ; i++){
            rect = rightcars.get(i);
            if(rect.y >HEIGHT){
                rightcars.remove(rect);
                addrightcars(false);
            }
        }
        for(int i=0 ; i<backgroundimages.size() ; i++){
            rect = backgroundimages.get(i);
            rect.y+=speed1;
            if(rect.y>700){
                backgroundimages.remove(rect);
            }if(rect.y>0){
                addbackground(false);
            }
        }
        for(Rectangle rec:rightcars){
            if(rec.intersects(car1)){repaint();}} 
        repaint();
    }
    public void moveleftcar1(){
        if(car1.x - move<WIDTH/2-188){
            System.out.println("\b");
        }else{
            car1.x -= move; 
        }   
    }
    public void moverightcar1(){
        if(car1.x + move > WIDTH/2-36){
            System.out.println("\b");
        }else{
            car1.x += move; 
        }
    }
    public void moveleftcar2(){
        if(car2.x - move<WIDTH/2+36){
            System.out.println("\b");
        }else{
            car2.x -=move;
        }
    }
    public void moverightcar2(){
        if(car2.x + move > WIDTH/2+172){
            System.out.println("\b");
        }else{
            car2.x +=move;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(State == STATE.GAME){
        switch(key){
            case KeyEvent.VK_Q:
                moveleftcar1();
                break;
            case KeyEvent.VK_E:
                moverightcar1();
                break;
            case KeyEvent.VK_LEFT:
                moveleftcar2();
                break;
            case KeyEvent.VK_RIGHT:
                moverightcar2();
                break;
            case KeyEvent.VK_SPACE:
                
                time.start();
                if(game == false && restart == false){
                speed=10;
                count = 0;
                score=0;
                game = true;
                restart = true;
                int positionx = rand.nextInt()%2;
                int x = 0;
                if(positionx == 0){
                    x = WIDTH/2+36;
                }else{
                    x = WIDTH/2+136;
                }
                int pp = rand.nextInt()%2;
                int zz = 0;
                if(pp == 0){
                    zz = WIDTH/2-185;
                }else{
                    zz = WIDTH/2-85;
                }
                 for(Rectangle rect:rightcars){
                    rect.setLocation(zz, -92);   
                }
                for(Rectangle rect:leftcars){
                    rect.setLocation(x, -92);
                }
                addrightcars(false);
                addrightcars(false);
                addrightcars(false);
                addleftcars(false);
                addleftcars(false);
                addleftcars(false);
                
                }
                
                break;
            case KeyEvent.VK_ENTER:
                time.start();
//                Score.setText("Score: 0");
                if(game == false&&restart == false){
                    menu = false;
                }
                if(game == false && restart == false && menu==false){
                    speed=6;
                    count = 0;
                    score=0;
                    time.start();
                int positionx = rand.nextInt()%2;
                int x = 0;
                if(positionx == 0){
                    x = WIDTH/2+36;
                }else{
                    x = WIDTH/2+136;
                }
                int pp = rand.nextInt()%2;
                int zz = 0;
                if(pp == 0){
                    zz = WIDTH/2-185;
                }else{
                    zz = WIDTH/2-85;
                }
                 for(Rectangle rect:rightcars){
                    rect.setLocation(zz, -92);   
                }
                for(Rectangle rect:leftcars){
                    rect.setLocation(x, -92);
                }
                
                addrightcars(false);
                addrightcars(false);
                addrightcars(false);
                addleftcars(false);
                addleftcars(false);
                addleftcars(false);
                
                    State = STATE.MENU;}
        }
    }}
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(State == STATE.GAME){
        switch(key){
            case KeyEvent.VK_Q:
                moveleftcar1();
                break;
            case KeyEvent.VK_E:
                moverightcar1();
         
                break;
            case KeyEvent.VK_LEFT:
                moveleftcar2();
                break;
            case KeyEvent.VK_RIGHT:
                moverightcar2();
                break;
        }}
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if(State == STATE.GAME){
        switch(key){
            case KeyEvent.VK_Q:
                moveleftcar1();
                break;
            case KeyEvent.VK_E:
                moverightcar1();
                break;
            case KeyEvent.VK_LEFT:
                moveleftcar2();
                break;
            case KeyEvent.VK_RIGHT:
                moverightcar2();
                break;
        }
    }}
}
