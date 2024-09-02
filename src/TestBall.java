import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import edu.uwm.cs.junit.LockedTestCase;
import edu.uwm.cs351.Ball;
import edu.uwm.cs351.Point;
import edu.uwm.cs351.Vector;

public class TestBall extends LockedTestCase{

	private static final double MARGIN = 1E-6;
	private Ball b1, b2;
	private Vector v1;

	
	/// locked tests
	
	public void test() {
		b1 = new Ball(new Point(100,100),new Vector(10,0),Color.BLUE);
		b1.step();
		// What is x coordinate after this INACTIVE ball is stepped?
		assertEquals(Td(1253676109),b1.getLoc().x());
		// now we step it 11 more times: rotate 90 degrees clockwise
		for (int i=0; i < 11; ++i) { b1.step(); }
		// what is the vector movement in the y direction?
		assertEquals(Td(864349037),b1.getMove().dy(),MARGIN);
		testActive(true);
	}
	
	private void testActive(boolean ignored) {
		b1 = new Ball(new Point(100,100),new Vector(7,3),Color.BLUE);
		b1.launch();
		b1.step();
		// What is x coordinate after this ACTIVE ball is stepped?
		assertEquals(Td(1001721543),b1.getLoc().x());
		b1.step();
		// What is y coordinate after this ACTIVE ball is stepped TWICE?
		assertEquals(Td(920076623),b1.getLoc().y());
		testBounceWalls(false);
	}
		
	private void testBounceWalls(boolean ignored) {
		b1 = new Ball(new Point(100,100), new Vector(7,3), Color.BLUE); //rad = 15
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(Td(548002987),b1.getMove().dx()); // return current *movement*
		assertEquals(Td(743232787),b1.getMove().dy());
		b2 = new Ball(new Point(10,10), new Vector(8,-4), Color.RED);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(Td(775830929),b2.getMove().dx());
		assertEquals(Td(438479821),b2.getMove().dy());
	}
	
	
	/// test1X: test step on inactive balls.
	
