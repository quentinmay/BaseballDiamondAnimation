package baseballdiamondanimation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AppUI extends JFrame implements ActionListener {
    
    private JPanel pnlTitle = new JPanel();
    private Quad pnlField = new Quad();
    private JPanel pnlControl = new JPanel();
    private Clockhandlerclass clockhandler;
    
    private JTextField inputSpeedTextField = new JTextField();
    
    private JButton startButton = new JButton("Start");
    private JButton quitButton = new JButton("Quit");
    
    private Timer timer;
    
    public AppUI() {
        
//        pnlTitle.setSize(new Dimension(300, 8));
        
        this.setLayout(new BorderLayout(3, 1));
        this.add(pnlTitle, BorderLayout.PAGE_START);
        this.add(pnlField, BorderLayout.CENTER);
        this.add(pnlControl, BorderLayout.SOUTH);
        
        /*
        Title Panel Setup
        */
        pnlTitle.setBackground(Color.YELLOW);
        pnlTitle.add(new JLabel("Diamond Animation by Quentin May"));
                
        /*
        Field Panel Setup
        */
        pnlField.setBackground(Color.GREEN);
        pnlField.setLayout(new GridLayout(4, 2, 5, 5));
        
        /*
        Control Panel Setup
        */
        pnlControl.setBackground(Color.RED);
        pnlControl.setLayout(new GridLayout(1, 4, 5, 5));
        
        
        pnlControl.add(startButton);
        startButton.setBackground(Color.WHITE);
        startButton.addActionListener(this);
        
        pnlControl.add(new JLabel("Speed:"));
        pnlControl.add(inputSpeedTextField);

        pnlControl.add(quitButton);
        quitButton.setBackground(Color.RED);
        quitButton.addActionListener(this);
        
        clockhandler = new Clockhandlerclass();
        timer = new Timer(10, clockhandler); //Cant change speed that it updates without changing the distance travelled manually in Quad.
        this.setSize(1920,1040);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("223J Assignment 2");
        this.setVisible(true); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (startButton.getText() == "Start") {
                startButton.setText("Pause");
                System.out.println("Start Button called");
                pnlField.initializeBall(Double.parseDouble(inputSpeedTextField.getText())); // needs to be switched to the double parser that the professor prefers.
                timer.start();
            } else if (startButton.getText() == "Pause") {
                timer.stop();
                startButton.setText("Resume");
            } else if (startButton.getText() == "Resume") {
                timer.start();
                startButton.setText("Pause");
            }
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
    
     private class Clockhandlerclass implements ActionListener {   
         public void actionPerformed(ActionEvent event) {
             
             if (event.getSource() == timer) {
                 if (pnlField.isRunning()) {
                     pnlField.repaint();
                 } else {
                     timer.stop();
                     startButton.setText("Start");
                 }
                 
                 
            }
        }
     }
    


    
}
