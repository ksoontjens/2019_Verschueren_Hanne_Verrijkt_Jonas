package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;

import javax.tv.xlet.*;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
       
    MijnK3 k31 = new MijnK3();
    MijnBuurtpolite buurt1 = new MijnBuurtpolite();
    
    HTextButton k3;
    HTextButton buurtpolitie;

    public HelloTVXlet() {
         
    }

    public void initXlet(XletContext context) {
            scene=HSceneFactory.getInstance().getDefaultHScene();  
            Image ag;
      
            ag=scene.getToolkit().getImage("hoofdAfbeelding.jpg");
      
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
        
               
            k3 = new HTextButton("k3",20,300,280,50);
            k3.setBackgroundMode(HVisible.BACKGROUND_FILL);
            k3.setBackground(Color.GREEN);
            scene.add(k3);
            k3.requestFocus();
            k3.setActionCommand("k3");
            k3.addHActionListener(this);
            
            
            buurtpolitie = new HTextButton("buurtpolitie",395,300,280,50);
            buurtpolitie.setBackgroundMode(HVisible.BACKGROUND_FILL);
            buurtpolitie.setBackground(Color.GREEN);
            scene.add(buurtpolitie);
            buurtpolitie.setActionCommand("buurtpolitie");
            buurtpolitie.addHActionListener(this);
            
            scene.validate();
            scene.setVisible(true);
            
            k3.setFocusTraversal(null, null, null, buurtpolitie);
            buurtpolitie.setFocusTraversal(null, null, k3, null);
            
      
    }
    

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent arg0) {
       if(arg0.getActionCommand().equals("k3"))
            {
                k31.startQuiz(scene);
                scene.remove(k3);    
                scene.remove(buurtpolitie);
            }
       if(arg0.getActionCommand().equals("buurtpolitie"))
            {
                buurt1.startQuiz();
                scene.remove(buurtpolitie);
                scene.remove(k3);  
                
            }
       
    }

    

    
}