	public void test10() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.step();
		assertEquals(Ball.DEFAULT_RADIUS, b1.getRadius());
	}
	
	public void test11() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.step();
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test12() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.step();
		Vector v1a = b1.getMove();
		assertEquals(3.5742,v1a.dx(),MARGIN);
	}
	
	public void test13() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.step();
		Vector v1a = b1.getMove();
		assertEquals(3.496439,v1a.dy(),MARGIN);
	}
	
	public void test14() {
		v1 = new Vector(1,1);
		b1 = new Ball(new Point(100,100), v1, Color.BLUE);
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		Vector v3 = b1.getMove();
		assertEquals(0,v3.dx(),MARGIN);
	}
	
	public void test15() {
		v1 = new Vector(1,1);
		b1 = new Ball(new Point(100,100), v1, Color.BLUE);
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		b1.step();
		Vector v3 = b1.getMove();
		assertEquals(1.414214,v3.dy(),MARGIN);
	}
	
	public void test18() {
		b1 = new Ball(new Point(100,100), new Vector(), Color.BLACK);
		b1.step();
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test19() {
		b1 = new Ball(new Point(100,100), new Vector(), Color.BLACK);
		b1.step();
		assertEquals(new Vector(0,0),b1.getMove());
	}
	
	
	/// test2N: test step with active balls
	
	public void test20() {
		b1 = new Ball(new Point(100,100), new Vector(), Color.BLACK);
		b1.launch();
		b1.step();
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(new Vector(),b1.getMove());
	}
	
	public void test21() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.launch();
		b1.step();
		assertEquals(new Point(104,103),b1.getLoc());
	}

	public void test22() {
		v1 = new Vector(4,3);
		b1 = new Ball(new Point(100,100), v1, Color.RED);
		b1.launch();
		b1.step();
		assertEquals(v1,b1.getMove());
	}
	
	public void test23() {
		v1 = new Vector(0.125,-5.15625);
		b1 = new Ball(new Point(100.5,100.15625),v1,Color.YELLOW);
		b1.launch();
		b1.step();
		assertEquals(new Point(100.625,95.0),b1.getLoc());
		assertEquals(-5.15625,b1.getMove().dy());
	}
	
	public void test24() {
		double third = 1.0/3.0;
		v1 = new Vector(third,-third);
		b1 = new Ball(new Point(200,300),v1,Color.CYAN);
		b1.launch();
		b1.step();
		b1.step();
		b1.step();
		assertEquals(201.0,b1.getLoc().x(),MARGIN);
		assertEquals(299.0,b1.getLoc().y(),MARGIN);
	}
	
	
	/// test 3N: test clone
	
	public void test30() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b2 = b1.clone();
		assertFalse(b1 == b2);
	}
	
	public void test31() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b2 = b1.clone();
		b1.step();
		assertEquals(new Vector(40,50),b2.getMove());
	}
	
	public void test32() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b2 = b1.clone();
		b1.launch();
		b1.step();
		assertEquals(new Point(20,30),b2.getLoc());
	}
	
	public void test33() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b2 = b1.clone();
		b1.launch();
		b2.step();
		assertEquals(new Point(20,30),b2.getLoc());
	}
	
	public void test34() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b2 = b1.clone();
		b1.launch();
		b2.step();
		assertEquals(33.1314848,b2.getMove().dx(),MARGIN);
	}
	
	public void test35() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		b1.launch();
		b2 = b1.clone();
		b2.step();
		assertEquals(new Point(60,80),b2.getLoc());
	}
	
	public void test36() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.MAGENTA);
		BufferedImage bm = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		b2 = b1.clone();
		b2.launch();
		b2.draw(bm.getGraphics());
		int[] data = (int[]) bm.getData().getDataElements(20, 30, null);
		assertEquals(Color.MAGENTA.getRGB(),data[0]);
	}
	
	public void test37() {
		b1 = new Ball(new Point(20,30),new Vector(40,50),Color.GREEN);
		BufferedImage bm = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
		b2 = b1.clone();
		b2.launch();
		b2.draw(bm.getGraphics());
		int[] data = (int[]) bm.getData().getDataElements(20, 30, null);
		assertEquals(Color.GREEN.getRGB(),data[0]);
	}
	
	public void test38() {
		class NewBall extends Ball {
			public NewBall() {
				super(new Point(90,80),new Vector(70,60),Color.PINK);
			}
		}
		b1 = new NewBall();
		b2 = b1.clone();
		assertTrue(b2 instanceof NewBall);
	}
	
	
	
	/// test4N: test isColliding
	
	public void test40() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		assertTrue(b1.isColliding(b1));
	}
	
	public void test41() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130,100),new Vector(3,3),Color.BLUE);
		assertTrue(b1.isColliding(b2));
		assertTrue(b2.isColliding(b1));
	}
	
	public void test42() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130,100),new Vector(3,3),Color.BLUE);
		b1.launch();
		b2.launch();
		assertTrue(b1.isColliding(b2));
		assertTrue(b2.isColliding(b1));
	}
	
	public void test43() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130,100),new Vector(3,3),Color.BLUE);
		b1.launch();
		b2.launch();
		b1.isColliding(b2);
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(new Vector(1,1),b1.getMove());
		assertEquals(new Point(130,100),b2.getLoc());
		assertEquals(new Vector(3,3),b2.getMove());
	}
	
	public void test44() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(100,130),new Vector(3,3),Color.BLUE);
		assertTrue(b1.isColliding(b2));
		assertTrue(b2.isColliding(b1));
	}
	
	public void test45() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130,130),new Vector(3,3),Color.BLUE);
		assertFalse(b1.isColliding(b2));
		assertFalse(b2.isColliding(b1));
	}
	
	public void test46() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(120,120),new Vector(3,3),Color.BLUE);
		assertTrue(b1.isColliding(b2));
		assertTrue(b2.isColliding(b1));
	}
	
	public void test47() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130.000000001,100),new Vector(3,3),Color.BLUE);
		assertFalse(b1.isColliding(b2));
		assertFalse(b2.isColliding(b1));
	}
	
	public void test48() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(100,130),new Vector(3,3),Color.BLUE);
		b2.setRadius(14);
		assertFalse(b1.isColliding(b2));
		assertFalse(b2.isColliding(b1));
	}
	
	public void test49() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		b2 = new Ball(new Point(130,130),new Vector(3,3),Color.BLUE);
		b1.setRadius(28);
		assertTrue(b1.isColliding(b2));
		assertTrue(b2.isColliding(b1));
	}
	
	
	/// test5N: testing type 0 collisions
	
	public void test50() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		Dimension d = new Dimension(200,200);
		b1.bounceWalls(d);
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test51() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		Dimension d = new Dimension(200,200);
		b1.bounceWalls(d);
		assertEquals(new Vector(1,1),b1.getMove());
	}
	
	public void test52() {
		b1 = new Ball(new Point(100,100),new Vector(1,1),Color.RED);
		Dimension d = new Dimension(200,200);
		b1.bounceWalls(d);
		assertEquals(15,b1.getRadius());
	}

	public void test53() {
		b1 = new Ball(new Point(100,100),new Vector(-1,1),Color.RED);
		b1.setRadius(99);
		Dimension d = new Dimension(200,200);
		b1.bounceWalls(d);
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(new Vector(-1,1),b1.getMove());
		assertEquals(99,b1.getRadius());
	}
	
	public void test54() {
		b1 = new Ball(new Point(100,100),new Vector(1,-1),Color.RED);
		b1.setRadius(1);
		Dimension d = new Dimension(102,102);
		b1.bounceWalls(d);
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(new Vector(1,-1),b1.getMove());
		assertEquals(1,b1.getRadius());
	}
	
	public void test55() {
		b1 = new Ball(new Point(1.5,1.5),new Vector(-1,-1),Color.RED);
		b1.setRadius(1);
		Dimension d = new Dimension(3,3);
		b1.bounceWalls(d);
		assertEquals(new Point(1.5,1.5),b1.getLoc());
		assertEquals(new Vector(-1,-1),b1.getMove());
		assertEquals(1,b1.getRadius());
	}
	
	
	/// test6N: Type 1 tests
	
	public void test60() {
		b1 = new Ball(new Point(100,100), new Vector(-1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test61() {
		b1 = new Ball(new Point(100,100), new Vector(-1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Vector(-1,0), b1.getMove());
	}

	public void test62() {
		b1 = new Ball(new Point(100,100), new Vector(-1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test63() {
		b1 = new Ball(new Point(100,100), new Vector(-1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(200,110));
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(15,b1.getRadius());
	}
	
	public void test64() {
		b1 = new Ball(new Point(100,100), new Vector(-1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(200,110));
		assertEquals(new Vector(-1,0),b1.getMove());
	}
	
	public void test65() {
		b2 = new Ball(new Point(10,20), new Vector(1,0), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(10,20),b2.getLoc());
	}
	
	public void test66() {
		b2 = new Ball(new Point(10,20), new Vector(1,0), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Vector(1,0), b2.getMove());
	}
	
	public void test67() {
		b2 = new Ball(new Point(10,20), new Vector(1,0), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(15,b2.getRadius());
	}
	
	public void test68() {
		b2 = new Ball(new Point(30,20), new Vector(-1,1), Color.YELLOW);
		b2.setRadius(25);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(25,b2.getRadius());
	}
	
	public void test69() {
		b2 = new Ball(new Point(30,20), new Vector(-1,1), Color.YELLOW);
		b2.setRadius(25);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Vector(-1,1), b2.getMove());
	}
	
	
	/// test7N: Type 2 tests
	
	public void test70() {
		b1 = new Ball(new Point(100,100), new Vector(1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test71() {
		b1 = new Ball(new Point(100,100), new Vector(1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Vector(-1,0), b1.getMove());
	}

	public void test72() {
		b1 = new Ball(new Point(100,100), new Vector(1,0),Color.BLUE);
		b1.bounceWalls(new Dimension(110,200));
		assertEquals(new Point(100,100),b1.getLoc());
	}
	
	public void test73() {
		b1 = new Ball(new Point(100,100), new Vector(-1,1),Color.BLUE);
		b1.bounceWalls(new Dimension(200,110));
		assertEquals(new Point(100,100),b1.getLoc());
		assertEquals(15,b1.getRadius());
	}
	
	public void test74() {
		b1 = new Ball(new Point(100,100), new Vector(-1,1),Color.BLUE);
		b1.bounceWalls(new Dimension(200,110));
		assertEquals(new Vector(-1,-1),b1.getMove());
	}
	
	public void test75() {
		b2 = new Ball(new Point(10,20), new Vector(-10,0), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(10,20),b2.getLoc());
	}
	
	public void test76() {
		b2 = new Ball(new Point(10,20), new Vector(-10,0), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Vector(10,0), b2.getMove());
	}
	
	public void test77() {
		b2 = new Ball(new Point(10,20), new Vector(-1,-2), Color.GREEN);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(15,b2.getRadius());
		assertEquals(new Vector(1,-2), b2.getMove());
	}
	
	public void test78() {
		b2 = new Ball(new Point(30,20), new Vector(-1,-2), Color.YELLOW);
		b2.setRadius(25);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(25,b2.getRadius());
		assertEquals(new Vector(-1,2), b2.getMove());
	}
	
	public void test79() {
		b2 = new Ball(new Point(20,30), new Vector(-1,-2), Color.YELLOW);
		b2.setRadius(25);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(20,30), b2.getLoc());
		assertEquals(25,b2.getRadius());
		assertEquals(new Vector(1,-2), b2.getMove());
	}
	
	
	/// test8N: Type 3 collisions with no y bounce
	
	public void test80() {
		b1 = new Ball(new Point(100,100), new Vector(-2,-3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Point(100,100), b1.getLoc());
		assertEquals(15,b1.getRadius());
	}
	
	public void test81() {
		b1 = new Ball(new Point(100,100), new Vector(-2,-3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Vector(-2,-3),b1.getMove());
	}
	
	public void test82() {
		b1 = new Ball(new Point(100,100), new Vector(2,-3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Point(100,100), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,-3),b1.getMove());
	}
	
	public void test83() {
		b2 = new Ball(new Point(30,20), new Vector(2,3), Color.LIGHT_GRAY);
		b2.setRadius(30);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(30,b2.getRadius());
		assertEquals(new Vector(2,3),b2.getMove());
	}
	
	public void test84() {
		b2 = new Ball(new Point(30,20), new Vector(-2,3), Color.LIGHT_GRAY);
		b2.setRadius(30);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(30,b2.getRadius());
		assertEquals(new Vector(2,3),b2.getMove());
	}
	
	public void test85() {
		b1 = new Ball(new Point(85,10), new Vector(-2,3), Color.DARK_GRAY);
		b1.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(85,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,3),b1.getMove());
	}

	public void test86() {
		b1 = new Ball(new Point(85,10), new Vector(2,3), Color.DARK_GRAY);
		b1.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(85,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,3),b1.getMove());
	}

	public void test87() {
		b2 = new Ball(new Point(20,80), new Vector(2,-3), Color.WHITE);
		b2.setRadius(20);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(20,80), b2.getLoc());
		assertEquals(20,b2.getRadius());
		assertEquals(new Vector(2,-3),b2.getMove());
	}

	public void test88() {
		b2 = new Ball(new Point(20,80), new Vector(-2,-3), Color.WHITE);
		b2.setRadius(20);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(20,80), b2.getLoc());
		assertEquals(20,b2.getRadius());
		assertEquals(new Vector(2,-3),b2.getMove());
	}
	
	public void test89() {
		b1 = new Ball(new Point(10,10), new Vector(0,2), Color.BLACK);
		b1.bounceWalls(new Dimension(20,100));
		assertEquals(new Point(10,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(0,2),b1.getMove());
	}
	
	/// test8N: Type 3 collisions with y bounce
	
	public void test90() {
		b1 = new Ball(new Point(100,100), new Vector(-2,3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Point(100,100), b1.getLoc());
		assertEquals(15,b1.getRadius());
	}
	
	public void test91() {
		b1 = new Ball(new Point(100,100), new Vector(-2,3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Vector(-2,-3),b1.getMove());
	}
	
	public void test92() {
		b1 = new Ball(new Point(100,100), new Vector(2,3), Color.GRAY);
		b1.bounceWalls(new Dimension(110,110));
		assertEquals(new Point(100,100), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,-3),b1.getMove());
	}
	
	public void test93() {
		b2 = new Ball(new Point(30,20), new Vector(2,-3), Color.LIGHT_GRAY);
		b2.setRadius(30);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(30,b2.getRadius());
		assertEquals(new Vector(2,3),b2.getMove());
	}
	
	public void test94() {
		b2 = new Ball(new Point(30,20), new Vector(-2,-3), Color.LIGHT_GRAY);
		b2.setRadius(30);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(30,20), b2.getLoc());
		assertEquals(30,b2.getRadius());
		assertEquals(new Vector(2,3),b2.getMove());
	}
	
	public void test95() {
		b1 = new Ball(new Point(85,10), new Vector(-2,-3), Color.DARK_GRAY);
		b1.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(85,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,3),b1.getMove());
	}

	public void test96() {
		b1 = new Ball(new Point(85,10), new Vector(2,-3), Color.DARK_GRAY);
		b1.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(85,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(-2,3),b1.getMove());
	}

	public void test97() {
		b2 = new Ball(new Point(20,80), new Vector(2,3), Color.WHITE);
		b2.setRadius(20);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(20,80), b2.getLoc());
		assertEquals(20,b2.getRadius());
		assertEquals(new Vector(2,-3),b2.getMove());
	}

	public void test98() {
		b2 = new Ball(new Point(20,80), new Vector(-2,3), Color.WHITE);
		b2.setRadius(20);
		b2.bounceWalls(new Dimension(100,100));
		assertEquals(new Point(20,80), b2.getLoc());
		assertEquals(20,b2.getRadius());
		assertEquals(new Vector(2,-3),b2.getMove());
	}
	
	public void test99() {
		b1 = new Ball(new Point(10,10), new Vector(0,-2), Color.BLACK);
		b1.bounceWalls(new Dimension(20,100));
		assertEquals(new Point(10,10), b1.getLoc());
		assertEquals(15,b1.getRadius());
		assertEquals(new Vector(0,2),b1.getMove());
	}
}
