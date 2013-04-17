/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Alvin
 */
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DogInsertionView extends JPanel {

    private JTextField input;
    private JLabel instructions1, instructions2, sure;
    private JButton end, add, yes, no;
    private JTextArea test;
    private String testText;
    private JFrame endView;
    private Boolean change;
    private LinkedList<Dog> dogsList;

    public DogInsertionView() {
        change = false;
        dogsList = new LinkedList<>();
        input = new JTextField("Inset Dog Name Here.");
        instructions1 = new JLabel("Insert Dogs into text box and press \"ADD\".");
        instructions2 = new JLabel("To end press the \"END\" button");
        end = new JButton("END");
        add = new JButton("ADD");
        test = new JTextArea();
        testText = "";
        setLayout(null);
        setPreferredSize(new Dimension(300, 400));
        setSize(new Dimension(300, 400));
        add(input);
        add(instructions1);
        add(instructions2);
        add(end);
        add(test);
        add(add);
        input.setBounds(27, 50, 150, 25);
        instructions1.setBounds(45, 0, 250, 30);
        instructions2.setBounds(70, 20, 180, 30);
        end.setBounds(178, 50, 57, 25);
        add.setBounds(237, 50, 58, 25);

        endView = new JFrame();
        endView.setLayout(null);

        sure = new JLabel("Are you sure?");
        yes = new JButton("Yes");
        no = new JButton("No");
        endView.add(sure);
        endView.add(yes);
        endView.add(no);
        sure.setBounds(75, 5, 100, 30);

        yes.setBounds(25, 50, 57, 25);
        no.setBounds(150, 50, 57, 25);
        endView.setSize(new Dimension(250, 150));


        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals(" ")){
                    
                }
                dogsList.add(new Dog(input.getText(), (int) Math.random() * 10));
                testText = "";
                for (int i = 0; i < dogsList.size(); i++) {
                    testText += dogsList.get(i).getName() + "\n";
                }
                test.setText(testText);
                input.setText("");

            }
        });
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endView.setVisible(true);
            }
        });
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change = true;
                endView.setVisible(false);
                endView.dispose();
            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endView.setVisible(false);
                endView.dispose();
            }
        });
        input.setSelectedTextColor(Color.BLUE);
        test.setBorder(BorderFactory.createRaisedBevelBorder());
        test.setBounds(30, 90, 250, 300);
        test.setEditable(false);
        input.selectAll();
    }

    public Boolean isChange() {
        return change;
    }
 
}
