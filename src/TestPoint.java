import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Point;


public class TestPoint extends LockedTestCase {

	protected void assertNotEquals(Object o1, Object o2) {
		if (o1 == null ? o2 != null : !o1.equals(o2)) return;
		if (o1 == null) {
			assertFalse("expected different: null and null",true);
		} else {
			assertFalse("expected different: <" + o1 + "> and <" + o2 + ">", true);
		}
	}
	
	// margin of error: 1 millionth (used in distance tests)
	private static final double MARGIN = 1E-6;

	
	// locked tests
	public void test() {
		Point p = new Point(-1.3,1.6);
		assertEquals(Td(2115362407),p.x());
		assertEquals(Ti(2142157101),p.intX());
		assertEquals(Ts(242608020),p.toString());
		Point pp = new Point(-1.3,1.6);
		assertEquals(Tb(410198320),p.equals(pp));
		testcont(42);
	}
	
	private void testcont(int ignored) {
		Point o = new Point(0,0);
		Point p = new Point(3,4);
		Point q = new Point(-3,4);
		assertEquals(Td(198993428),p.distance(p));
		assertEquals(Td(169108823),p.distance(o)); // Think 3-4-5 triangle
		assertEquals(Td(708074442),p.distance(q)); 
	}
	
	
	/// test0N: Simple tests of constructor
	
	public void test00() {
		Point p = new Point(0,0);
		assertEquals(0.0,p.x());
	}
	
	public void test01() {
		Point p = new Point(0,0);
		assertEquals(0.0,p.y());
	}
	
	public void test02() {
		Point p = new Point(1.2,3.4);
		assertEquals(1.2,p.x());
	}
	
	public void test03() {
		Point p = new Point(1.2,3.4);
		assertEquals(3.4,p.y());
	}
	
	public void test04() {
		Point p = new Point(-4000.99,-0.00005);
		assertEquals(-4000.99,p.x());
	}
	
	public void test05() {
		Point p = new Point(-4000.99,-0.00005);
		assertEquals(-0.00005,p.y());
	}
	
	public void test06() {
		Point p = new Point(Math.E,-Math.PI);
		assertEquals(Math.E,p.x());
	}
	
	public void test07() {
		Point p = new Point(Math.E,-Math.PI);
		assertEquals(-Math.PI,p.y());
	}
	
	public void test08() {
		Point p = new Point(Double.MAX_VALUE,Double.NEGATIVE_INFINITY);
		assertEquals(Double.MAX_VALUE,p.x());
	}
	
	public void test09() {
		Point p = new Point(Double.MAX_VALUE,Double.NEGATIVE_INFINITY);
		assertEquals(Double.NEGATIVE_INFINITY,p.y());
	}
	
	
	/// test1N: tests of intX and intY
	
	public void test10() {
		Point p = new Point(1.0,-2.0);
		assertEquals(1,p.intX());
	}
	
	public void test11() {
		Point p = new Point(1.0,-2.0);
		assertEquals(-2,p.intY());
	}
	
	public void test12() {
		Point p = new Point(1.3,-1.6);
		assertEquals(1,p.intX());
	}
	
	public void test13() {
		Point p = new Point(1.3,-1.6);
		assertEquals(-2,p.intY());
	}
	
	public void test14() {
		Point p = new Point(-1.5,2.5);
		assertEquals(-1,p.intX());
	}
	
	public void test15() {
		Point p = new Point(-1.5,2.5);
		assertEquals(3,p.intY());
	}
	
	public void test16() {
		Point p = new Point(-2.5,3.5);
		assertEquals(-2,p.intX());
	}
	
	public void test17() {
		Point p = new Point(-2.5,3.5);
		assertEquals(4,p.intY());
	}
	
	public void test18() {
		Point p = new Point(1000.49999,-8888.500001);
		assertEquals(1000,p.intX());
	}
	
	public void test19() {
		Point p = new Point(1000.49999,-8888.500001);
		assertEquals(-8889,p.intY());
	}
	
	
	/// test2N: testing equals
	
	public void test20() {
		Point p = new Point(2,3);
		assertFalse(p.equals(null));
	}
	
	public void test21() {
		Point p = new Point(2,1);
		assertTrue(p.equals(p));
	}
	
