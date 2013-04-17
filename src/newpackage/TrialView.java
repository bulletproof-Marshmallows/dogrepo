
package DogRecorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 *
 * @author Draz
 */
public class TrialView extends JPanel implements ActionListener{
    
    LinkedList<Dog> dogList;
    int packSize, numOfPacks, up, down, left, right, currentPack;
    DogQueue dqarr[];
    Dimension size;
    JLabel labelArr[];
    JLabel quick;
    JButton proceed;
    
    
    public TrialView(LinkedList<Dog> dogs, int packSize)
    {
        size = new Dimension(500,600);
        setPreferredSize(size);
        setSize(size);
        setLayout(null);
        proceed = new JButton("Next Pack");
        proceed.setPreferredSize(new Dimension(50, 50));
        proceed.setBounds(300, 450, 120, 50);
        add(proceed);
        currentPack = 1;
        numOfPacks = 3;
        quick = new JLabel("Pack " + currentPack + " of "+ numOfPacks);
        quick.setPreferredSize(new Dimension(50, 100));
        quick.setBounds(100, 200, 150, 50);
        add(quick);
        up = 50;
        down = 50;
        left = 300;
        right = 50;
        
        dogList = dogs;
        
        this.packSize = packSize;
        dqarr = new DogQueue[numOfPacks];
        for(int i = 0; i < numOfPacks; i++)
        {
            dqarr[i] = new DogQueue(packSize);
        }
        labelArr = new JLabel[packSize];
        for(int k = 0; k < packSize; k++)
        {
            labelArr[k] = new JLabel("Dog Number: " + (k + 1));
            labelArr[k].add(new JCheckBox("Win"));
            labelArr[k].setBounds(up, down, left, right);
            down += 50;
            add(labelArr[k]);
        }
        proceed.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if(currentPack < numOfPacks)
               currentPack += 1;
               
           }
        });
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        quick.repaint();
    }
    
}
