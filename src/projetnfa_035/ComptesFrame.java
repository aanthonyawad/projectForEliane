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
public class ComptesFrame extends JFrame implements ActionListener{
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1;
    JTextField f1,f2,f3,f4;
    ArrayList<Etudiant> lesEtudiants ;
    public ComptesFrame(){ 
        try{
           System.out.println("a");
            FileInputStream in= new FileInputStream("DataEtudiant");
           System.out.println("a");
           
           ObjectInputStream ois= new ObjectInputStream(in);
            System.out.println("a");
           lesEtudiants=(ArrayList<Etudiant>)ois.readObject();
           
            System.out.println("a");
          
        }catch(Exception e){
            System.out.println(e);
            lesEtudiants= new ArrayList<Etudiant>();
       
           }
       
        
        
        
        
        
        
        setResizable(false);
         setLocationRelativeTo(null);
         
        JPanel p1= new JPanel(new BorderLayout());p1.setPreferredSize(new Dimension(500,350));
        p2=new JPanel ();p2.setPreferredSize(new Dimension(500,50));
        p1.add(p2,BorderLayout.NORTH);
        l1=new JLabel("Création d'un compte étudiant");l1.setFont(new Font("Serif", Font.PLAIN, 30)); l1.setForeground(Color.BLUE);
        p2.add(l1);
        p3= new JPanel(new BorderLayout());p3.setPreferredSize(new Dimension(500,250));
        p1.add(p3,BorderLayout.CENTER);
        p4= new JPanel();
        p3.add(p4,BorderLayout.WEST);p4.setPreferredSize(new Dimension(110,250));
        p4.setLayout(new GridLayout(6,0));
        JLabel l2=new JLabel("Numéro du dossier");
        JLabel l3=new JLabel("Prénom étudiant");
        JLabel l4=new JLabel("Nom étudiant");
        JLabel l5=new JLabel("Password");
        f1 = new JTextField(12);
        f2 = new JTextField(12);
        f3 = new JTextField(12);
        f4 = new JPasswordField(12);
        p4.add(l2);
        p4.add(l3);
        p4.add(l4);
        p4.add(l5);
        p5=new JPanel();p5.setLayout(new GridLayout(6,0));p5.setPreferredSize(new Dimension(150,250));
        p3.add(p5,BorderLayout.CENTER);
        p6=new JPanel();p6.add(f1);p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        p7=new JPanel();p7.add(f2);p7.setLayout(new FlowLayout(FlowLayout.LEFT));
        p8=new JPanel();p8.add(f3);p8.setLayout(new FlowLayout(FlowLayout.LEFT));
        p9=new JPanel();p9.add(f4);p9.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.add(p6);p5.add(p7);p5.add(p8);p5.add(p9);
        p10= new JPanel();p10.setPreferredSize(new Dimension(200,300));
        p3.add(p10,BorderLayout.EAST);
        ImageIcon image= new ImageIcon("C:\\Users\\ess\\Desktop\\javalogo.jpg");
        p10.setLayout(new GridLayout(2,0));
        l6=new JLabel(image);
        p10.add(l6);
        b1 = new JButton("Ajouter un compte");b1.addActionListener(this);
        p11=new JPanel();
        p1.add(p11,BorderLayout.SOUTH);
        p11.add(b1);
        
        
        
    //     setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        
        
        getContentPane().add (p1);
         setLocationRelativeTo(null);
        pack();
        show();
    }
    
    
    
    
    
  
    
    
    
    
    
    
    
    
     public void actionPerformed(ActionEvent event) {
            Object ob = event.getActionCommand();
     
     if(ob=="Ajouter un compte"){
         if(f1.getText().equals("")||f2.getText().equals("")||f3.getText().equals("")||f4.getText().equals("")){
             JOptionPane.showMessageDialog(null,"plz fill all required fields","Message",JOptionPane.OK_OPTION);
         }else {
         
         
         
         if(etudiantExiste(f1.getText())){
               JOptionPane.showMessageDialog(null,"Etudiant "+f1.getText()+ " existe","Message",JOptionPane.OK_OPTION);
         }else{System.out.println(lesEtudiants);
             lesEtudiants.add(new Etudiant(f3.getText(),f2.getText(),f1.getText(),f4.getText()));
              JOptionPane.showMessageDialog(null,"Etudiant "+ f1.getText()+ " ajouté");
              f1.setText("");
              f2.setText("");
              f3.setText("");
              f4.setText("");
              
             try {
                    FileOutputStream out = new FileOutputStream("DataEtudiant");
                    
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                  System.out.println("a");
                    oos.writeObject(lesEtudiants);
                    System.out.println("a");
                    oos.flush();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         
         
         }
         }   
         
     }
     
     
     
     
     
     }
     public boolean etudiantExiste(String a){
         boolean resultat = false;
         for(int i=0;i<lesEtudiants.size();i++){
             if(lesEtudiants.get(i).numDossier.equalsIgnoreCase(a)){resultat= true; break;}
         }
         
         
         return resultat;
     }
     
}
