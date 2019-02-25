package collections.Test;

import collections.HANArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestArrayList
{

	private HANArrayList<Integer> list;

	@Before
	public void setUp()
	{
		this.list = new HANArrayList<Integer>();
	}

	@Test
	public void testAdd()
	{
		this.list.add(10);
		Assert.assertEquals(10, (int) this.list.get(0));
	}

	@Test
	public void testAddMultiple()
	{
		this.list.add(10);
		this.list.add(15);
		Assert.assertEquals(10, (int) this.list.get(0));
		Assert.assertEquals(15, (int) this.list.get(1));
	}

	@Test
	public void testAddMultipleExceedingInitialCapacity()
	{
		for (int i = 0; i < 100; i++)
		{
			this.list.add(i);
		}
		for (int i = 0; i < 100; i++)
		{
			Assert.assertEquals(i, (int) this.list.get(i));
		}
	}
}
