
package baseballdiamondanimation;

import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.JPanel;


public class Quad extends JPanel {
        private Point[] points = new Point[5];

        private Point2D.Double ballPosition = new Point2D.Double(0, 1);
        private int ballRadius = 10;
        private double deltaX;
        private double deltaY;
        private double distance_traveled_per_tic;
        private Point nextPoint;
        private double pixPerSec;
        private boolean running;
        
    public Quad() {
        points[0] = new Point(960, 900);
        points[1] = new Point(1360, 500);
        points[2] = new Point(960, 100);
        points[3] = new Point(560, 500);
        ballPosition.setLocation(points[0].x, points[0].y);
        nextPoint = new Point(points[1]);
    }
    public void paintComponent(Graphics g) {
        
    Computations comp = new Computations();
        super.paintComponent(g);
        for (int i = 0; i < 4; i++) {
            if (i == 3)
                g.drawLine(points[i].x, points[i].y, points[0].x, points[0].y);
                else
            g.drawLine(points[i].x, points[i].y, points[i+1].x, points[i+1].y);
            
        }
        g.setColor(Color.ORANGE);
        if (Math.sqrt(Math.pow((double)ballPosition.getX() - nextPoint.x, 2) + Math.pow((double)ballPosition.getY() - nextPoint.y, 2)) <= distance_traveled_per_tic) {
            
            System.out.println("too close to point. Just teleport to the spot then recalculate.");
            ballPosition.setLocation(nextPoint.x, nextPoint.y);
            for (int i = 0; i < points.length; i++) {
                    if (!nextPoint.equals(points[1])) {
                        if (ballPosition.getX() == points[0].x && ballPosition.getY() == points[0].y) {
                            System.out.println("Returned home");
                            running = false;
                            g.fillOval((int)ballPosition.getX() - ballRadius, (int)ballPosition.getY() - ballRadius, ballRadius*2, ballRadius*2);
                            return;
                        }
                    }
                        if (running == true){
                            if(nextPoint.equals(points[i])) {
                                if (i == 3) nextPoint = new Point(points[0]);
                                else
                                    nextPoint = new Point(points[i+1]);
                                break;
                            }
                        }
                
            }
            
            g.fillOval((int)ballPosition.getX() - ballRadius, (int)ballPosition.getY() - ballRadius, ballRadius*2, ballRadius*2);
            double[] delta = comp.computeDelta(new Point((int)ballPosition.getX(), (int)ballPosition.getY()), nextPoint, pixPerSec);
            System.out.println("rise:" + delta[1] + " / run:" + delta[0]);
            deltaX = delta[0];
            deltaY = delta[1];
        } else {
            ballPosition.setLocation(ballPosition.getX() + deltaX, ballPosition.getY() + deltaY);
            g.fillOval((int)ballPosition.getX() - ballRadius, (int)ballPosition.getY() - ballRadius, ballRadius*2, ballRadius*2);
        }
            
    }
    
    public boolean isRunning() {
        return running;
    }
    
    //Call this function from the main class before running
    public void initializeBall(double pixPerSec) {
            running = true;
            this.pixPerSec = pixPerSec;
            distance_traveled_per_tic = pixPerSec / 100;
            ballPosition.setLocation(points[0].x, points[0].y);
            nextPoint = new Point(points[1]);
            
            Computations comp = new Computations();
            double[] delta = comp.computeDelta(new Point((int)ballPosition.getX(), (int)ballPosition.getY()), nextPoint, pixPerSec);
            System.out.println("rise:" + delta[1] + " / run:" + delta[0]);
            deltaX = delta[0];
            deltaY = delta[1];
            

    }
}
