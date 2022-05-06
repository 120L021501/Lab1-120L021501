/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        //throw new RuntimeException("implement me!");
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        //throw new RuntimeException("implement me!");
        return (sides - 2) * 180.00 / sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        //throw new RuntimeException("implement me!");
        return (int) (360 / (180.00 - angle) + 0.5);
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        //throw new RuntimeException("implement me!");
    	turtle.forward(sideLength);
		double degrees = 360.00 / sides;
		for (int i = 1; i < sides; i++) {
			turtle.turn(degrees);
			turtle.forward(sideLength);
		}
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param d current location x-coordinate
     * @param e current location y-coordinate
     * @param f target point x-coordinate
     * @param g target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, double d, double e,
                                                 double f, double g) {
        //throw new RuntimeException("implement me!");
    	double vectorX = f - d;
		double vectorY = g - e;
		double degree = Math.toDegrees(Math.atan(vectorY/vectorX));
		double cbtp =90- degree - currentBearing;
		if (cbtp < 0)
			return cbtp+360.0;
		else
			return cbtp;


    }

    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
        //throw new RuntimeException("implement me!");
        List<Double> ans = new ArrayList<>();
		int length = xCoords.size();
		double temp = 0;
		for (int i = 1; i < length; i++) {
			temp = calculateBearingToPoint(temp, xCoords.get(i - 1), yCoords.get(i - 1), xCoords.get(i),
					yCoords.get(i));
			ans.add(temp);
		}
		return ans;
    }
    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    
    public static Set<Point> convexHull(Set<Point> points) {
        //throw new RuntimeException("implement me!");
    	ArrayList<Point> convex=new ArrayList<>();
    	ArrayList<Point> Point_container=new ArrayList<>();
    	Point_container.addAll(points);
    	if(points.size()<3) return points;
    	Point first=Point_container.get(0);
    	int temp=0;
    	for(int i=0;i<points.size();i++)
    	{
    		if(first.x()>Point_container.get(i).x())
    		{
    			first=Point_container.get(i);
    			temp=i;
    		}
    		else if(first.x()==Point_container.get(i).x()&&first.y()<Point_container.get(i).y())
    		{
    			first=Point_container.get(i);
    			temp=i;
    		}
    	}
    	convex.add(first);
    	Point_container.remove(temp);
    	Point min=first;
    	int flag=0,tag=0;
    	do
    	{
    		tag=0;
    		if(flag==1) Point_container.add(first);
    		double degree=360;
    		Point w=min;
    		for(int i=0;i<Point_container.size();i++)
    		{
    			int px=(int)Point_container.get(i).x();
    			int py=(int)Point_container.get(i).y();
    			int qx=(int)Point_container.get(temp).x();
    			int qy=(int)Point_container.get(temp).y();
    			double degree1=calculateBearingToPoint(0, min.x(), min.y(),px,py);
    			if(degree>degree1)
    			{
    				degree=degree1;
    				temp=i;
    			}
    			else if(degree==degree1)
    			{
    				double dx=(px-(int)min.x()*(px-(int)min.x())+(py-(int)min.y())*(py-(int)min.y()));
    				double dy=(qy-(int)min.y()*(qy-(int)min.y())+(qx-(int)min.x())*(qx-(int)min.x()));
    				if(dx>dy)
    				{
    					w=Point_container.get(temp);
    					temp=i;
    				}
    			}
    			
    		}
    		flag++;
    		if(w!=min) tag=1;
    		min=Point_container.get(temp);
    		convex.add(min);
    		Point_container.remove(temp);
    		if(tag==1)
    		{
    			for(int i=0;i<Point_container.size();i++)
    			{
    				if(Point_container.get(i)==w) Point_container.remove(i);
    			}
    		}
    		degree=360;
    	}while(first!=min);
    	Set<Point> final_point=new HashSet<>();
    	final_point.addAll(convex);
    	return final_point;
    	
    }
   
    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        //throw new RuntimeException("implement me!");
    	for(int i=1;i<800;i=i+2)
    	{
    		turtle.forward(i);
    		if (i < 100)
				turtle.color(PenColor.YELLOW);
			else if (i < 200)
				turtle.color(PenColor.MAGENTA);
			else if (i < 300)
				turtle.color(PenColor.GREEN);
			else if (i < 400)
				turtle.color(PenColor.RED);
			else if (i < 500)
				turtle.color(PenColor.ORANGE);
			else if (i < 600)
				turtle.color(PenColor.PINK);
			else if (i < 700)
				turtle.color(PenColor.CYAN);
			else {
				turtle.color(PenColor.BLUE);
			}
    		turtle.turn(91);
    	}
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        //drawSquare(turtle, 40);
        drawPersonalArt(turtle);

        // draw the window
        turtle.draw();
    }

}
