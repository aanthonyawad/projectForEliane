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
public class UtilisateurFrame extends JFrame implements ActionListener{
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField userField,passField, questionField,r1Field,r2Field,r3Field;
JRadioButton r1,r2,r3,r4;
ButtonGroup group;
JButton b1,b2,b3,b4;
JList laListe;
  DefaultListModel<String> listeModel;
JScrollPane Scroll;
ArrayList<Etudiant> lesEtudiants;
ArrayList<Domaine> lesDomaines;
ArrayList<QCM> tabQCM;
int index;
Etudiant quiFaitTest;
int note;
String theuser,thepass;
 public DefaultListModel<String> getDomaine(ArrayList<Domaine> a){
        DefaultListModel<String> resultat= new DefaultListModel<>();
      for(int i=0;i<a.size();i++){
           resultat.addElement(a.get(i).name);
     }
    return resultat;
        
    }



    public UtilisateurFrame(){
        index=0;
        note=0;
           try{
           FileInputStream in= new FileInputStream("DataDomaine");
           ObjectInputStream ois= new ObjectInputStream(in);
           lesDomaines=(ArrayList<Domaine>)ois.readObject();
           
           
           }catch(Exception e){lesDomaines= new ArrayList<Domaine>();
       
           }        
        
        
        try{
           System.out.println("a");
            FileInputStream in= new FileInputStream("DataEtudiant");
           System.out.println("a");
           
           ObjectInputStream ois= new ObjectInputStream(in);
            System.out.println("a");
           lesEtudiants=(ArrayList<Etudiant>)ois.readObject();
           
            System.out.println("a");
          
        }catch(Exception e){System.out.println("new array");
            System.out.println(e);
            lesEtudiants= new ArrayList<Etudiant>();
       
           }
        
        
        setResizable(false);
         setLocationRelativeTo(null);
        p1=new JPanel(new BorderLayout());p1.setPreferredSize(new Dimension(700,600));
        p2=new JPanel();p2.setBackground(Color.cyan);p2.setPreferredSize(new Dimension(700,10));
        p3= new JPanel();p3.setBackground(Color.cyan);p3.setPreferredSize(new Dimension(700,20));
        p4=new JPanel();p4.setBackground(Color.cyan);p4.setPreferredSize(new Dimension(25,600));
        p5= new JPanel();p5.setBackground(Color.cyan);p5.setPreferredSize(new Dimension(25,600));
        p1.add(p2,BorderLayout.NORTH);
        p1.add(p3,BorderLayout.SOUTH);
        p1.add(p4,BorderLayout.EAST);
        p1.add(p5,BorderLayout.WEST);
        p6=new JPanel(new BorderLayout());
        p1.add(p6,BorderLayout.CENTER);
         //taba3 fo2
        LayoutManager layout=new FlowLayout();
        
        p7=new JPanel(); p7.setPreferredSize(new Dimension(650,570));
      
        p6.add(p7,BorderLayout.NORTH);
        p8=new JPanel();p8.setBorder(BorderFactory.createLineBorder(Color.black));p8.setPreferredSize(new Dimension(650,50));
          ((FlowLayout)p8.getLayout()).setHgap(210);
         // ((FlowLayout)p8.getLayout()).setAlignment(FlowLayout.LEFT);
        p7.add(p8,BorderLayout.NORTH);
        l1=new JLabel("Utilisateur");l1.setFont(new Font("Serif", Font.PLAIN, 20)); l1.setForeground(Color.RED);
        p8.add(l1);
        l2=new JLabel("Java Quiz");l2.setFont(new Font("Serif", Font.PLAIN, 20)); l2.setForeground(Color.BLUE);
        p8.add(l2);
        p9=new JPanel(new BorderLayout());
        p7.add(p9,BorderLayout.CENTER);
        p10=new JPanel();p10.setBorder(BorderFactory.createLineBorder(Color.black));p10.setPreferredSize(new Dimension(650,100));
        ((FlowLayout)p10.getLayout()).setHgap(200);
        p9.add(p10,BorderLayout.NORTH);
        p10.setLayout(new GridLayout(3,0));
        p11=new JPanel();
        p10.add(p11);
        l3=new JLabel("Ener username and password to login");
        p11.add(l3);
        p12=new JPanel(new GridLayout(0,2));
        p10.add(p12);
        p13=new JPanel();
        p12.add(p13);
        l4=new JLabel("Username"); 
        userField=new JTextField(10);
        p13.add(l4); p13.add(userField);
        p14=new JPanel();
        l5=new JLabel("Password");
        passField = new JPasswordField(10);
        p14.add(l5);p14.add(passField);
        p12.add(p14);
        p15=new JPanel();p15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p10.add(p15);
        b1=new JButton("Valider");b1.addActionListener(this);
        p15.add(b1);
        p16=new JPanel(new BorderLayout());
        p9.add(p16,BorderLayout.CENTER);
        p17 = new JPanel(new GridLayout(0,2));p17.setPreferredSize(new Dimension(650,200));
        p17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p16.add(p17,BorderLayout.NORTH);
        l6=new JLabel("Choisir le domaine de quiz");l6.setFont(new Font("Serif", Font.PLAIN, 20)); l6.setForeground(Color.RED);
        b2=new JButton("Commencer");b2.addActionListener(this);
        p18=new JPanel(new GridLayout(2,0));
        p19=new JPanel();p18.add(p19);
        p20=new JPanel();p18.add(p20);
        p19.add(l6);
        p20.add(b2);
        p21=new JPanel();
        p17.add(p18);
        p17.add(p21);
         listeModel=getDomaine(lesDomaines);
        laListe= new JList(listeModel);
        
        Scroll= new JScrollPane(laListe);Scroll.setPreferredSize(new Dimension(150,150));
        p21.add(Scroll);
        p22=new JPanel();p22.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p22.setPreferredSize(new Dimension(650,210));
        p16.add(p22);
        p22.setLayout(new GridLayout(6,0));
        l7=new JLabel("Choisir la bonne reponse");l7.setFont(new Font("Serif", Font.PLAIN, 15)); l7.setForeground(Color.BLUE);
        p23=new JPanel();
        p22.add(p23);p23.add(l7);
        p24=new JPanel();
        p22.add(p24);
      l8=new JLabel("Question No.");l8.setFont(new Font("Serif", Font.PLAIN, 20)); l8.setForeground(Color.RED);
        questionField= new JTextField(40);questionField.setEditable(false);
        p24.add(l8);
        p24.add(questionField);
        p25=new JPanel();p22.add(p25);
        r1=new JRadioButton();
        l9=new JLabel("Reponse1");
        r1Field=new JTextField(40);r1Field.setEditable(false);
        p25.add(r1);p25.add(l9);p25.add(r1Field);
         p26=new JPanel();p22.add(p26);
        r2=new JRadioButton();
        l10=new JLabel("Reponse2");
        r2Field=new JTextField(40);r2Field.setEditable(false);
        p26.add(r2);p26.add(l10);p26.add(r2Field);
         p27=new JPanel();p22.add(p27);
        r3=new JRadioButton();
        l11=new JLabel("Reponse3");
        r3Field=new JTextField(40);r3Field.setEditable(false);
        p27.add(r3);p27.add(l11);p27.add(r3Field);
        p28=new JPanel();p22.add(p28);
        
        ((FlowLayout)p28.getLayout()).setHgap(50);
        
        b3=new JButton("Back");b3.addActionListener(this);
        b4=new JButton("Next");b4.addActionListener(this);
        p28.add(b3);p28.add(b4);
        
        group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        r4=new JRadioButton();
        group.add(r4);
        
         setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
         setLocationRelativeTo(null);
        getContentPane().add (p1);
        pack();
        show();
        p17.setVisible(false);
       p22.setVisible(false);
        
        
    }
    
    
    
    
    
    
      public void actionPerformed(ActionEvent event) {
           String user="";
          String pass="";
           Object ob = event.getActionCommand();
      if(ob=="Valider"){
           user=userField.getText();
           pass=passField.getText();
          if(userExists(lesEtudiants,user,pass)){
              quiFaitTest= getEtudiantByNum(user);
              JOptionPane.showMessageDialog(null,"Welcome");
              p17.setVisible(true);
              b1.setEnabled(false);
              userField.setText("");
              passField.setText("");
              laListe.setModel(listeModel);
              laListe.updateUI();
              
          }else {
          JOptionPane.showMessageDialog(null,"Erreur Authentification","Message",JOptionPane.OK_OPTION);
      userField.setText("");
      passField.setText("");
          }
      
      
      }
      if(ob=="Commencer"){
          try {
              if(lesDomaines.get(laListe.getSelectedIndex()).questions.size()<10) throw new Exception();
          p22.setVisible(true);
        String sDom=""+ laListe.getSelectedValue();
        Domaine leDom=getDomaineByString(sDom);
        tabQCM=leDom.makeQuiz();
        System.out.println(tabQCM);
             questionField.setText(tabQCM.get(0).question);
          r1Field.setText(tabQCM.get(0).reponses[0]);
        r2Field.setText(tabQCM.get(0).reponses[1]);
        r3Field.setText(tabQCM.get(0).reponses[2]);
          index++;
      }catch(Exception e){
            JOptionPane.showMessageDialog(null,"not enough questions in this domain sry stud..","Message",JOptionPane.OK_OPTION);
      }}
      if(ob=="Next"){
          boolean bool=(!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected());         
          
          if(bool){
              
                 JOptionPane.showMessageDialog(null,"Selectionnez une reponse","Message",JOptionPane.OK_OPTION);
           
          }
         else {
          
                       if(tabQCM.size()<=index){
                           System.out.println(index);
                 JOptionPane.showMessageDialog(null,"Quiz Terminé");
                    lesEtudiants.get(userExistsIndex(lesEtudiants, theuser, thepass)).ajouterResultat(new Resultat(getDomaineByString(""+laListe.getSelectedValue()),new Date(),note));
          System.out.println(note);
                    note=0;
                    p22.setVisible(false);
                    
                    
                     try {
                    FileOutputStream out = new FileOutputStream("DataEtudiant");
                    
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                
                    oos.writeObject(lesEtudiants);
                  
                    oos.flush();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
         
                    
          }else {
              System.out.println(index);
               questionField.setText(tabQCM.get(index).question);
          r1Field.setText(tabQCM.get(index).reponses[0]);
        r2Field.setText(tabQCM.get(index).reponses[1]);
        r3Field.setText(tabQCM.get(index).reponses[2]);
         
          if(reponseCorrecte(tabQCM.get(index-1).correctAnswer))note++;
          System.out.println(index);
           index++;
         System.out.println(index); 
        r4.setSelected(true);
                       }
                       
          
      }}
      if(ob=="Back"){
          
          if(index==0){
              System.out.println(index);
              JOptionPane.showMessageDialog(null,"C'est la premiere question");
          }else if(index>0){
              index--;
              System.out.println(index);
               questionField.setText(tabQCM.get(index).question);
          r1Field.setText(tabQCM.get(index).reponses[0]);
        r2Field.setText(tabQCM.get(index).reponses[1]);
        r3Field.setText(tabQCM.get(index).reponses[2]);
              r4.setSelected(true);
          }
          
          
          
          
          
      }
      
      }
      
      public boolean userExists(ArrayList<Etudiant> etud,String user,String pass){
          boolean a=false;
          theuser=user;
          thepass=pass;
          for(int i=0;i<etud.size();i++){
              
              if(etud.get(i).numDossier.equals(user)&&etud.get(i).password.equals(pass)){
                  a=true;break;
              }System.out.println("Didnt find");
          }
          
      return a;
      }
       public int userExistsIndex(ArrayList<Etudiant> etud,String user,String pass){
          int a=-9;
          for(int i=0;i<etud.size();i++){
              if(etud.get(i).numDossier.equals(user)&&etud.get(i).password.equals(pass)){
                  a=i;break;
              }
        } System.out.println("didnt Find"); 
          
      return a;
      }
      
      
   public Domaine getDomaineByString(String a){
        Domaine b = new Domaine(a);
        
        for(int i=0;i<lesDomaines.size();i++){
            if(lesDomaines.get(i).name.equals(a)){b=lesDomaines.get(i); break;}
        }
    return b;
}
   public Etudiant getEtudiantByNum(String num){
       Etudiant a=new Etudiant("","","","");
       
       for(int i=0;i<lesEtudiants.size();i++){
           if(lesEtudiants.get(i).numDossier.equals(num)){
               a=lesEtudiants.get(i);break;
           }
       }
   return a;
   }
   
  
   public boolean reponseCorrecte( int a){
       boolean reponse;
       int b=-1;
       if(r1.isSelected())b=0;
       else if(r2.isSelected())b=1;
       else if(r3.isSelected())b=2;
       if(b==a)reponse =true;
       else reponse=false;
       return reponse;
       
   }
   
   
   
}
