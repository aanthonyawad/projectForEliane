/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfa_035;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MainFrame  extends JFrame implements ActionListener{
  JPanel p1,p2,p3,p4,p5,p6,p7;
  String profAcc; String profPass;
  JLabel l1,l2,l3,l4,l5;
  JButton b1,b2;
  JRadioButton r1,r2;
  JTextField f1,f2;
    ButtonGroup buttonGroup;
    
    public MainFrame(){
       
        
        setResizable(false);
  setTitle("NFA_035");
 p1 = new JPanel ();
 p1.setPreferredSize(new Dimension(300,300));
      p1.setLayout(new GridLayout(2,0));
      p2=new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
      p1.add(p2);
      b1 = new JButton("Professeur");b1.addActionListener(this);
      b2= new JButton("Etudiant");b2.addActionListener(this);
      p2.add(b1); p2.add(b2);
      p3 = new JPanel();
      p1.add(p3);
      l1= new JLabel("Welcome ");
      l1.setFont(new Font("Serif", Font.PLAIN, 50)); l1.setForeground(Color.BLUE);
      p3.add(l1);
      
      
      
         setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        getContentPane().add (p1);
        pack();
        show();
        
      
  }
    
    
    
    
    
    
    
    
    
    
    
    
        public void actionPerformed(ActionEvent event) {
            Object ob = event.getActionCommand();
         
        if(ob=="Professeur"){
            new AdminFrame();
            this.dispose();
        }
            if(ob=="Etudiant"){
                new UtilisateurFrame();
            this.dispose();
            }
        }
        
        
        }
 
