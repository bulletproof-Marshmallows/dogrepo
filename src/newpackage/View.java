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

    DogInsertionView dogInput;
    Timer time;
    private JMenuBar menuBar;
    private JMenu file, help;
    private JMenuItem reset, exit, about;
    private boolean begin;
    private boolean trial;
    boolean win;
    PackSizeView packSizeView;
    AlvinTrialView trialview;

    public View() {
        trialview = new AlvinTrialView();
        trial =false;
        begin = false;
        win =false;
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        file = new JMenu("File");
        help = new JMenu("Help");

        reset = new JMenuItem("Reset");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        packSizeView = new PackSizeView(null);
        menuBar.add(file);
        menuBar.add(help);
        file.add(reset);
        file.addSeparator();
        file.add(exit);
        help.add(about);
        this.setTitle("Dog Recorder");
        dogInput = new DogInsertionView();
        

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
        add(dogInput);
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
        if (dogInput.isChange()) {
            this.remove(dogInput);
            packSizeView = new PackSizeView(dogInput.getDogs());
            dogInput.falseChange();
            this.add(packSizeView);
            pack();
            
        }
        else if(packSizeView.isDone()&& !trial)
        {
            this.remove(packSizeView);
            //this.add(new TrialView(dogInput.getDogs(), packSizeView.getPackSize()));
            trialview =new AlvinTrialView(packSizeView.getPacks());
            this.add(trialview);
            pack();
            trial = true;
        }
        else if(trialview.isDone() && !win){
            Dog d = trialview.getWinner();
            this.remove(trialview);
            this.add(new WinnersView(d));
            win = true;
            pack();
            win =true;
        }
        
    }
    
}
