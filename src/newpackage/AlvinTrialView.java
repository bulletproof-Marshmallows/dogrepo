/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Alvin
 */
public class AlvinTrialView extends JPanel {

    private DogQueue[] dogQ;
    private Dog temp;
    private ArrayList<JRadioButton> radioButtonList;
    private ArrayList<JTextField> textList;
    GridLayout buttonLayout;
    private JPanel buttonPanel, textPanel;
    private int packCount;
    private DogQueue winners;
    private ArrayList<Dog> dogs;
    private int buttonCount,packSize;
    private boolean done;
    
    public AlvinTrialView(){
        done =false;
    }

    public AlvinTrialView(DogQueue[] q) {
        done =false;
        setSize(400, 400);
        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(1, 2));
        packCount = 0;
        winners = new DogQueue();
        //gets the alotted dogQueue
        dogQ = q;
        packSize = q.length;
        //list to hold the buttons to decide the winner as well as the text fields that 
        radioButtonList = new ArrayList();
        textList = new ArrayList();
        dogs = new ArrayList();
        int rows = 0;
        int count = dogQ[packCount].size();
        //loops to find the number of rowss and adds the objects accordingly
        for (int i = 0; i < count; i++) {

            temp = dogQ[packCount].dequeue();
            dogs.add(temp);
            radioButtonList.add(new JRadioButton("Winner?"));
            textList.add(new JTextField("Dog" + temp.getNumber() + " " + temp.getName()));
            textList.get(i).setEditable(false);
            rows++;

        }
        //grid layout for the process of morphing if more buttons than the normal size can fit
        buttonLayout = new GridLayout(rows, 1);
        //panels to hold the buttons and text fields
        buttonPanel = new JPanel(buttonLayout);
        textPanel = new JPanel(buttonLayout);
        //to insert the buttons into the panels
        for (int i = 0; i < radioButtonList.size(); i++) {
            buttonPanel.add(radioButtonList.get(i));
            textPanel.add(textList.get(i));
        }
        //adds the panels to the main panel
        add(buttonPanel);
        add(textPanel);

        buttonCount = 0;
        for (int o = 0; o < radioButtonList.size(); o++) {
            radioButtonList.get(o).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int c = 0;
                    for (int loop = 0; loop < radioButtonList.size(); loop++) {
                        if (radioButtonList.get(loop).isSelected()) {
                            c = loop;
                        }
                    }
                    packCount++;
                    System.out.println("enqueue to winners");
                    winners.enqueue(dogs.get(c));
                    System.out.println(winners.toString() + "Enqueued");
                    if (packCount < dogQ.length) {
                        continueTrial();
                    }
                }
            });
            buttonCount++;
        }
    }
    //proceeds to next set of dogs.

    public void continueTrial() {

        this.remove(buttonPanel);
        this.remove(textPanel);
        for (int i = 0; i < radioButtonList.size(); i++) {
            buttonPanel.remove(radioButtonList.get(i));
            textPanel.remove(textList.get(i));
        }
        radioButtonList = new ArrayList();
        textList = new ArrayList();
        dogs = new ArrayList();
        int rows = 0;
        int count = dogQ[packCount].size();
        //loops to find the number of rowss and adds the objects accordingly
        for (int i = 0; i < count; i++) {

            temp = dogQ[packCount].dequeue();
            dogs.add(temp);
            radioButtonList.add(new JRadioButton("Winner?"));
            textList.add(new JTextField("Dog" + temp.getNumber() + " " + temp.getName()));
            textList.get(i).setEditable(false);
            rows++;

        }
        //grid layout for the process of morphing if more buttons than the normal size can fit
        buttonLayout = new GridLayout(rows, 1);
        //panels to hold the buttons and text fields
        buttonPanel = new JPanel(buttonLayout);
        textPanel = new JPanel(buttonLayout);
        //to insert the buttons into the panels
        for (int i = 0; i < radioButtonList.size(); i++) {
            buttonPanel.add(radioButtonList.get(i));
            textPanel.add(textList.get(i));
        }
        add(buttonPanel);
        add(textPanel);
        this.revalidate();
        buttonCount = 0;
        System.out.println("Winners Queue Size"+winners.size());
        System.out.println("DogQ: "+dogQ.length);
        for (int o = 0; o < radioButtonList.size(); o++) {
            radioButtonList.get(o).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int c = 0;
                    for (int loop = 0; loop < radioButtonList.size(); loop++) {
                        if (radioButtonList.get(loop).isSelected()) {
                            c = loop;
                        }
                    }
                    packCount++;
                    System.out.println("enqueue to winners");
                    winners.enqueue(dogs.get(c));
                    System.out.println(winners.toString() + "Enqueued");
                    if (packCount < dogQ.length) {
                        continueTrial();
                    } else {
                        dogQ = new DogQueue[winners.size() / packCount];
                        int packs = winners.size() / packCount;
                        int counter = 0;
                        int wins = winners.size();

                        for (int i = 0; i < dogQ.length; i++) {
                            dogQ[i] = new DogQueue();
                        }

                        for (int i = 0; i < wins; i++) {
                            if (counter < packs && counter != 0) {
                                counter++;
                            } else {
                                counter = 0;
                            }
                            dogQ[counter].enqueue(winners.dequeue());
                        }
                        
                        packCount = 0;
                        if (dogQ.length-1 == 0 && radioButtonList.size() == 1 && winners.isEmpty()) {
                            System.out.println("Winner is " + dogQ[0].front().getName());
                            done=true;
                            
                        } else {
                            continueTrial();
                        }
                    }
                }
            });

            buttonCount++;
        }

    }

    /**
     * @return the done
     */
    public boolean isDone() {
        return done;
    }
    public Dog getWinner(){
       Dog dog=dogQ[0].front();
       
       return dog;
    }
}
