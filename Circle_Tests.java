import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Circle_Tests {
	@Test
	void testIllegalArgPoint() {
 
		
		assertThrows( IllegalArgumentException.class,  () -> {
			new Circle(null, 5);
		}); 
	}
	@Test
	void testIllegalArgrad() {
		Point ver = new Point(0,0);
		assertThrows( IllegalArgumentException.class,  () -> {
			new Circle(ver , 0);
		}); 
		
	}
	@Test
	void testCircumfrence() {
		Point ver = new Point(0,0);
		Circle r = new Circle(ver, 1);
		assertEquals(r.circumference(), 2*Math.PI);
	}
	@Test
	void testArea() {
		Point ver = new Point(0,0);
		Circle r = new Circle(ver, 1);
		assertEquals( r.area()   , Math.PI);
		
	} 
	@Test
	void testISongruent1() {
		
		 
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		Circle r2 = new Circle(ver, 1);
		assertTrue(r1.isCongruent(r2));
	}
	@Test
	void testISongruent2() {
		
		 
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		Circle r2 = new Circle(ver, 5);
		assertFalse(r1.isCongruent(r2));
	}
	
	@Test
	void testHashEq() {
		Point ver1 = new Point(0,0);
		Point ver2 = new Point(0,0);
		Circle r1 = new Circle(ver1, 1);
		Circle r2 = new Circle(ver2, 1);
		assertEquals(r2.hashCode() , r1.hashCode());
	}
	@Test
	void testHashNotEq() {
		Point ver1 = new Point(0,0);
		Point ver2 = new Point(0,0);
		Circle r1 = new Circle(ver1, 1);
		Circle r2 = new Circle(ver2, 5);
		assertNotEquals(r2.hashCode() , r1.hashCode());
	}
	@Test
	void testEquals1() {
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		assertTrue(r1.equals(r1));
	}
	@Test
	void testEquals2() {
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		assertFalse(r1.equals(null));
	}
	@Test
	void testEquals3() {
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		assertFalse(r1.equals( (Object) ver));
	}
	@Test
	void testEquals4() {
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		Circle r2 = new Circle(ver, 3);
		assertFalse(r1.equals(r2));
	}
	@Test 
	void testEquals5() {
		Point ver = new Point(0,0);
		Point ver2 = new Point(1,0);
		Circle r1 = new Circle(ver, 1);
		Circle r2 = new Circle(ver2, 1);
		assertFalse(r1.equals(r2));
	}
	@Test
	void testEquals6() {
		Point ver = new Point(0,0);
		Circle r1 = new Circle(ver, 1);
		Circle r2 = new Circle(ver, 1);
		assertTrue(r1.equals(r2));
	}
	

}
