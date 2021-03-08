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
    File name: Computations.java
    Compile: javac Computations.java
    Purpose: This is the class file that holds our algorithm to calculate the deltaX
    and deltaY necessary for the runner to continue at a constant speed down his path.
*/
package baseballdiamondanimation;

import java.awt.Point;



public class Computations {

    /*
    My algorithm is slightly different because I wasn't a fan of the given ones. Instead uses basic rise-run terminology.
    And once I calculate the rise:run, I get the rise:run where distance travelled per tic (C) = 1. Then I can multiply rise:run by given constant speed
    to get a distance travelled per tic that equals the given speed.
    */
    public double[] computeDelta(Point first, Point last, double pixPerSec) {
        double rise = Math.abs(first.y - last.y);
        double run = Math.abs(first.x - last.x);

        double ratio = Math.sqrt(Math.pow(rise, 2) + Math.pow(run, 2)); //Ratio is the hypotenuse of the theoretical right triangle.
                                                                        //If we divide deltaX and deltaY by this, we get a hypotenuse
                                                                        //that = 1. then we just multiply our wanted speed to both.
        
        
        
        double deltaX = (run / ratio) * pixPerSec / 100; //the "/ 100" comes from the timer tickrate. We tick 100 times a second, so we divide pixPerSec by the tickrate to get the movement per tic
        double deltaY = (rise / ratio) * pixPerSec / 100;
        //deltaX and deltaY are now our rise and run assuming that we are traveling at our constant speed
        
        if (first.y > last.y) deltaY = deltaY * -1; //Shifts deltaY to be correct direction if were supposed to be going negative
        if (first.x > last.x) deltaX = deltaX * -1; //Sgufts deltaX to be correct direction
        return new double[]{deltaX, deltaY};
    }
}
