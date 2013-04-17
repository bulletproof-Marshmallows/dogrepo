/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author Alvin
 * modified by Draz
 */
public class PackSizeView extends JPanel{
    Dimension size;
    JComboBox packSize;
    JLabel SelPackSize,instruct1,instruct2;
    JButton finished;
    boolean done;
    int finalSize;
    LinkedList<Dog> dogsList;
    DogQueue[] dogsQ;
    public PackSizeView(LinkedList<Dog> dogs){
       dogsList = dogs;
       size=new Dimension(299, 399);
       setPreferredSize(size);
       setSize(size);
       setLayout(null);
       packSize = new JComboBox();
       packSize.addItem(new Integer(3));
       packSize.addItem(new Integer(4));
       packSize.addItem(new Integer(5));
       packSize.addItem(new Integer(6));
       packSize.addItem(new Integer(7));
       SelPackSize = new JLabel("Seclect Pack Size: ");
       instruct1 = new JLabel("Select the size of each pack");
       instruct2 = new JLabel("and press \"Finished\" when done.");
       finished = new JButton("Finished");
       add(SelPackSize);
       add(packSize);
       add(instruct1);
       add(instruct2);
       add(finished);       
       finished.setBounds(100,100,85,25);
       instruct1.setBounds(60,10,270,20);
       instruct2.setBounds(50, 30, 200, 20);
       SelPackSize.setBounds(60,75,115,20);
       packSize.setBounds(175,75,50,20);
       done = false;
       finalSize = 3;
       
       finished.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e)
           {
              done = true;
              Integer size = (Integer)packSize.getSelectedItem();
              int numDogs = dogsList.size();
              int packs = numDogs/size;
              System.out.println("NumDogs: "+numDogs+"\nThe packSize"+packs);
              dogsQ = new DogQueue[packs];
              int count =0;
              for(int i=0;i<dogsQ.length;i++){
                  dogsQ[i] = new DogQueue(numDogs/packs);
              }
              for(int i=0;i<numDogs;i++){
                  if(count<packs-1){
                      count++;
                  }else{
                      count =0;
                  }
                  dogsQ[count].enqueue(dogsList.get(i));
                  
              }
              
           }
       });
    }
    public boolean isDone()
    {
        return done;
    }
    public Integer getPackSize(){
        Integer i = (Integer)packSize.getSelectedItem();
        return i;
    }
    public DogQueue[] getPacks(){
        return dogsQ;
    }
}
