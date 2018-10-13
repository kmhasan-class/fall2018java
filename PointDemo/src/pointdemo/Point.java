package pointdemo;

public class Point {

    double x;
    double y;

    // constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }
    
    // 2D transformation
    // https://www.tutorialspoint.com/computer_graphics/2d_transformation.htm
    
    public void translate(double tx, double ty) {
        x = x + tx;
        y = y + ty;
    }
    
    public void rotate(double angleInDegrees) {
        double theta = Math.toRadians(angleInDegrees);
        double xp = x * Math.cos(theta) - y * Math.sin(theta);
        double yp = x * Math.sin(theta) + y * Math.cos(theta);
        x = xp;
        y = yp;
    }
    
    // HW: write the scale method
}
