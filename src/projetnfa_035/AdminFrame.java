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
public class AdminFrame extends JFrame implements ActionListener {
    JPanel p1,p2,p3,p4,p6,p7,pl2,pb1,pb2,pb3,pb4;
    JButton b1,b2,b3,b4;
    JLabel l1,l2;
    public AdminFrame(){
        setResizable(false);
        
        p1=new JPanel();p1.setPreferredSize(new Dimension(600,600));
        p2=new JPanel();p2.setPreferredSize(new Dimension(600,80));
        p3=new JPanel();
        p4=new JPanel();p4.setPreferredSize(new Dimension(300,520));
        
        p6=new JPanel();
        p7= new JPanel();p7.setBackground(Color.CYAN);p7.setPreferredSize(new Dimension(50,520));
        p1.setLayout(new BorderLayout());
        p1.add(p2,BorderLayout.NORTH);
        p1.add(p3,BorderLayout.CENTER);
        JLabel l1= new JLabel("Quiz-Java");l1.setFont(new Font("Serif", Font.PLAIN, 40)); l1.setForeground(Color.BLUE);
        p2.add(l1);
        p3.setLayout(new GridLayout(0,2));
        p3.add(p4);p3.add(new ImagePanel("C:\\Users\\ess\\Desktop\\javalogo.jpg"));
        p4.setLayout(new BorderLayout());
        p4.add(p6,BorderLayout.CENTER);
        p4.add(p7,BorderLayout.EAST);
        l2= new JLabel("Administrateur");l2.setFont(new Font("Serif", Font.PLAIN, 35)); l2.setForeground(Color.red);
        b1 = new JButton("Création d'un domaine");b1.addActionListener(this);
        b2 = new JButton("Géstion des QCM");b2.addActionListener(this);
        b3 = new JButton("Création d'un compte étudiant");b3.addActionListener(this);
        b4 = new JButton("Affichage des résultats");b4.addActionListener(this);
        p6.setLayout(new GridLayout(8,0));
        pl2= new JPanel(new FlowLayout(FlowLayout.LEFT));pb2= new JPanel(new FlowLayout(FlowLayout.LEFT));pb1= new JPanel(new FlowLayout(FlowLayout.LEFT));
        pb3= new JPanel(new FlowLayout(FlowLayout.LEFT));pb4= new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        p6.add(pl2); p6.add(pb1); p6.add(pb2); p6.add(pb3); p6.add(pb4);
        pb2.add(b2);pl2.add(l2);pb1.add(b1);pb3.add(b3);pb4.add(b4);
        
  
        
        
        
        
        
        
        
        
         setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
         setLocationRelativeTo(null);
        getContentPane().add (p1);
        pack();
        show();
        
        
        
    }
      public void actionPerformed(ActionEvent event) {
            Object ob = event.getActionCommand();
      if(ob=="Création d'un domaine"){
      new DomaineFrame();
      
      
      }
      if(ob=="Géstion des QCM"){
          new QCMFrame();
          
      }
      if(ob=="Création d'un compte étudiant"){
          new ComptesFrame();
         
      }
      if(ob=="Affichage des résultats"){
          new ResultatFrame();
          
          
      }
      
      }
    
}
