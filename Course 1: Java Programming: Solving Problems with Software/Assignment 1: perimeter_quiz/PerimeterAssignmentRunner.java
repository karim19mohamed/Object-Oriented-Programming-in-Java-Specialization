import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point p : s.getPoints()){
            numPoints += 1;
        }
        
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter (s);
        int numPoints = getNumPoints(s);
        perimeter /= (double) numPoints;
        return perimeter;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide = 0.0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            largestSide = Math.max(largestSide,currDist);
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double X = 0.0;
        for (Point currPt : s.getPoints()) {
            X = Math.max(X,currPt.getX());
        }
        return X;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            largestPerimeter = Math.max(largestPerimeter, length);
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (largestPerimeter < length){
                largestPerimeter = length;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int numPoints = getNumPoints(s);
        double length = getPerimeter(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double X = getLargestX(s);
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("numPoints = " + numPoints);
        System.out.println("perimeter = " + length);
        System.out.println("avgLength = " + avgLength);
        System.out.println("largestSide = " + largestSide);
        System.out.println("X = " + X);
        System.out.println("largestPerimeter = " + largestPerimeter);
        System.out.println("largestFile = " + largestFile + "\n");
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
