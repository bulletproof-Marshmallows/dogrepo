/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Alvin
 */
public class PackSizeView extends JPanel{
    Dimension size;
    JComboBox packSize;
    JLabel SelPackSize,instruct1,instruct2;
    JButton finished;
    public PackSizeView(){
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
    }
}
