import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import java.util.concurrent.TimeUnit;

import gpdraw.*; // for DrawingTool


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i<myPolygon.size()-1; i++){
            Point2D.Double point = myPolygon.get(i);
            Point2D.Double point2 = myPolygon.get(i+1);
            perimeter += point.distance(point2);
        }
        perimeter += myPolygon.get(myPolygon.size()-1).distance(myPolygon.get(0));
        return perimeter;
    }

    public double area() {
        double firstTerm = 0;
        double secondTerm = 0;
        for (int i = 0; i<myPolygon.size()-1; i++){
            Point2D.Double point = myPolygon.get(i);
            Point2D.Double point2 = myPolygon.get(i+1);
            firstTerm += point.x * point2.y; 
            secondTerm += point.y * point2.x;
        }
        firstTerm += myPolygon.get(myPolygon.size()-1).x * myPolygon.get(0).y;
        secondTerm += myPolygon.get(myPolygon.size()-1).y * myPolygon.get(0).x;
        double area = 0.5 * (firstTerm-secondTerm);
        return Math.abs(area);

    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            pen.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}
