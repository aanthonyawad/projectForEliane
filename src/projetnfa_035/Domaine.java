/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfa_035;

import java.util.*;
import java.io.Serializable;
public class Domaine implements Serializable {
    String name;
    ArrayList<QCM> questions;
  public Domaine(String name){
      this.name=name;
      questions= new ArrayList<QCM>();
      
  }
  public void addQCM(QCM a){
      questions.add(a);
  }
  public int RetirerQCMParNom(String name){
      int j=-1;
      for(int i=0;i<questions.size();i++){
          if(questions.get(i).getQuestion().equals(name)){
              j=i; break;
          }}
          if(j<0){return j;}
          else{ questions.remove(j);return j;}
          
      }
  
  public int RetirerQCMParQCM(QCM a){
      int j=-1;
      for(int i=0;i<questions.size();i++){
          if(questions.get(i)==a){
              j=i;break;
          }
      }
  if(j<0){return j;}
  else{
       questions.remove(j);return j;
  }
  
  
  }
  
   public ArrayList<QCM>  makeQuiz(){
       ArrayList<QCM> duplicate = new ArrayList<QCM>();
       for(int i=0;i<questions.size();i++){
           duplicate.add(questions.get(i));
           
       }
       
       ArrayList<QCM> quiz= new ArrayList<QCM>();
       for(int i=0;i<10;i++){
           int b =(int)(Math.random()*(duplicate.size()));
           QCM a=duplicate.get(b);
           quiz.add(a);
           duplicate.remove(b);
       }
   return quiz;
   }
  
  }
  
  
  

