
package DogRecorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Draz
 */
public class WinnersView extends JPanel{
    JLabel winLabel;
    public WinnersView(Dog winner){
        winLabel = new JLabel();
        winLabel.setFont(new Font("Times New Roman",Font.PLAIN,40));
        winLabel.setText("The winner is: "+winner.getName());
        add(winLabel);
        
    }
}
