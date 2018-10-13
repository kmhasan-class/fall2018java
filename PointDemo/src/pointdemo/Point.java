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
}
