import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Point;
import edu.uwm.cs351.Vector;


public class TestVector extends LockedTestCase {

	private static final double MARGIN = 1E-6;

	
	/// testAx: testing first three constructors of Vector
	
	public void testA0(){
		Vector v1 = new Vector();
		assertEquals(Td(1125694579),v1.dx());
		assertEquals(Td(1710414720),v1.dy());
	}
	
	public void testA1(){
		Vector v1 = new Vector(1.2,3.4);
		assertEquals(1.2,v1.dx());
		assertEquals(3.4,v1.dy());
	}
	
	public void testA2(){
		Vector v2 = new Vector(5.6,7.8);
		assertEquals(5.6,v2.dx());
		assertEquals(7.8,v2.dy());
	}
	
	public void testA3(){
		Vector v1 = new Vector(0); // angle from x-axis
		assertEquals(Td(893182444),v1.dx(),MARGIN);
		assertEquals(Td(1285011119),v1.dy(),MARGIN);
	}
	
	public void testA4(){
		Vector v2 = new Vector(Math.PI);
		assertEquals(-1.0,v2.dx(),MARGIN);
		assertEquals(0,v2.dy(),MARGIN);
	}
	
	public void testA5(){
		Vector v3 = new Vector(Math.PI/2); // rotation is from x-axis toward y-axis
		assertEquals(Td(477431906),v3.dx(),MARGIN);
		assertEquals(Td(1462847911),v3.dy(),MARGIN);
	}
	
	public void testA6(){
		Vector v4 = new Vector(3*Math.PI/2);
		assertEquals(0.0,v4.dx(),MARGIN);
		assertEquals(-1.0,v4.dy(),MARGIN);
	}
	
	public void testA7(){
		Vector v5 = new Vector(2*Math.PI);
		assertEquals(1.0,v5.dx(),MARGIN);
		assertEquals(0.0,v5.dy(),MARGIN);
	}
	
	public void testA8(){
		Vector v7 = new Vector(-27*Math.PI/2);
		assertEquals(0.0,v7.dx(),MARGIN);
		assertEquals(1.0,v7.dy(),MARGIN);
	}
	
	public void testA9(){
		Vector v10 = new Vector(-1);
		assertEquals(0.540302305868139717,v10.dx(),MARGIN);
		assertEquals(-0.841470984807896507,v10.dy(),MARGIN);
	}
	
	
	/// testBx: testing the toString method
	
	public void testB0() {
		Vector v1 = new Vector();
		assertEquals("<0.0,0.0>",v1.toString());
	}

	public void testB1() {
		Vector v1 = new Vector(1.2,3.4);
		assertEquals("<1.2,3.4>",v1.toString());
	}

	public void testB2(){
		Vector v2 = new Vector(5.6,7.8);
		assertEquals("<5.6,7.8>",v2.toString());
	}
	
	public void testB3() {
		Vector v = new Vector(3,-5);
		assertEquals("<3.0,-5.0>", v.toString());
	}
	
	public void testB4() {
		Vector v = new Vector(1.23,4.56);
		assertEquals("<1.23,4.56>", v.toString());
	}
	
	public void testB5() {
		Vector v = new Vector(-100,0.001);
		assertEquals("<-100.0,0.001>", v.toString());
	}

	
	/// testCx: tests of "angle" (written for you)
	
	public void testC0(){
		Vector v0 = new Vector(0,2);
		assertEquals(Math.PI/2,v0.angle(),MARGIN);		
	}
	
	public void testC1(){
		Vector v1 = new Vector(-1);
		assertEquals(2*Math.PI-1.0,v1.angle(),MARGIN);		
	}
	
	
	protected void assertVector(String name, double dx, double dy, Vector v){
		assertEquals(name+" x",dx,v.dx(),MARGIN);
		assertEquals(name+" y",dy,v.dy(),MARGIN);
	}
	
	
	/// testDx: tests of Vector(Point,Point)
	
	public void testD0() {
		Point p1 = new Point(-1,0);
		Point p2 = new Point(1,2);
		Vector v = new Vector(p1,p2);
		assertEquals("v.dx()?", Ti(1511950364), v.dx(), MARGIN);
		assertEquals("v.dy()?", Ti(695871863), v.dy(), MARGIN);
	}
		
