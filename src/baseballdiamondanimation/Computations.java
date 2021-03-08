
package baseballdiamondanimation;

import java.awt.Point;



public class Computations {

    
    public double[] computeDelta(Point first, Point last, double pixPerSec) {
        double rise = Math.abs(first.y - last.y);
        double run = Math.abs(first.x - last.x);
        System.out.println(first);
        System.out.println(last);

        double ratio = Math.sqrt(Math.pow(rise, 2) + Math.pow(run, 2));
        
        double deltaX = (rise / ratio) * pixPerSec / 100;
        double deltaY = (run / ratio) * pixPerSec / 100;
        if (first.y > last.y) deltaY = deltaY * -1;
        if (first.x > last.x) deltaX = deltaX * -1;
        System.out.println("deltaX: " + deltaX);
        System.out.println("deltaY: " + deltaY);
        return new double[]{deltaX, deltaY};
    }
}
