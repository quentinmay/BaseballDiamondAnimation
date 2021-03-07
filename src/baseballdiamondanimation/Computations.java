
package baseballdiamondanimation;

import java.awt.Point;



public class Computations {

    
    public double[] computeDelta(Point first, Point last, double pixPerSec) {
        double rise = (first.y - last.y);
        double run = (first.x - last.x);
        System.out.println(first);
        System.out.println(last);

        double ratio = Math.sqrt(Math.pow(rise, 2) + Math.pow(run, 2));
        double deltaX = (rise / ratio) * pixPerSec / 100;
        double deltaY = (run / ratio) * pixPerSec / 100;
        return new double[]{deltaX, deltaY};
    }
}