	public void testD1() {
		Point p1 = new Point(-1,0);		
		Vector v11 = new Vector(p1,p1);
		assertVector("p1->p1",0.0,0.0,v11);
	}
	
	public void testD2() {
		Point p1 = new Point(-1,0);
		Point p3 = new Point(3,-1);		
		Vector v13 = new Vector(p1,p3);
		assertVector("p1->p3",4.0,-1.0,v13);
	}
	
	public void testD3() {
		Point p1 = new Point(-1,0);
		Point p4 = new Point(-1,-1);
		Vector v14 = new Vector(p1,p4);
		assertVector("p1->p4",0.0,-1.0,v14);
	}
	
	public void testD4() {
		Point p2 = new Point(1,2);
		Point p3 = new Point(3,-1);
		Vector v23 = new Vector(p2,p3);
		assertVector("p2->p3",2.0,-3.0,v23);
	}
	
	public void testD5() {
		Point p1 = new Point(-1,0);
		Point p3 = new Point(3,-1);
		Vector v31 = new Vector(p3,p1);
		assertVector("p3->p1",-4.0,1.0,v31);
	}
	
	public void testD6() {
		Point p1 = new Point(-1,0);
		Point p4 = new Point(-1,-1);
		Vector v41 = new Vector(p4,p1);
		assertVector("p4->p1",0.0,1.0,v41);
	}
	
	public void testD7() {
		Point p2 = new Point(1,2);
		Point p4 = new Point(-1,-1);
		Vector v42 = new Vector(p4,p2);
		assertVector("p4->p2",2.0,3.0,v42);
	}
	
	public void testD8() {
		Point p3 = new Point(3,-1);
		Point p4 = new Point(-1,-1);
		Vector v43 = new Vector(p4,p3);
		assertVector("p4->p3",4.0,0.0,v43);
	}
	
	public void testD9() {
		Point p4 = new Point(-1,-1);
		Vector v44 = new Vector(p4,p4);
		assertVector("p4->p4",0.0,0.0,v44);
	}
	
	
	/// testEx: tests of "add"
	
	public void testE0(){
		Vector a = new Vector(1, 2);
		Vector b = new Vector(3, 4);
		Vector c = a.add(b);
		assertEquals("c.dx()?", Ti(994774524), c.dx(), MARGIN);
		assertEquals("c.dy()?", Ti(2129377820), c.dy(), MARGIN);
	}
	
	public void testE1(){
		Vector v1 = new Vector();
		assertVector("<0,0>+<0,0>",0,0,v1.add(v1));
	}
	
	public void testE2(){
		Vector v2 = new Vector(0,5);
		Vector v3 = new Vector(-2,0);
		assertVector("<0,5>+<-2,0>",-2,5,v2.add(v3));
	}
	
	public void testE3(){
		Vector v1 = new Vector();
		Vector v4 = new Vector(4,7.4);
		assertVector("<4,7.4>+<0,0>",4,7.4,v4.add(v1));
	}
	
	public void testE4(){
		Vector v4 = new Vector(4,7.4);
		assertVector("<4,7.4>+<4,7.4>",8,14.8,v4.add(v4));
	}
	
	public void testE5(){
		Vector v3 = new Vector(-2,0);
		Vector v5 = new Vector(30,-400);
		assertVector("<30,-400>+<-2,0>",28,-400,v5.add(v3));
	}
	
	public void testE6(){
		Vector v5 = new Vector(30,-400);
		Vector v6 = new Vector(10,10);
		assertVector("<30,-400>+<10,10>",40,-390,v5.add(v6));
	}
	
	public void testE7(){
		Vector v5 = new Vector(30,-400);
		Vector v7 = new Vector(-0.1,-0.1);
		assertVector("<30,-400>+<-0.1,-0.1>",29.9,-400.1,v5.add(v7));
	}
	
	public void testE8(){
		Vector v6 = new Vector(10,10);
		Vector v7 = new Vector(-0.1,-0.1);
		assertVector("<-0.1,-0.1>+<10,10>",9.9,9.9,v7.add(v6));
	}
	
