/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

/**
 *
 * @author Hanne
 */
public class MijnK3 implements HActionListener{
    
    HScene scene;
    int vragenTeller=0;
    int score=0;
    boolean check = false;
    HStaticText vraag;
    HTextButton knop1;
    HTextButton knop2;
    HTextButton knop3;
    HTextButton knop4;
    HTextButton nxt;
    HTextButton start;
    HStaticText resultaat;
    HStaticText antwoord;

    public void startQuiz(HScene scene) {
        scene.removeAll();

      this.scene=scene;
      
      Image ag;
      
      ag=scene.getToolkit().getImage("k3.jpg");
      
      MediaTracker mt=new MediaTracker(scene);
      
      mt.addImage(ag,1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
        ex.printStackTrace();
        }
      System.out.println(ag);
      scene.setBackgroundImage(ag);
     
      scene.setRenderMode(scene.IMAGE_CENTER);
      
      
      start = new HTextButton("start",20,300,680,50);
      start.setBackgroundMode(HVisible.BACKGROUND_FILL);
      start.setBackground(Color.PINK);
      scene.add(start);
      
      start.setActionCommand("start");
      
      
      vraag = new HStaticText("vraag1",20, 300,680,50);
      vraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
      vraag.setBackground(Color.PINK);
      
      
      knop1 = new HTextButton("ant1",20,370,300,50);
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop1.setBackground(Color.PINK);
      //scene.add(knop1);
    
      knop2 = new HTextButton("ant2",20,420,300,50);
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop2.setBackground(Color.PINK);
      //scene.add(knop2);
      
      knop3 = new HTextButton("ant3",350,370,300,50);
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop3.setBackground(Color.PINK);
      //scene.add(knop3);
      
      knop4 = new HTextButton("ant4",350,420,300,50);
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop4.setBackground(Color.PINK);
      //scene.add(knop4);
      
      nxt = new HTextButton("volgende vraag",350,500,300,50);
      nxt.setBackgroundMode(HVisible.BACKGROUND_FILL);
      nxt.setBackground(Color.PINK);
      //scene.add(nxt);
      
      resultaat = new HStaticText("je score is: "+score+"/10",20,300,680,50);
      resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
      resultaat.setBackground(Color.PINK);
      
      
      knop1.setFocusTraversal(null, knop2, null, knop3);
      knop2.setFocusTraversal(knop1, null, null, knop4);
      knop3.setFocusTraversal(null, knop4, knop1, null);
      knop4.setFocusTraversal(knop3, nxt, knop2, null);
      nxt.setFocusTraversal(knop4, null, null, null);
      
      scene.validate();
      scene.setVisible(true);

      
      //knop1.requestFocus();
      
      knop1.setActionCommand("fout");
      knop2.setActionCommand("fout");
      knop3.setActionCommand("fout");
      knop4.setActionCommand("juist");
      nxt.setActionCommand("volgende");
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      nxt.addHActionListener(this);
      start.addHActionListener(this);
            start.requestFocus();
      
    }
    
