import java.awt.Point;

public class Rectangle  {

	static double epsilon = 0.0000001;
	Point p1, p2, p3, p4;
	
	public static double dotProduct(Point p1, Point p2) {
		return (p1.x * p2.x) + (p1.y * p2.y);
	}
	
	public static Point[] getClosestPts(Point a, Point b, Point c, Point d) {
		
		// Returns an array of size 2, representing the two closest points to point A (from b,c,d)
		Point[] closestPts = new Point[2];
		
		double AB = a.distance(b);
		double AC = a.distance(c);
		double AD = a.distance(d);
		
		if (AB > AC && AB > AD) { // AB is the longest side so C and D are closest
			closestPts[0] = c;
			closestPts[1] = d;
		} else if (AC > AB && AC > AD) { // AC is the longest side so B and D are closest
			closestPts[0] = b;
			closestPts[1] = d;
		} else { // AD is the longest side so B and C are closest
			closestPts[0] = b;
			closestPts[1] = c;
		}
		
		return closestPts;
	}
	
	public Rectangle(Point p1, Point p2, Point p3, Point p4) throws Exception {
		
		Point[] pts = {p1, p2, p3, p4};
		
		// If any points are equal, throw Exception
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (pts[i].equals(pts[j])) {
					throw new Exception("No two points can be the same!");
				}
			}
		}
		
		// Check if all angles are 90
		// From any point, if we draw 2 lines to the 2 closest pts, it should form a right angle
		
		for (int i = 0; i < 4; i++) {
			
			Point[] otherPts = new Point[3]; // otherpts is all pts except for pts[i]
			
			// Get two closest points from pts[i]
			int k = 0;
			for (int j = 0; j < 4; j++) {
				if (i != j) {
					otherPts[k] = pts[j];
					k++;
				}
			}
			
			Point[] closestPts = getClosestPts(pts[i], otherPts[0], otherPts[1], otherPts[2]); // Closest pts to pts[i]
			
			Point side1 = new Point(pts[i].x - closestPts[0].x, pts[i].y - closestPts[0].y); // side1 is pts[i] to closestPts[0]
			Point side2 = new Point(pts[i].x - closestPts[1].x, pts[i].y - closestPts[1].y); // side2 is pts[i] to closestPts[1]
			
			if (dotProduct(side1, side2) > epsilon) { // Non-right angle
				throw new Exception("Not a rectangle!");
			}
			
		}
		
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		
	}
	
	public boolean isSquare() {
		// Angles already verified by constructor, just need to verify equal lengths
		return (p1.distance(p2) == p2.distance(p3) && p1.distance(p2) == p3.distance(p4) && p1.distance(p2) == p4.distance(p1));
	}
	
	public double computeArea() {
		
		Point[] closestPts = getClosestPts(p1, p2, p3, p4); // Closest pts to p1
		return p1.distance(closestPts[0]) * p1.distance(closestPts[1]);
		
	}
	
	public double computePerimeter() {
		
		Point[] closestPts = getClosestPts(p1, p2, p3, p4); // Closest pts to p1
		return (p1.distance(closestPts[0]) + p1.distance(closestPts[1])) * 2.0;
		
	}
	
}
