package baseballdiamondanimation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AppUI extends JFrame implements ActionListener {
    
    private JPanel pnlTitle = new JPanel();
    private JPanel pnlField = new JPanel();
    private JPanel pnlControl = new JPanel();
    
    
    private JTextField inputSpeedTextField = new JTextField();
    
    private JButton startButton = new JButton("Start");
    private JButton quitButton = new JButton("Quit");
    
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
        
        
        this.setSize(1920,1040);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("223J Assignment 2");
        this.setVisible(true); 
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            System.out.println("Start Button called");
            
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
    
}