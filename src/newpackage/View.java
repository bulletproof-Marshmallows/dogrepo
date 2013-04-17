/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DogRecorder;

/**
 *
 * @author Alvin
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame implements ActionListener {

    DogInsertionView view1;
    Timer time;
    private JMenuBar menuBar;
    private JMenu file, help;
    private JMenuItem reset, exit, about;
    private boolean begin;
    PackSizeView p = new PackSizeView();

    public View() {
        
        begin = false;
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        file = new JMenu("File");
        help = new JMenu("Help");

        reset = new JMenuItem("Reset");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");

        menuBar.add(file);
        menuBar.add(help);
        file.add(reset);
        file.addSeparator();
        file.add(exit);
        help.add(about);
        this.setTitle("Dog Recorder");
        view1 = new DogInsertionView();
        p = new PackSizeView();

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                begin = true;
            }
        });
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               HelpView help = new HelpView();
               help.setVisible(true);
               help.setTitle("HELP");
            }
        });
        add(view1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
        time = new Timer(1, this);
        time.start();
    }

    public void start() {
        setIconImage(new ImageIcon(getClass().getResource("beagle.png")).getImage());
        setVisible(true);
        setResizable(false);
    }

    public boolean getBegin(){
        return begin;
    }
       public void close(){
        setVisible(false);
        this.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (view1.isChange()) {
            this.remove(view1);
            view1.falseChange();
            this.add(p);
            pack();
            
        }
        if(p.isDone())
        {
            this.remove(p);
            this.add(new TrialView(view1.getDogs(), p.getPackSize()));
            pack();
            
        }
        
        /*if(begin){
          this.remove(p);
          add(view1);
          pack();
          begin = false
          }*/
    }
    
}