	public void test22() {
		Object p = new Point(2,22);
		assertTrue(p.equals(new Point(2,22)));
	}
	
	public void test23() {
		Point p = new Point(2.000000001,3);
		assertFalse(p.equals(new Point(2,3)));
	}
	
	public void test24() {
		Point p = new Point(2.4,-4.2);
		assertTrue(p.equals(new Point(2.40,-4.20)));
	}
	
	public void test25() {
		Point p = new Point(2.5,5.2);
		assertFalse(p.equals(new Point(5.2,2.5)));
	}
	
	public void test26() {
		Point p = new Point(2.6,-6.2);
		assertFalse(p.equals(new Point(-2.6,6.2)));
	}
	
	public void test27() {
		Point p = new Point(0,0);
		assertFalse(p.equals(new Object()));
	}
	
	public void test28() {
		Point p = new Point(2,8);
		Object o = "(2.0,8.0)";
		assertFalse(p.equals(o));
	}
	
	public void test29() {
		Point p1 = new Point(5,0);
		Object p2 = new Point(5,0);
		assertTrue(p1.equals(p2));
	}

	/// test3N: testing hash code
	
	public void test30() {
		Point p1 = new Point(3,0);
		Point p2 = new Point(3,0);
		assertEquals(p1.hashCode(),p2.hashCode());
	}
	
	public void test31() {
		Point p1 = new Point(3,1);
		Point p2 = new Point(1,3);
		assertNotEquals(p1.hashCode(),p2.hashCode());
	}
	
	public void test32() {
		Point p1 = new Point(3,2);
		Point p2 = new Point(3.1,1.9);
		assertNotEquals(p1.hashCode(),p2.hashCode());
	}
	
	public void test33() {
		Point p1 = new Point(2,8);
		Point p2 = new Point(25,1);
		assertEquals(p1.hashCode(), p2.hashCode());
		assertFalse(p1.equals(p2));
	}

	public void test39() {
		for (int x1 = -9; x1 < 10; ++x1) {
			for (int y1 = -9; y1 < 10; ++y1) {
				Point p1 = new Point(x1,y1);
				for (int x2 = -9; x2 < 10; ++x2) {
					for (int y2 = -9; y2 < 10; ++y2) {
						Point p2 = new Point(x2,y2);
						if (x1 == x2 && y1 == y2) {
							assertEquals(p1.hashCode(),p2.hashCode());
						} else if (p1.hashCode() == p2.hashCode()){
							assertFalse("Both " + p1 + " and " + p2 + " have hashCode = " + p1.hashCode(),true);							assertNotEquals(p1.hashCode(),p2.hashCode());
						}
					}
				}
			}
		}
	}
	
	
	
	/// test4N: testing distance
	
	public void test40() {
		Point p = new Point(1.5,2.25);
		assertEquals(0,0,p.distance(new Point(1.5,2.25)));
	}
	
	public void test41() {
		Point p1 = new Point(4,1);
		Point p2 = new Point(4,2.5);
		assertEquals(1.5,p1.distance(p2));
	}
	
	public void test42() {
		Point p1 = new Point(4,2);
		Point p2 = new Point(2,2);
		assertEquals(2.0,p1.distance(p2));
	}
	
	public void test43() {
		Point p1 = new Point(4,3);
		Point p2 = new Point(0,0);
		assertEquals(5.0,p1.distance(p2));
	}
	
	public void test44() {
		Point p1 = new Point(4,4);
		Point p2 = new Point(3,3);
		assertEquals(Math.sqrt(2.0),p1.distance(p2),MARGIN);
	}
	
	public void test45() {
		Point p1 = new Point(4,-3);
		Point p2 = new Point(-4,3);
		assertEquals(10.0,p1.distance(p2));
	}
	
	public void test46() {
		Point p1 = new Point(4,-3);
		Point p2 = new Point(-4,3);
		assertEquals(10.0,p2.distance(p1));
	}

	public void test47() {
		Point p1 = new Point(0.375,0.5);
		Point p2 = new Point(0,0);
		assertEquals(0.625,p1.distance(p2));
	}
	
	public void test48() {
		Point p1 = new Point(1000,1000);
		Point p2 = new Point(0,0);
		assertEquals(1000*Math.sqrt(2),p2.distance(p1),MARGIN);
	}
}