	public void testE9(){
		Vector v7 = new Vector(-0.1,-0.1);
		assertVector("<-0.1,-0.1>+<-0.1,-0.1>",-0.2,-0.2,v7.add(v7));
	}
	
	
	/// testFx: tests of "dot"
	
	public void testF0(){
		Vector v1 = new Vector();
		Vector v2 = new Vector(0,1);
		Vector v3 = new Vector(1,0);
		assertEquals("<0,0> dot <0,0>",0.0d,v1.dot(v1));
		assertEquals("<0,1> dot <0,0>",0.0d,v2.dot(v1));
		assertEquals("<0,0> dot <1,0>",0.0d,v1.dot(v3));
	}
	
	public void testF1(){
		Vector v3 = new Vector(1,4);
		Vector v4 = new Vector(2,2);
		assertEquals("<2,2> dot <1,4>",Td(1219821749),v4.dot(v3));
	}
	
	public void testF2(){
		Vector v4 = new Vector(2,2);
		Vector v5 = new Vector(3,-3);
		// These two vectors are at a 90 degree angle: they are perpendicular.
		assertEquals("<3,-3> dot <2,2>",Td(704217999),v5.dot(v4));
	}
	
	public void testF3(){
		Vector v2 = new Vector(0,1);
		Vector v6 = new Vector(-3,3);
		assertEquals("<-3,3> dot <0,1>",3.0,v6.dot(v2));
	}
	
	public void testF4(){
		Vector v7 = new Vector(-9,-9);
		assertEquals("<-9,-9> dot <-9,-9>",162.0,v7.dot(v7));
	}
	
	public void testF5(){
		Vector v8 = new Vector(0.1,0.4);
		assertEquals("<0.1,0.4> dot <0.1,0.4>",0.17,v8.dot(v8),MARGIN);
	}
	
	public void testF6(){
		Vector v4 = new Vector(2,2);
		Vector v8 = new Vector(0.1,0.4);
		assertEquals("<0.1,0.4> dot <2,2>",1.0,v8.dot(v4),MARGIN);
	}
	
	public void testF7(){
		Vector v8 = new Vector(0.1,0.4);
		Vector v9 = new Vector(0.9,-0.2);
		assertEquals("<0.9,-0.2> dot <0.1,0.4>",0.01,v9.dot(v8),MARGIN);
	}
	
	public void testF8(){
		Vector v9 = new Vector(0.9,-0.2);
		assertEquals("<0.9,-0.2> dot <0.9,-0.2>",0.85,v9.dot(v9),MARGIN);
	}
	
	public void testF9(){
		Vector v8 = new Vector(0.1,0.4);
		Vector v10 = new Vector(1.7,100.1);
		assertEquals("<1.7,100.1> dot <0.1,0.4>",40.21,v10.dot(v8),MARGIN);
	}
	

	/// testGx: testing "move"
	
	public void testG0(){
		Point p = new Point(1,0);
		p = new Vector(3,5).move(p);
		assertEquals("p.getX()?", Ti(1736813547), p.intX());
		assertEquals("p.getY()?", Ti(1399660841), p.intY());
	}
	
	public void testG1(){
		Point p = new Point(1,0);
		p = new Vector(0, -0.5).move(p);
		assertEquals("p.getX()?", 1.0d, p.x(), MARGIN);
		assertEquals("p.getY()?", -0.5d, p.y(), MARGIN);
	}
	
	public void testG2(){		
		Point p1 = new Point(-1,0);
		Point p3 = new Point(3,-1);		
		Vector v13 = new Vector(p1,p3);
		assertEquals("p1->p3",p3,v13.move(p1));
	}	

	public void testG3(){		
		Point p2 = new Point(1,2);
		Point p4 = new Point(-1,-1);
		Vector v24 = new Vector(p2,p4);
		assertEquals("p2->p4",p4,v24.move(p2));
	}	

	public void testG4(){		
		Point p1 = new Point(-1,0);
		Point p3 = new Point(3,-1);
		Vector v31 = new Vector(p3,p1);
		assertEquals("p3->p1",p1,v31.move(p3));
	}	

