/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfa_035;

/**
 *
 * @author ess
 */
import java.util.*;
import java.io.Serializable;
public class Resultat implements Serializable{
   Domaine dom;
   int note;
   Date dateEssaie;
   int refaire;
   
   
   public Resultat(Domaine dom,Date a,int note){
       this.dom=dom;
       dateEssaie=a;
       this.note=note;    
       
   }
     
   public void mettreNote(int a){note =a;}
   public void faireQuiz(){refaire ++;}
   public void updateDate(Date a){ dateEssaie=a;}
   public void updateNote(int a){
       if(note<a){note=a;}
       
   }
    public String dateToString(){
        return dateEssaie.toString();
        
    }
    
    
    
}
