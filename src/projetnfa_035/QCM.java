/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetnfa_035;

import java.util.*;
import java.io.Serializable;
public class QCM implements Serializable{
 
          String question;
    String[]reponses ;
    int correctAnswer;
    public QCM(String question ,String reponse0,String reponse1,String reponse2,int reponseCorrecte){
        this.question=question;
        correctAnswer= reponseCorrecte;
        reponses= new String[3];
        reponses[0]=reponse0;
        reponses[1]=reponse1;
        reponses[2]=reponse2;
        
    }
    public String getQuestion(){return question;}
    public String[] getreponses(){return reponses;}
    public int getcorrectAnswer(){return correctAnswer;}
    public void setQuestion(String Question){this.question=Question;}
    public void setReponses(String [] a ){if(a.length!=3);
    else{this.reponses=a;}}
    public void setCorrectAnswer(int a){
        if(a<0||a>3);
    else{correctAnswer=a;}
    }
    
    
    }

