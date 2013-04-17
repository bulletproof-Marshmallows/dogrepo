/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Alvin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    static View view;

    public static void main(String[] args) {
        view = new View();
        view.start();
        Timer time = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getBegin()){
                    view.close();
                    view = new View();
                    view.start();
                }
            }
        });
        time.start();
    }
}
