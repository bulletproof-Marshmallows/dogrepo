/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Alvin
 */
public class AlvinTrialView extends JPanel{
    private DogQueue dogQ;
    private Dog temp;
    private ArrayList<JButton> buttonList;
    private ArrayList<JTextField> textList;
    GridLayout buttonLayout;
    private JPanel buttonPanel,textPanel;
    
    public AlvinTrialView(DogQueue q){
         setSize(400,400);
         setPreferredSize(new Dimension(300,300));
         setLayout(new GridLayout(1,2));
         //gets the alotted dogQueue
         dogQ = q;
         //list to hold the buttons to decide the winner as well as the text fields that 
         buttonList = new ArrayList();
         textList = new ArrayList();
         
         int rows=0;
         int count= dogQ.size();
         //loops to find the number of rowss and adds the objects accordingly
         for(int i=0;i<count;i++){
             temp = dogQ.dequeue();
             buttonList.add(new JButton("Winner?"));
             textList.add(new JTextField("Dog"+temp.getNumber()+" "+temp.getName()));
             rows++;
         }
         //grid layout for the process of morphing if more buttons than the normal size can fit
         buttonLayout = new GridLayout(rows, 1);
         //panels to hold the buttons and text fields
         buttonPanel = new JPanel(buttonLayout);
         textPanel= new JPanel(buttonLayout);
         //to insert the buttons into the panels
         for(int i=0;i<buttonList.size();i++){
             buttonPanel.add(buttonList.get(i));
             textPanel.add(textList.get(i));
         }
         //adds the panels to the main panel
         add(buttonPanel);
         add(textPanel);
         
    }
}
