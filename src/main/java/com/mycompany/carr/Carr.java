/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.carr;

import java.io.IOException;
import javax.swing.JFrame;

public class Carr extends JFrame{ 
    static tire tire;
    public Carr(){ 
    }
    public static void main(String[] args) throws IOException {
      
try{
            tire = new tire();
            Carr carobj = new Carr();
            carobj.add(tire);
            carobj.setVisible(true);
            carobj.setSize(508,770);
            carobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            carobj.setResizable(false);
        }catch(IOException e){System.out.println(e);System.out.println("Exiting");}
    }
}
    
    

