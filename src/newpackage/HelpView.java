/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alvin
 */
public class HelpView extends JFrame {

    private JTextArea info;

    public HelpView() {
        info = new JTextArea();
        info.setFont(new Font("times new roman", Font.PLAIN, 18));
        info.setText("This program is designed to keep track of beagle compititions. At the top of every"
                + " screen there is a \"file\" menu that can be used to reset or exit the program and a \"help\""
                + "menu that provides information. The program first takes in the dog names, then the pack size should be"
                + "decided after the end button is hit.");
        info.setWrapStyleWord(true);
        info.setLineWrap(true);
        info.setBorder(BorderFactory.createRaisedBevelBorder());
        add(info);
        info.setEditable(false);
        this.setIconImage(new ImageIcon(HelpView.class.getResource("helpIcon.png")).getImage());
        setSize(300, 300);
    }
    public void close(){
        this.setVisible(false);
    }
}
