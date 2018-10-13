package pointdemo;

public class PointDemo {

    public static void main(String[] args) {
// Alt + Shift + F to fix formatting
        Point p1 = new Point(3, 2);
        Point p2 = new Point(2, 5);

        double d = p1.getDistance(p2);

        System.out.printf("d = %f\n", d);
        
        System.out.printf("Before translation x=%f, y=%f\n",
                p1.x, p1.y);
        p1.translate(2.5, 1.5);
        System.out.printf("After translation  x=%f, y=%f\n",
                p1.x, p1.y);
        
        Point p3 = new Point(4, 2);
        System.out.printf("Before rotation x=%f, y=%f\n",
                p3.x, p3.y);
        p1.rotate(10);
        System.out.printf("After rotation  x=%f, y=%f\n",
                p3.x, p3.y);
    }
}