	public void testG5(){		
		Point p3 = new Point(3,-1);
		Point p4 = new Point(-1,-1);
		Vector v43 = new Vector(p4,p3);
		assertEquals("p4->p3",p3,v43.move(p4));
	}
	
	public void testG6() {
		Point p3 = new Point(3.14159, 2.71828);
		assertEquals(p3, new Vector().move(p3));
	}
	
	
	/// testHx: testing "scale"
	
	public void testH0(){
		Vector v = new Vector(1.05,3.25).scale(2);
		assertEquals("dx of v?", Td(1099161973), v.dx());
		assertEquals("dy of v?", Td(1584670509), v.dy());
	}
	
	public void testH1(){
		Vector v1 = new Vector(1,2);
		v1.scale(42); // has no effect (v1 is unchanged)
		assertVector("<1,2>",1,2,v1);
	}
	
	public void testH2(){
		Vector v1 = new Vector();
		Vector v2 = v1.scale(10);
		assertVector("10*nil",0,0,v2);
	}
	
	public void testH3(){
		Vector v1 = new Vector(1,2);
		Vector v3 = v1.scale(-2);
		assertVector("-2*<1,2>",-2,-4,v3);
	}
	
	public void testH4(){
		Vector v1 = new Vector(1,2);
		Vector v4 = v1.scale(0.2);
		assertVector("0.2*<1,2>",0.2,0.4,v4);
	}
	
	public void testH5(){
		Vector v5 = new Vector(3,4);
		Vector v6 = v5.scale(10);
		assertVector("10*<3,4>",30,40,v6);
	}
	
	public void testH6(){
		Vector v5 = new Vector(3,4);
		Vector v7 = v5.scale(-2);
		assertVector("-2*<3,4>",-6,-8,v7);
	}
	
	public void testH7(){
		Vector v5 = new Vector(3,4);
		Vector v8 = v5.scale(0.2);
		assertVector("0.2*<3,4>",0.6,0.8,v8);
	}
	
	
	/// testJx: testing "rotate"
	
	public void testJ0(){
		Vector v = new Vector(4, 0).rotate(Math.PI/2); // rotate from x-axis toward y-axis
		assertEquals("dx of v?", Td(1054221436), v.dx(), MARGIN);
		assertEquals("dy of v?", Td(1654930987), v.dy(), MARGIN);
	}
	
	public void testJ1(){
		Vector v1 = new Vector(1,0);
		assertVector("v1",1,0,v1.rotate(0));
	}
	
	public void testJ2(){
		Vector v1 = new Vector(1,0);
		Vector v2 = v1.rotate(Math.PI);
		assertVector("v2",-1,0,v2);
	}
	
	public void testJ3(){
		Vector v1 = new Vector(1,0);
		Vector v2 = v1.rotate(Math.PI);
		Vector v3 = v2.rotate(3*Math.PI/2);
		assertVector("v3",0,1,v3);
	}
	
	public void testJ4(){
		Vector v1 = new Vector(1,0);
		Vector v2 = v1.rotate(Math.PI);
		Vector v3 = v2.rotate(3*Math.PI/2);
		Vector v4 = v3.rotate(-Math.PI);
		assertVector("v4",0,-1,v4);
	}
	
	public void testJ5(){
		Vector v1 = new Vector(1,0);
		Vector v5 = v1.rotate(1);
		assertVector("v5",0.540302305868139717,0.841470984807896507,v5);
	}
	
	public void testJ6(){
		Vector v7 = new Vector(7,0);
		Vector v8 = v7.rotate(Math.PI/4);
		assertVector("v6",Math.sqrt(2.0)*7/2,3.5*Math.sqrt(2.0),v8);
	}
	
	
	/// testMx: testing "magnitude"
	
	public void testM0(){
		Vector v1 = new Vector();
		assertEquals("<0,0>",0.0,v1.magnitude());
	}
	
	public void testM1(){
		Vector v2 = new Vector(3,4);
		assertEquals("<3,4>",Td(1025614320),v2.magnitude());
	}
	