    //checken of het antwoord juist is en feedback geven
    public void actionPerformed(ActionEvent arg0){
        
      //teller die hoger word als je op volgende vraag drukt
      if(arg0.getActionCommand().equals("volgende"))
        {
            vragenTeller++;
            System.out.println("vragenteller="+vragenTeller);
        }
 
      if(arg0.getActionCommand().equals("start")){
            vragenTeller=1;//dit toont de eerste vraag
        }
        //juiste vraag word weergegeven adhv de teller
        //de juiste antwoorden worden goed gezet
      switch(vragenTeller){
          
          case 1:   scene.remove(start);
                    knoppenToevoegen();
                    knop1.requestFocus();
                    question1();
                    knop4.setActionCommand("fout");
                    knop2.setActionCommand("juist");
                    break;
          
          case 2:   question2();
                    check = false;
                    knop2.setActionCommand("fout");
                    knop3.setActionCommand("juist");
                    break;
                    
          case 3:   question3();
                    check = false;
                    knop3.setActionCommand("fout");
                    knop4.setActionCommand("juist");
                    break;
          case 4:   question4(); 
                    check = false;
                    break;
          case 5:   question5(); 
                    check = false;
                    knop4.setActionCommand("fout");
                    knop1.setActionCommand("juist");
                    break;
          case 6:   question6(); 
                    check = false;
                    knop1.setActionCommand("fout");
                    knop3.setActionCommand("juist");
                    break;
          case 7:   question7(); 
                    check = false;
                    knop3.setActionCommand("fout");
                    knop1.setActionCommand("juist");
                    break;
          case 8:   question8(); 
                    check = false;
                    knop1.setActionCommand("fout");
                    knop1.setActionCommand("juist");
                    break;
          case 9:   question9();
                    check = false;
                    knop1.setActionCommand("fout");
                    knop2.setActionCommand("juist");
                    break;
          case 10:  question10(); 
                    check = false;
                    knop2.setActionCommand("fout");
                    knop2.setActionCommand("juist");
                    nxt.setActionCommand("resultaat");
                    break;
      }
      
      //als er op resultaat word gedrukt knoppen verwijderen en score toevoegen
      if(arg0.getActionCommand().equals("resultaat")){
            resultaat.setTextContent("Je score ="+score, HVisible.NORMAL_STATE);//neemt nu de nieuwe score
            scene.add(resultaat);
            scene.remove(vraag);
            scene.remove(knop1);
            scene.remove(knop2);
            scene.remove(knop3);
            scene.remove(knop4);
            scene.remove(nxt);
            scene.remove(antwoord);
     
            scene.popToFront(resultaat);
        }
      
      scene.repaint();
        if (antwoord!=null) { scene.remove(antwoord); }        
        System.out.println(arg0.getActionCommand());
        //als het juist is...
        if(arg0.getActionCommand().equals("juist")){
            if(!check){
                score++;
            }
            System.out.println("score="+score);
            antwoord = new HStaticText("juist!",200,150,280,50);
            antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
            antwoord.setBackground(Color.GREEN);
            scene.add(antwoord);
            scene.popToFront(antwoord);
            scene.repaint(); 
        }
        if(arg0.getActionCommand().equals("juist")){
            check = true;
        }
        //als het fout is...
        if(arg0.getActionCommand().equals("fout")){
            antwoord = new HStaticText("fout",200,150,280,50);
            antwoord.setBackgroundMode(HVisible.BACKGROUND_FILL);
            antwoord.setBackground(Color.RED);
            scene.add(antwoord);
            scene.popToFront(antwoord);
            scene.repaint();
            check = true;
        }
    }
    
