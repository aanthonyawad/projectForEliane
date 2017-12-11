/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfa_035;
import java.util.*;
import java.io.Serializable;
public class Etudiant implements Serializable{
    String nom;
    String prenom;
    String numDossier;
    String password;
    ArrayList<Resultat> lesResultats;
    
    
    public Etudiant(String nom,String prenom,String numDossier,String password ){
        lesResultats = new ArrayList<Resultat>();
        this.nom=nom;
        this.prenom= prenom;
        this.numDossier=numDossier;
        this.password=password;
    }
    public void ajouterResultat(Resultat a){
     if(!resExiste(a)){
         lesResultats.add(a); 
         
     }
        
        
        else{    for(int i=0;i<lesResultats.size();i++){
            if(lesResultats.get(i).dom.name.equalsIgnoreCase(a.dom.name)){
                if(lesResultats.get(i).note<a.note){
                    lesResultats.remove(i);lesResultats.add(a);
                    
                }
            }
            
            
        }
    }
    }
    public double getMoyenne(){
        double b =0;
        for(int i=0;i<lesResultats.size();i++){
            b+=lesResultats.get(i).note;
        }
    return b/lesResultats.size();}
    
    public boolean resExiste(Resultat a){
        boolean rez=false;
        for(int i=0;i<lesResultats.size();i++){
             if(lesResultats.get(i).dom.name.equalsIgnoreCase(a.dom.name)){
                 rez=true; break;
             }
        }return rez;
    }

 public int getNoteByDomaine(String a){
     int rez=0;
     for(int i=0;i<lesResultats.size();i++){
         if(lesResultats.get(i).dom.name.equals(a)){
            rez= lesResultats.get(i).note;break;
         }
     }
     
     
     return rez;
 }
}