	public void testM2(){
		Vector v3 = new Vector(-3,4);
		assertEquals("<-3,4>",5.0,v3.magnitude());
	}
	
	public void testM3(){
		Vector v4 = new Vector(-3,-4);
		assertEquals("<-3,-4>",5.0,v4.magnitude());
	}
	
	public void testM4(){
		Vector v5 = new Vector(3,-4);
		assertEquals("<3,-4>",5.0,v5.magnitude());
	}

	
	/// testNx: test "normalize"
	
	public void testN0(){
		Vector v1 = new Vector(0.5,1.2);
		Vector v1n = v1.normalize();
		assertEquals("Should be same (no expectation)",v1.angle(),v1n.angle(),MARGIN);
		assertEquals(1.3,v1.magnitude(),MARGIN);
		assertEquals(Td(781829223),v1n.magnitude(),MARGIN);
	}
	
	public void testN1(){
		Vector v2 = new Vector(-.3,-.4);
		Vector v2n = v2.normalize();
		assertEquals("Should be same (no expectation)",v2.angle(),v2n.angle(),MARGIN);
		assertEquals(0.5,v2.magnitude(),MARGIN);
		assertEquals(1.0,v2n.magnitude(),MARGIN);
	}
	
	public void testN2() {
		Vector v = new Vector(0,113);
		Vector vn = v.normalize();
		assertVector("normalized <0,113>",0,1,vn);
	}
	
	
	/// testPx: test "hash"
	
	public void testP1(){
		Vector v1 = new Vector(0,0);
		assertEquals(0,v1.hashCode());
	}
	
	public void testP2(){
		Vector v2 = new Vector(1,0);
		assertEquals(Ti(1973844719),v2.hashCode());
	}
	
	public void testP3(){
		Vector v3 = new Vector(0,1);
		assertEquals(Ti(1224400163),v3.hashCode());
	}
	
	public void testP4(){
		Vector v4 = new Vector(1.0/11.0,1.0/19.0);
		assertEquals(2,v4.hashCode());
	}
	
	
	/// testQx: test "equals"

	public void testQ0(){
		Vector v = new Vector(1,1);
		Vector v1 = new Vector(1, 1.0);
		assertEquals("v and v1 should be considered equal", true, v.equals(v1));
	}
		
	public void testQ1() {
		Vector v = new Vector(1,2);
		assertTrue(v.equals(v));
		assertTrue(v.equals(new Vector(1,2)));
	}
	
	public void testQ2() {
		Vector v = new Vector(1,2);
		assertFalse(v.equals(new Vector(1,1)));
		assertFalse(v.equals(new Vector(2,2)));
	}
	
	public void testQ3() {
		Vector v = new Vector(1,2);
		assertFalse(v.equals(new Vector(2,1)));
	}
	
	public void testQ4() {
		Vector v = new Vector(1,2);
		assertFalse(v.equals(new Vector(5,7)));
	}
	
	public void testQ5() {
		Vector v = new Vector(1,2);
		double small = 2E-6;
		
		Vector v1 = new Vector(1+small,2);
		Vector v2 = new Vector(1-small,2);
		assertFalse("Difference should be noticed",v.equals(v1));
		assertFalse("Difference should be noticed",v.equals(v2));
	}
	
	public void testQ6() {
		Vector v = new Vector(1,2);
		
		double small = 2E-6;
		
		Vector v3 = new Vector(1,small+2);
		Vector v4 = new Vector(1,2-small);
		assertFalse("Difference should be noticed",v.equals(v3));
		assertFalse("Difference should be noticed",v.equals(v4));
	}
	
	public void testQ7() {
		Vector v = new Vector(1,1);
		Object v1 = new Vector(1, 1.0);
		assertTrue(v.equals(v1));
	}
	
	public void testQ8() {
		Vector v = new Vector(1,1);
		Object v1 = new Vector(1, 1.0);
		assertTrue(v1.equals(v));
	}
	
	public void testQ9() {
		Vector v1 = new Vector(19,0);
		Vector v2 = new Vector(0,11);
		assertEquals(v1.hashCode(), v2.hashCode());
		assertFalse(v1.equals(v2));
	}
}
