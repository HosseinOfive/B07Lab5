

public class Circle {
	Point c;
	double r;
	
	public Circle(Point c, double r) {
		if (!(c instanceof Point)) {
		    throw new IllegalArgumentException("c must be a Point object");
		}
		if (r == 0) {
			throw new IllegalArgumentException("r can not be 0");
		}
		this.c = c;
		this.r = r;
	}
	
	public double circumference() {
		return 2 * Math.PI * this.r;
	}
	
	public double area() {
		return Math.PI * this.r * this.r;
	}
	
	public boolean isCongruent(Circle other) {
		double epsilon = 1e-6;
		return Math.abs(this.r - other.r) < epsilon;
	}
	
	@Override
	public int hashCode() {
		return (int)(3*this.r);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Circle other = (Point) obj;
		if (this.r != other.r)
			return false;
		if (!(this.c.equals(other.c)))
			return false;
		return true;
	}
}