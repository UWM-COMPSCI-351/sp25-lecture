import edu.uwm.cs351.Bag;
import edu.uwm.cs351.Coin;
import edu.uwm.cs351.DynamicArrayBag;
import junit.framework.TestCase;

public class TestBag extends TestCase {
	protected Bag self;
	
	public Coin c1a, c1b, c1c, c1d, c5a, c5b, c5c, c5d, c10a, c10b, c10c;
	public Coin c25a, c25b, c25c, c50a, c50b;
	
	protected void setUp() {
		self = new DynamicArrayBag(); // change to be a specific bag class, e.g. LinkedListBag
		c1a = new Coin(1, 2000);
		c1b = new Coin(1, 2001);
		c1c = new Coin(1, 2002);
		c1d = new Coin(1, 2003);
		c5a = new Coin(5, 2004);
		c5b = new Coin(5, 2005);
		c5c = new Coin(5, 2006);
		c10a = new Coin(10, 2010);
		c10b = new Coin(10, 2011);
		c10c = new Coin(10, 2012);
		c25a = new Coin(25, 2013);
		c25b = new Coin(25, 2014);
		c25c = new Coin(25, 2015);
		c50a = new Coin(50, 2016);
		c50b = new Coin(50, 2017);
	}
	
	// Tests for sample midterm
	
	public void test90() {
		assertEquals(0,self.removeAll(c5a));
		assertTrue(self.isEmpty());
	}
	
	public void test91() {
		self.add(c10a);
		assertEquals(1, self.removeAll(c10b));
		assertEquals(true, self.isEmpty());
	}
	
	public void test92() {
		self.add(c10a);
		self.removeAll(c5a);
		assertEquals(false, self.isEmpty());
		assertSame(c10a, self.remove());
		assertEquals(true, self.isEmpty());
	}
}