    //voegt de knoppen toe
    public void knoppenToevoegen(){
        scene.add(vraag);
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(knop4);
        scene.add(nxt);
    }
    //de methodes die telkens de juiste vraag tonen
    public void question1(){
        vraag.setTextContent("Hoe heet de originele nederlandse van k3?", HVisible.NORMAL_STATE);
        knop1.setTextContent("Klaasje Meijer", HVisible.NORMAL_STATE);
        knop2.setTextContent("Josje Huisman", HVisible.NORMAL_STATE);
        knop3.setTextContent("Kristel Verbeke", HVisible.NORMAL_STATE);
        knop4.setTextContent("Hanne Verbruggen", HVisible.NORMAL_STATE);
    }
    public void question2(){
        System.out.print("question2()");
        vraag.setTextContent("Hoe heette de nieuwe k3 hun eerste liedje?", HVisible.NORMAL_STATE);
        knop1.setTextContent("Pina colada", HVisible.NORMAL_STATE);
        knop2.setTextContent("Jij bent de bom", HVisible.NORMAL_STATE);
        knop3.setTextContent("10000 luchtbalonnen", HVisible.NORMAL_STATE);
        knop4.setTextContent("Laat het gras maar groeien", HVisible.NORMAL_STATE);
    }
    public void question3(){
        vraag.setTextContent("Wat was de originele naam van k3", HVisible.NORMAL_STATE);
        knop1.setTextContent("Pina colada", HVisible.NORMAL_STATE);
        knop2.setTextContent("vlaams gezang", HVisible.NORMAL_STATE);
        knop3.setTextContent("KaKriKa", HVisible.NORMAL_STATE);
        knop4.setTextContent("mascara", HVisible.NORMAL_STATE);
    }
    public void question4(){
        vraag.setTextContent("Wanneer stapte k3 over naar studio 100", HVisible.NORMAL_STATE);
        knop1.setTextContent("1999", HVisible.NORMAL_STATE);
        knop2.setTextContent("2000", HVisible.NORMAL_STATE);
        knop3.setTextContent("2001", HVisible.NORMAL_STATE);
        knop4.setTextContent("2002", HVisible.NORMAL_STATE);
    }
    public void question5(){
        vraag.setTextContent("Wanneer stopte Kathleen met k3?", HVisible.NORMAL_STATE);
        knop1.setTextContent("2009", HVisible.NORMAL_STATE);
        knop2.setTextContent("2010", HVisible.NORMAL_STATE);
        knop3.setTextContent("2011", HVisible.NORMAL_STATE);
        knop4.setTextContent("2008", HVisible.NORMAL_STATE);
    }
    public void question6(){
        vraag.setTextContent("Door wie werd Karen vervangen?", HVisible.NORMAL_STATE);
        knop1.setTextContent("Marthe", HVisible.NORMAL_STATE);
        knop2.setTextContent("Cindy", HVisible.NORMAL_STATE);
        knop3.setTextContent("Hanne", HVisible.NORMAL_STATE);
        knop4.setTextContent("Klaasje", HVisible.NORMAL_STATE);
    }
    public void question7(){
        vraag.setTextContent("Wie heeft er nog niets met een Verhulst gehad?", HVisible.NORMAL_STATE);
        knop1.setTextContent("Kristel", HVisible.NORMAL_STATE);
        knop2.setTextContent("Josje", HVisible.NORMAL_STATE);
        knop3.setTextContent("Karen", HVisible.NORMAL_STATE);
        knop4.setTextContent("Marthe", HVisible.NORMAL_STATE);
    }
    public void question8(){
        vraag.setTextContent("Hoeveel films heeft k3 al uitgebracht?", HVisible.NORMAL_STATE);
        knop1.setTextContent("6", HVisible.NORMAL_STATE);
        knop2.setTextContent("5", HVisible.NORMAL_STATE);
        knop3.setTextContent("7", HVisible.NORMAL_STATE);
        knop4.setTextContent("8", HVisible.NORMAL_STATE);
    }
    public void question9(){
        vraag.setTextContent("Hoe gaat het verder? \"Fluister zachtjes in m`n oor\"", HVisible.NORMAL_STATE);
        knop1.setTextContent("Ik heb je wel door", HVisible.NORMAL_STATE);
        knop2.setTextContent("Liefste schat, we gaan ervoor", HVisible.NORMAL_STATE);
        knop3.setTextContent("We komen er wel door", HVisible.NORMAL_STATE);
        knop4.setTextContent("Ik wil een drilboor", HVisible.NORMAL_STATE);
    }
    public void question10(){
        vraag.setTextContent("Wat was de eerste film van k3?", HVisible.NORMAL_STATE);
        knop1.setTextContent("k3 en het ijsprinsesje", HVisible.NORMAL_STATE);
        knop2.setTextContent("k3 en het magische Medaillon", HVisible.NORMAL_STATE);
        knop3.setTextContent("k3 en de kattenprins", HVisible.NORMAL_STATE);
        knop4.setTextContent("k3 en het wensbed", HVisible.NORMAL_STATE);
        nxt.setTextContent("resultaat", HVisible.NORMAL_STATE);
    }

   

    
    
    
    
    

}
