/*
    Program name: "Baseball Diamond Runner". This program uses a simple UI to
    simulate a runner running at constant speed around a baseball diamond.
    Copyright (C) 2021  Quentin May

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

/*
Author information:
    Author: Quentin May
    Email: quentinemay@gmail.com, quentinemay@csu.fullerton.edu
*/

/*
Program information:
    Program name: Baseball Diamond Runner
    Programming language: Java
    Files: main.java, AppUI.java, Computations.java, Quad.java, run.sh
    Date project began: 2021-March-01
    Date of last update: 2021-March-07
    Status: Finished
    Purpose: This program simulates a runner running at constant speed around a baseball diamond.
    Base test system: Linux system with Bash shell and openjdk-14-jdk
*/

/*
This Module:
    File name: AppUI.java
    Compile: javac AppUI.java
    Purpose: This is the class file that defines the user interface
    This class is meant to be called from the main class.
    It's the backbone of the baseball diamond involves in defining the user interface and holding basic 
    functionality of the program.
*/
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
        
        /*
        Clock Handler Setup
        */
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
            if (startButton.getText() == "Start") { //When click start, initialize the ball then change the text to pause
                startButton.setText("Pause");
                System.out.println("Start Button called");
                pnlField.initializeBall(Double.parseDouble(inputSpeedTextField.getText())); // needs to be switched to the double parser that the professor prefers.
                timer.start();
            } else if (startButton.getText() == "Pause") { //When paused, just stop timer and change button to resume.
                timer.stop();
                startButton.setText("Resume");
            } else if (startButton.getText() == "Resume") { //When resume, simply just start timer and change button to pause.
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
                 if (pnlField.isRunning()) { //Check to see if our baseball runner is still running.
                     pnlField.repaint();
                 } else { //If he isnt running, then we know hes reached home base.
                     startButton.setText("Start");
                     timer.stop();
                 }
                 
                 
            }
        }
     }
    


    
}
