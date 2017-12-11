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
public class DomaineFrame extends JFrame implements ActionListener {
    JPanel p1,p2,p3,p4,p5,p6;
    JLabel l1,l2,l3;
    JTextField f1;
    JButton b1;
    JList jl1,jl2;
    JScrollPane sp1;
    DefaultListModel<String> listeModel;
    ArrayList<Domaine> lesDomaines;

    public DefaultListModel<String> getDomaine(ArrayList<Domaine> a){
        DefaultListModel<String> resultat= new DefaultListModel<>();
      for(int i=0;i<a.size();i++){
           resultat.addElement(a.get(i).name);
     }
    return resultat;
        
    }
    public DomaineFrame(){
      
          try{
           FileInputStream in= new FileInputStream("DataDomaine");
           ObjectInputStream ois= new ObjectInputStream(in);
           lesDomaines=(ArrayList<Domaine>)ois.readObject();
           
           
           }catch(Exception e){lesDomaines= new ArrayList<Domaine>();
       
           }
        
        
        
        
        
        
        
        
        setResizable(false);
         setLocationRelativeTo(null);
    
        
        p1=new JPanel();p1.setPreferredSize(new Dimension(500,300));p1.setBorder(BorderFactory.createLineBorder(Color.cyan));
        p2=new JPanel();p2.setPreferredSize(new Dimension(500,50));
        p3=new JPanel();p3.setPreferredSize(new Dimension(500,50));
        p4=new JPanel();
        p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setLayout(new BorderLayout());
        p1.add(p3,BorderLayout.SOUTH);
        p1.add(p2,BorderLayout.NORTH);
        p1.add(p4,BorderLayout.CENTER);
        l1= new JLabel("Création d'un domaine");l1.setFont(new Font("Serif", Font.PLAIN, 30)); l1.setForeground(Color.BLUE);
        p2.add(l1);
        b1= new JButton("Ajouter un domaine");b1.addActionListener(this);
        p3.add(b1);
        p4.setLayout(new BorderLayout());
        p4.add(p5,BorderLayout.NORTH);
        l2=new JLabel("Les domaines");l2.setFont(new Font("Serif", Font.PLAIN, 15));
        p5.add(l2);
        p4.add(p6,BorderLayout.CENTER);
        listeModel=getDomaine(lesDomaines);
        
        jl1=new JList(listeModel);
        
        sp1=new JScrollPane(jl1);sp1.setPreferredSize(new Dimension(100,200));
        l3= new JLabel("Nom du domaine");
        f1=new JTextField(20);
        p6.add(sp1);p6.add(l3);p6.add(f1);
        
        
        // setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
         setLocationRelativeTo(null);
        getContentPane().add (p1);
        pack();
        show();
        
        
        
        
        
        
    }
    
     public void actionPerformed(ActionEvent event) {
            Object ob = event.getActionCommand();
     if(ob=="Ajouter un domaine"){
         if(domaineExiste(lesDomaines,f1.getText())){
            
             
             //alert 
             JOptionPane.showMessageDialog(null,"Erreur Domaine existe","Message",JOptionPane.OK_OPTION);
             f1.setText("");
             
             
         }else {
             Domaine a= new Domaine(f1.getText());
             lesDomaines.add(a);
             
              try {
                    FileOutputStream out = new FileOutputStream("DataDomaine");
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(lesDomaines);
                    oos.flush();
                } catch (Exception e) {System.out.println(e);
                }
             
             
             JOptionPane.showMessageDialog(null,"Domaine ajoutée");
             f1.setText("");
jl1.setModel(getDomaine(lesDomaines));
jl1.updateUI();
             
             
         }
         
         
         
     }
     
     
     }
    
     public boolean domaineExiste(ArrayList<Domaine> a,String b){
         boolean resultat = false;
         for(int i=0;i<a.size();i++){
             if(a.get(i).name.equalsIgnoreCase(b)){resultat = true; break;}
         }
        return resultat; 
     }
}
