package projetnfa_035;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class QCMFrame extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JRadioButton r1, r2, r3,r4;
    JTextField f1, f2, f3, f4;
    String jl1Selected;
    JButton b1, b2, b3;
    ArrayList<Domaine> lesDomaines;
    JScrollPane sp1, sp2;
    ButtonGroup buttonGroup;
    String button;
    JList jl1, jl2;
    DefaultListModel<String> listeModel, listeModel1;

    public DefaultListModel<String> getDomaine(ArrayList<Domaine> a) {
        DefaultListModel<String> resultat = new DefaultListModel<String>();
        for (int i = 0; i < a.size(); i++) {
            resultat.addElement(a.get(i).name);
        }
        return resultat;

    }

    public DefaultListModel<String> getQCM(Domaine a) {

        DefaultListModel<String> resultat = new DefaultListModel<>();
        for (int i = 0; i < a.questions.size(); i++) {
            resultat.addElement(a.questions.get(i).question);
        }
        return resultat;
    }

    public QCMFrame() {
        try {
            FileInputStream in = new FileInputStream("DataDomaine");
            ObjectInputStream ois = new ObjectInputStream(in);
            lesDomaines = (ArrayList<Domaine>) ois.readObject();

        } catch (Exception e) {
            lesDomaines = new ArrayList<Domaine>();
        }

        button = "";
        setResizable(false);
        p1 = new JPanel(new BorderLayout());
        p1.setPreferredSize(new Dimension(700, 500));
        p1.setBorder(BorderFactory.createLineBorder(Color.cyan));
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(700, 50));
        p1.add(p2, BorderLayout.NORTH);
        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(700, 50));
        p1.add(p3, BorderLayout.SOUTH);
        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(150, 600));
        p1.add(p4, BorderLayout.WEST);
        p5 = new JPanel();
        p1.add(p5, BorderLayout.CENTER);

        l1 = new JLabel("Gestion des QCM");
        l1.setFont(new Font("Serif", Font.PLAIN, 35));
        l1.setForeground(Color.BLUE);
        p2.add(l1);
        b1 = new JButton("Ajouter une QCM");
        b1.addActionListener(this);
        b2 = new JButton("Supprimer une QCM");
        b2.addActionListener(this);
        b3 = new JButton("Modifier une QCM");
        b3.addActionListener(this);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        l2 = new JLabel("Les questions (QCM)");
        p5.add(l2);
       // listeModel1 = getQCM(lesDomaines.get(0));
        jl2 = new JList();
        sp2 = new JScrollPane(jl2);
          jl2.addListSelectionListener(new JListListener());
        sp2.setPreferredSize(new Dimension(450, 250));
        jl2.setBorder(BorderFactory.createLineBorder(Color.black));
        p5.add(sp2);
        f1 = new JTextField(48);
        f1.setBorder(BorderFactory.createLineBorder(Color.white));
       
        f2 = new JTextField(48);
        f2.setBorder(BorderFactory.createLineBorder(Color.black));
        
        f3 = new JTextField(48);
        f3.setBorder(BorderFactory.createLineBorder(Color.black));
        
        f4 = new JTextField(48);
        f4.setBorder(BorderFactory.createLineBorder(Color.black));
        
        p5.add(f1);
        p5.add(f2);
        p5.add(f3);
        p5.add(f4);

        listeModel = getDomaine(lesDomaines);
        jl1 = new JList(listeModel);
        jl1.addListSelectionListener(new JListListener());

        sp1 = new JScrollPane(jl1);
        sp1.setPreferredSize(new Dimension(130, 250));
        l3 = new JLabel("Les domaines");

        p4.add(l3);
        p4.add(sp1);
        l4 = new JLabel("Question (QCM)");
        l4.setPreferredSize(new Dimension(130, 18));
        p4.add(l4);
        r1 = new JRadioButton();
        p4.add(r1);
        l5 = new JLabel("Reponse1");
        l5.setPreferredSize(new Dimension(100, 18));
        p4.add(l5);
        r2 = new JRadioButton();
        p4.add(r2);
        l6 = new JLabel("Reponse2");
        l6.setPreferredSize(new Dimension(100, 18));
        p4.add(l6);
        r3 = new JRadioButton();
        p4.add(r3);
        r4=new JRadioButton();
        l7 = new JLabel("Reponse3");
        l7.setPreferredSize(new Dimension(100, 18));
        p4.add(l7);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);
        jl1Selected = "" + jl1.getSelectedValue();

       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(p1);
        pack();
        show();

    }

    public void actionPerformed(ActionEvent event) {
        Object ob = event.getActionCommand();
   boolean bool= (f1.getText().equals("")||f2.getText().equals("")||f3.getText().equals("")||f4.getText().equals(""))||(!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected());
   if (ob=="Ajouter une QCM"){
       if(jl1.getSelectedIndex()>=0){
           if(bool){
           JOptionPane.showMessageDialog(null,"plz fill all required fields","Message",JOptionPane.OK_OPTION);
           }else{
                int a=-1;
           if(r1.isSelected())a=0;
           else if(r2.isSelected())a=1;
           else if(r3.isSelected())a=2;
           lesDomaines.get(jl1.getSelectedIndex()).questions.add( 
                   new QCM(f1.getText(),f2.getText(),f3.getText(),f4.getText(),a));
           
                 try {
                    FileOutputStream out = new FileOutputStream("DataDomaine");
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(lesDomaines);
                    oos.flush();
                } catch (Exception e) {System.out.println(e);
                }
             
            JOptionPane.showMessageDialog(null,"QCM ajoutée");
            jl2.setModel(getQCM(lesDomaines.get(jl1.getSelectedIndex())));
            jl2.updateUI();
         r4.setSelected(true);
           f1.setText("");
            f2.setText("");
             f3.setText("");
              f4.setText("");
           
           }    
       }else {
               JOptionPane.showMessageDialog(null,"plz select a domaine","Message",JOptionPane.OK_OPTION);
       }
       
   }  
   if(ob=="Supprimer une QCM"){
       if(jl2.getSelectedIndex()>=0){
             lesDomaines.get(jl1.getSelectedIndex()).questions.remove(jl2.getSelectedIndex());
              try {
                    FileOutputStream out = new FileOutputStream("DataDomaine");
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(lesDomaines);
                    oos.flush();
                } catch (Exception e) {System.out.println(e);
                }
             
            JOptionPane.showMessageDialog(null,"QCM Supprimé");
            jl2.setModel(getQCM(lesDomaines.get(jl1.getSelectedIndex())));
            jl2.updateUI();
            r4.setSelected(true);
           f1.setText("");
            f2.setText("");
             f3.setText("");
              f4.setText("");
           
           
       }
       else {
          JOptionPane.showMessageDialog(null,"plz select a QCM","Message",JOptionPane.OK_OPTION);  
       }
       
       
   }
   
   if(ob=="Modifier une QCM"){
        if(bool){
           JOptionPane.showMessageDialog(null,"plz fill all required fields","Message",JOptionPane.OK_OPTION);
           }else{
            
              if(jl2.getSelectedIndex()>=0){
             lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex()).question=f1.getText();
             lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex()).reponses[0]=f2.getText();
             lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex()).reponses[1]=f3.getText();
             lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex()).reponses[2]=f4.getText();
            int a =-1;
            if(r1.isSelected())a=0;
            else if(r2.isSelected())a=1;
            else if(r2.isSelected())a=2;
             lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex()).correctAnswer=a;
              try {
                    FileOutputStream out = new FileOutputStream("DataDomaine");
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(lesDomaines);
                    oos.flush();
                } catch (Exception e) {System.out.println(e);
                }
             
            JOptionPane.showMessageDialog(null,"QCM Modifié");
            jl2.setModel(getQCM(lesDomaines.get(jl1.getSelectedIndex())));
            jl2.updateUI();
           r4.setSelected(true);
           f1.setText("");
            f2.setText("");
             f3.setText("");
              f4.setText("");
           
       }
       else {
          JOptionPane.showMessageDialog(null,"plz select a QCM","Message",JOptionPane.OK_OPTION);  
       }
       
            
        }
       
       
       
   }
   
   
   
    }

    public int getDomaineIndex(String a) {
        int resultat = -1;
        for (int i = 0; i < lesDomaines.size(); i++) {
            if (lesDomaines.get(i).name.equals(a)) {
                resultat = i;
            }
        }
        return resultat;
    }

    public QCM getQCMinfo(String domaine, String qcm) {

        Domaine ledomaine = new Domaine("1");
        QCM leqcm = new QCM("", "", "", "", 1);
        for (int i = 0; i < lesDomaines.size(); i++) {
            if (lesDomaines.get(i).name.equals(domaine)) {
                ledomaine = lesDomaines.get(i);
                break;
            }
        }
        for (int i = 0; i < ledomaine.questions.size(); i++) {

            if (ledomaine.questions.get(i).question.equals(qcm)) {
                leqcm = ledomaine.questions.get(i);
                break;
            }

        }

        return leqcm;
    }

    
    
    private class JListListener implements ListSelectionListener {
 int bre =-1;
        public void valueChanged(ListSelectionEvent a) {
           
if(jl1.getSelectedIndex()>=0&&jl1.getSelectedIndex()!=bre){
                String dom = "" + jl1.getSelectedValue();

                jl2.setModel(getQCM(getDomaineByString(dom)));
                jl2.updateUI();
                bre= jl1.getSelectedIndex();        
}
           if(jl2.getSelectedIndex()>=0){
               
                   QCM leQCM= lesDomaines.get(jl1.getSelectedIndex()).questions.get(jl2.getSelectedIndex());
                   f1.setText(leQCM.question);
                   f2.setText(leQCM.reponses[0]);
                    f3.setText(leQCM.reponses[1]);
                     f4.setText(leQCM.reponses[2]);
               if(leQCM.correctAnswer==0)r1.setSelected(true);
               else if(leQCM.correctAnswer==1)r2.setSelected(true);
               else if (leQCM.correctAnswer==2) r3.setSelected(true);
               
               
               
           }
        }

    }

    public Domaine getDomaineByString(String a) {
        Domaine b = new Domaine(a);

        for (int i = 0; i < lesDomaines.size(); i++) {
            if (lesDomaines.get(i).name.equals(a)) {
                b = lesDomaines.get(i);
                break;
            }
        }
        return b;
    }

}
