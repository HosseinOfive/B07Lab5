import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTests2 {

	@Test
	void testConstructorNotRect() {
		assertThrows(Exception.class, () -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 1),
					new Point(2, 1),
					new Point(1.99, 0.01)
			);
		});			
	}
	
	@Test
	void testConstructorIsRect() {
		assertDoesNotThrow(() -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 1),
					new Point(2, 1),
					new Point(2, 0)
			);
		});	
	}
	
	@Test
	void testConstructorSamePoint() {
		assertThrows(Exception.class, () -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 0),
					new Point(1, 0),
					new Point(1, 1)
			);
		});			
	}
	
	@Test 
	void testConstructorReallyLarge() {
		assertDoesNotThrow(() -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 1),
					new Point(10000000, 0),
					new Point(10000000, 1)
			);
		});			
	}
	
	@Test 
	void testConstructorSwapPoints1() {
		assertDoesNotThrow(() -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 1),
					new Point(10000000, 0),
					new Point(10000000, 1)
			);
		});			
	}
	
	@Test 
	void testConstructorSwapPoints() {
		assertDoesNotThrow(() -> { 
			new Rectangle(
					new Point(0, 0),
					new Point(0, 2),
					new Point(1, 0),
					new Point(1, 2)
			);
		});			
	}
	
	@Test
	void testIsSquare1() throws Exception {
		Rectangle r1 = new Rectangle(
				new Point(0, 1),
				new Point(1, 1),
				new Point(1, 0),
				new Point(0, 0)
		);
		assertTrue(r1.isSquare());
	}
	
	@Test
	void testIsSquare2() throws Exception {
		Rectangle r1 = new Rectangle(
				new Point(0, 1),
				new Point(2, 1),
				new Point(2, 0),
				new Point(0, 0)
		);
		assertFalse(r1.isSquare());
	}
	
	@Test
	void testComputeArea() throws Exception {
		Rectangle r1 = new Rectangle(
				new Point(0, 1),
				new Point(2, 1),
				new Point(2, 0),
				new Point(0, 0)
		);
		assertEquals(r1.computeArea(), 2);
	}
	
	@Test
	void testComputePerimeter() throws Exception {
		Rectangle r1 = new Rectangle(
				new Point(0, 1),
				new Point(2, 1),
				new Point(2, 0),
				new Point(0, 0)
		);
		assertEquals(r1.computePerimeter(), 6);
	}
}
