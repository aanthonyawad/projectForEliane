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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ResultatFrame extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    JLabel l1;
    JScrollPane sp1, sp2;
    DefaultListModel<String> model;
    JList jl1;
    JButton b1, b2, b3;
    JTable t1;
    ArrayList<Domaine> lesDomaines;
    ArrayList<Etudiant> lesEtudiants;
    JTable table;
    String tab[] = {"nom", "Prenom", "note", "Date"};
    DefaultTableModel tabmodel;

    public DefaultListModel<String> getDomaine(ArrayList<Domaine> a) {
        DefaultListModel<String> resultat = new DefaultListModel<>();
        for (int i = 0; i < a.size(); i++) {
            resultat.addElement(a.get(i).name);
        }
        return resultat;
    }

    public ArrayList<Etudiant> etudDidTest(ArrayList<Etudiant> a, String dom) {
        ArrayList<Etudiant> etud = new ArrayList<Etudiant>();
        ArrayList<Resultat> res = new ArrayList<Resultat>();
        for (int i = 0; i < a.size(); i++) {
            res = a.get(i).lesResultats;
            for (int j = 0; j < res.size(); j++) {

                if (res.get(j).dom.name.equals(dom)) {
                    etud.add(a.get(i));
                    break;
                }
            }

        }
        return etud;
    }

    public int getResIndexParDom(ArrayList<Resultat> a, String dom) {
        int res = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).dom.name.equals(dom)) {
                res = i;
                break;
            }
        }

        return res;
    }

    public ArrayList<Etudiant> trieParNote(ArrayList<Etudiant> a, String dom) {
        ArrayList<Etudiant> rez = new ArrayList<Etudiant>();
        for (int i = 0; i < a.size(); i++) {
            //// tto do later 
        }

        return rez;
    }

    public DefaultTableModel getInfo(ArrayList<Etudiant> a, String dom) {

        DefaultTableModel tabmodel = new DefaultTableModel();

        tabmodel.addColumn("nom");

        tabmodel.addColumn("prennom");

        tabmodel.addColumn("note");

        tabmodel.addColumn("Date essaie");

        String b[] = new String[4];

        for (int i = 0; i < a.size(); i++) {

            b[0] = a.get(i).nom;

            b[1] = a.get(i).prenom;

            b[2] = "" + a.get(i).lesResultats.get(getResIndexParDom(a.get(i).lesResultats, dom)).note;

            b[3] = a.get(i).lesResultats.get(getResIndexParDom(a.get(i).lesResultats, dom)).dateEssaie.toString();

            tabmodel.addRow(b);

        }

        return tabmodel;

    }

    public String printRez(ArrayList<Etudiant> etud) {
        String rez = "";
        for (int i = 0; i < etud.size(); i++) {
            rez += etud.get(i).lesResultats + " \n";
        }
        return rez;
    }

    public ResultatFrame() {
        try {
            FileInputStream in = new FileInputStream("DataDomaine");
            ObjectInputStream ois = new ObjectInputStream(in);
            lesDomaines = (ArrayList<Domaine>) ois.readObject();

        } catch (Exception e) {
            lesDomaines = new ArrayList<Domaine>();

        }

        try {
            System.out.println("a");
            FileInputStream in = new FileInputStream("DataEtudiant");
            System.out.println("a");

            ObjectInputStream ois = new ObjectInputStream(in);
            System.out.println("a");
            lesEtudiants = (ArrayList<Etudiant>) ois.readObject();

            System.out.println("a");

        } catch (Exception e) {
            System.out.println(e);
            lesEtudiants = new ArrayList<Etudiant>();

        }

        System.out.println(printRez(lesEtudiants));
        setResizable(false);
        p1 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createLineBorder(Color.cyan, 10));
        p1.setPreferredSize(new Dimension(700, 600));
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(700, 80));
        p1.add(p2, BorderLayout.NORTH);
        l1 = new JLabel("Résultats des étudiants");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.PLAIN, 35));
        p2.add(l1);
        b1 = new JButton("Note par domaine/orde alpha.");
        b2 = new JButton("Note par domaine/ordre de notes");
        b3 = new JButton("Note Moyenne/ordre alpha.");
        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(700, 50));
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p1.add(p3, BorderLayout.SOUTH);
        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(200, 450));
        model = getDomaine(lesDomaines);
        jl1 = new JList(model);
        sp1 = new JScrollPane(jl1);
        sp1.setPreferredSize(new Dimension(150, 150));
        p4.add(sp1);
        p1.add(p4, BorderLayout.WEST);

        tabmodel = getInfo(etudDidTest(lesEtudiants, "qwew"), "qwew");

        table = new JTable(tabmodel);

        sp2 = new JScrollPane(table);
        sp2.setBorder(BorderFactory.createLineBorder(Color.black));
        sp2.setPreferredSize(new Dimension(480, 450));
        p1.add(sp2, BorderLayout.EAST);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

     //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(p1);
        setLocationRelativeTo(null);
        pack();
        show();
    }

    public void actionPerformed(ActionEvent event) {
        Object ob = event.getActionCommand();
        if (ob == "Note par domaine/orde alpha.") {
            if(jl1.getSelectedValue()==null){  
                 JOptionPane.showMessageDialog(null,"Selectionnez un domaine","Message",JOptionPane.OK_OPTION);
            } else {
            table.setModel(getInfo(sortByName(etudDidTest(lesEtudiants, "" + jl1.getSelectedValue())), "" + jl1.getSelectedValue()));
            table.updateUI();}
        }
        if (ob == "Note par domaine/ordre de notes") {
 if(jl1.getSelectedValue()==null){  
                 JOptionPane.showMessageDialog(null,"Selectionnez un domaine","Message",JOptionPane.OK_OPTION);
            } else {
            table.setModel(getInfo(sortByNote(etudDidTest(lesEtudiants, "" + jl1.getSelectedValue()), "" + jl1.getSelectedValue()), "" + jl1.getSelectedValue()));
            table.updateUI();
 }
        }
        if(ob=="Note Moyenne/ordre alpha."){
            DefaultTableModel themod= new DefaultTableModel();
            
          
          themod.addColumn("Nom");
          themod.addColumn("Prenom");
          themod.addColumn("Moyenne");
          
          
          String b []= new String[3];
           for (int i = 0; i < lesEtudiants.size(); i++) {

            b[0] = lesEtudiants.get(i).nom;

            b[1] = lesEtudiants.get(i).prenom;

            b[2] = "" + lesEtudiants.get(i).getMoyenne();
themod.addRow(b);
          
        }
table.setModel(themod);
table.updateUI();
    }
    }
    public ArrayList<Etudiant> sortByName(ArrayList<Etudiant> etud) {
        System.out.println(etud);
        ArrayList<String> arrayS = new ArrayList<String>();
        ArrayList<Etudiant> rez = new ArrayList<Etudiant>();
        for (int i = 0; i < etud.size(); i++) {
            arrayS.add(etud.get(i).nom);
        }
        Collections.sort(arrayS);
        for (int i = 0; i < arrayS.size(); i++) {
            for (int j = 0; j < etud.size(); j++) {
                if (etud.get(j).nom.equalsIgnoreCase(arrayS.get(i))) {
                    rez.add(etud.get(j));
                    break;
                }
            }
        }

        System.out.print(arrayS);
        System.out.println(rez);
        return rez;
    }

    public ArrayList<Etudiant> sortByNote(ArrayList<Etudiant> etud, String dom) {
        ArrayList<Etudiant> rez = new ArrayList<Etudiant>();

        for (int i = 0; i < etud.size(); i++) {
            rez.add(etud.get(i));
        }
        Collections.sort(
                rez,
                (player1, player2) -> player1.getNoteByDomaine(dom)
                - player2.getNoteByDomaine(dom));

    

    return rez ;
}

}
